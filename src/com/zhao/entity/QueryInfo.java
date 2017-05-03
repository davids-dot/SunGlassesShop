package com.zhao.entity;

/*
 * paganation about
 */

public class QueryInfo {

	private int currentPage;
	private int pageSize;
	private int startIndex;

	public QueryInfo() {
		this.currentPage = 1;
		this.pageSize = 5;
		this.startIndex = 0;

	}

	public QueryInfo(int cur, int page, int start) {
		this.currentPage = cur;
		this.pageSize = page;
		this.startIndex = start;
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

	public int getStartIndex() {
		startIndex = (this.currentPage - 1) * this.pageSize;
		return startIndex;
	}

}
