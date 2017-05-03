package com.zhao.dao;

import com.zhao.entity.Goods;
import com.zhao.entity.Shop;

public interface ShopDao {

	public void addShop(Shop shop);

	public void changeStatus(String name);

	public Shop findShop(Integer integer);

	public boolean existGoods(Shop shop, Goods goods);

}
