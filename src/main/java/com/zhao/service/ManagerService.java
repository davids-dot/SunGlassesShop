package com.zhao.service;

import java.util.List;

import com.zhao.entity.DayTransactionAmount;
import com.zhao.entity.PageBean;
import com.zhao.entity.QueryInfo;

public interface ManagerService {

	public void verifyShop(String shopName);

	public PageBean queryShopRank(QueryInfo queryInfo);

	//
	public List<DayTransactionAmount> queryDayAmount();

}
