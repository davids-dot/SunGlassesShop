package com.zhao.service.impl;

import java.util.List;

import com.zhao.dao.ShopDao;
import com.zhao.dao.impl.DayTransactionDaoImpl;
import com.zhao.dao.impl.GoodsDaoImpl;
import com.zhao.dao.impl.ShopDaoImpl;
import com.zhao.entity.DayTransactionAmount;
import com.zhao.entity.PageBean;
import com.zhao.entity.QueryInfo;
import com.zhao.entity.QueryResult;
import com.zhao.service.ManagerService;

public class ManageServiceImpl implements ManagerService {

	@Override
	public void verifyShop(String shopName) {

	}

	@Override
	public PageBean queryShopRank(QueryInfo queryInfo) {

		ShopDao sdao = new ShopDaoImpl();

		QueryResult qr = sdao.queryShopRank(queryInfo);
		PageBean page = new PageBean(queryInfo.getCurrentPage(), queryInfo.getPageSize(), qr.getTotalRecords());
		page.setList(qr.getList());

		return page;
	}

	@Override
	public List<DayTransactionAmount> queryDayAmount() {
		DayTransactionDaoImpl ddao = new DayTransactionDaoImpl();

		return ddao.queryDayAmount();
	}

}
