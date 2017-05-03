package com.zhao.dao;

import java.sql.SQLException;

import com.zhao.entity.Goods;
import com.zhao.entity.Seller;
import com.zhao.entity.Shop;

public interface SellerDao {

	public void addSeller(Seller sel);

	/*
	 * 商家信息确认时，更改商家信息
	 */
	public void updateSeller(Seller sel, String name);

	public Seller findSeller(String name);

	// 向 商家商铺添加商品
	public void addGoodsToShop(Seller sel, Goods goods, Shop shop) throws SQLException;

	public boolean existGoodsInShop(Goods goods, Shop shop);

	// public Shop findShop(Seller sel);

}
