package com.zhao.service;

import java.util.List;

import com.zhao.entity.Goods;
import com.zhao.entity.PageBean;
import com.zhao.entity.QueryInfo;
import com.zhao.entity.Seller;
import com.zhao.entity.Shop;
import com.zhao.exception.IllegalException;

public interface SellerService {

	public void changeInfo(Seller sel, String name);

	/*
	 * @param shop 中seller_id 已设置
	 */
	public void addShop(Shop shop);

	public Seller findSeller(String name);

	public Integer ensureStatus(Seller sel);

	public void addToShop(Seller sel, Goods goods);

	public List<Goods> queryGoods(Seller sel) throws IllegalException;

	public PageBean queryGoods(Seller sel, QueryInfo queryInfo) throws IllegalException;
}
