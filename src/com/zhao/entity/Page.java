package com.zhao.entity;

public class Page {
	int total; //总页数
	int eachPage=5;//每页数量
	
	int nextPage; //下一页数
	int currentPage;//当前页数

	int currentCount;
	
	public int getEachPage() {
		return eachPage;
	}
	public void setEachPage(int eachPage) {
		this.eachPage = eachPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getCurrentPage() {
		
		return currentPage;
	}
	public int getCurrentCount() {
		currentCount=currentPage*eachPage;
		return currentCount;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	
	
	

	
	

}
