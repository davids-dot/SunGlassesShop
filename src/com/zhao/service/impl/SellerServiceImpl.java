package com.zhao.service.impl;

import com.zhao.dao.SellerDao;
import com.zhao.dao.impl.SellerDaoImpl;
import com.zhao.entity.Seller;
import com.zhao.entity.Shop;
import com.zhao.service.SellerService;

public class SellerServiceImpl implements SellerService {

	public SellerServiceImpl() {

	}

	@Override
	public void changeInfo(Seller sel, String name) {
		SellerDao sdao = new SellerDaoImpl();
		sdao.updateSeller(sel, name);
	}

	@Override
	public void addShop(Shop shop) {

	}

	@Override
	public Seller findSeller(String name) {

		SellerDao sdao = new SellerDaoImpl();
		return sdao.findSeller(name);

	}

	public static void main(String[] args) {

	}

}
