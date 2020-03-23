package com.zhao.entity;

import java.util.List;

/*
 * pagenation about
 */
public class QueryResult {

	private List<? extends Object> list;
	private int totalRecords;

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

}
