package com.zhao.entity;

import java.util.List;

public class PageBean {

	private List<? extends Object> list;

	private int totalRecords;
	private int currentPage;
	private int totalPage;
	private int pageSize; // 一页容纳的记录数
	private int[] pageBar;

	private static final int PAGEMAX = 10; // 页面底部最多可显示的页码数

	public PageBean() {

	}

	public PageBean(int currentPage2, int pageSize2, int totalRecords) {
		this.currentPage = currentPage2;
		this.pageSize = pageSize2;
		this.totalRecords = totalRecords;
	}

	//
	public List<? extends Object> getList() {
		return list;
	}

	public void setList(List<? extends Object> list) {
		this.list = list;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPrevious() {
		if (this.currentPage == 1)
			return 1;
		return this.currentPage - 1;
	}

	public int getNext() {
		if (this.currentPage == this.totalPage) {
			return this.totalPage;
		}
		return this.currentPage + 1;
	}

	/*
	 * pageSize 要设定
	 */

	public int getTotalPage() {

		if (this.getTotalRecords() == 0)
			return 0;

		this.totalPage = (this.totalRecords - 1) / this.pageSize + 1;
		return totalPage;
	}

	public int[] getPageBar() {

		if (this.totalPage < PAGEMAX) {
			pageBar = new int[this.totalPage];
			for (int i = 0; i < this.totalPage; i++) {
				pageBar[i] = i + 1;
			}
			return pageBar;
		} // 1....x 页， x < 10

		pageBar = new int[PAGEMAX];
		for (int i = 0; i < PAGEMAX; i++) {
			pageBar[i] = this.currentPage + i;
		}

		return pageBar;
	}

}
