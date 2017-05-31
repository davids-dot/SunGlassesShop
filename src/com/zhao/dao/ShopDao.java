package com.zhao.dao;

import com.zhao.entity.Goods;
import com.zhao.entity.QueryInfo;
import com.zhao.entity.QueryResult;
import com.zhao.entity.Seller;
import com.zhao.entity.Shop;

public interface ShopDao {

	public void addShop(Shop shop);

	public void changeStatus(String name);

	public Shop findShop(Integer seller_id);

	public boolean existGoods(Shop shop, Goods goods);

	QueryResult queryShopRank(QueryInfo queryInfo);

	Seller findSeller(Integer shop_id);

	public String findAttribute(String string, Integer shop_id);

}
