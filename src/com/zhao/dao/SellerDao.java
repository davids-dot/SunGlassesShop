package com.zhao.dao;

import com.zhao.entity.Seller;

public interface SellerDao {

	public void addSeller(Seller sel);

	/*
	 * 商家信息确认时，更改商家信息
	 */
	public void updateSeller(Seller sel, String name);

	public Seller findSeller(String name);

}
