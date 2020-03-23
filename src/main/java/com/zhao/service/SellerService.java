package com.zhao.service;

import java.util.List;

import com.zhao.entity.Goods;
import com.zhao.entity.Order;
import com.zhao.entity.PageBean;
import com.zhao.entity.QueryInfo;
import com.zhao.entity.Seller;
import com.zhao.entity.Shop;
import com.zhao.exception.IllegalException;
import com.zhao.servlet.OrderType;

public interface SellerService {

	public void changeInfo(Seller sel, String name);

	/*
	 * @param shop 中seller_id 已设置
	 */
	public void addShop(Shop shop);

	public Shop findShop(Integer seller_id);

	public Seller findSeller(String name);

	public Order findOrder(Long order_id);

	public Integer ensureStatus(Seller sel);

	public void addToShop(Seller sel, Goods goods);

	public List<Goods> queryGoods(Seller sel) throws IllegalException;

	public PageBean queryGoods(Seller sel, QueryInfo queryInfo) throws IllegalException;

	public PageBean queryOrder(OrderType type, Integer shop_id, QueryInfo queryInfo);
}
