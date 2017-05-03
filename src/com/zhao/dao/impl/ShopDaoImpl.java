package com.zhao.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.zhao.dao.ShopDao;
import com.zhao.entity.Goods;
import com.zhao.entity.Shop;
import com.zhao.util.BeanHandler;
import com.zhao.util.DBUtil;
import com.zhao.util.DBUtil2;
import com.zhao.util.IsNullHandler;

public class ShopDaoImpl implements ShopDao {

	/*
	 * (non-Javadoc)带有seller_id 的shop 添加到数据库，商铺未验证
	 * 
	 * @see com.zhao.dao.ShopDao#addShop(com.zhao.entity.Shop)
	 */
	@Override
	public void addShop(Shop shop) {

		String sql = "insert into  Shop(name,logoURI,seller_id,verifyInfo) values(?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(shop.getName());
		params.add(shop.getLogoURI());
		params.add(shop.getSeller_id());
		params.add(shop.getVerifyInfo());
		try {
			DBUtil2.executeUpdate(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void changeStatus(String name) {

	}

	/*
	 * @param 找出某个商家的shop
	 * 
	 * @see com.zhao.dao.ShopDao#findShop(java.lang.Integer)
	 */
	@Override
	public Shop findShop(Integer seller_id) {

		String sql = " select * from  shop  where seller_id = ? ";
		try {
			return (Shop) DBUtil2.executeQuery(sql, Arrays.asList(seller_id), new BeanHandler<Shop>(Shop.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean existGoods(Shop shop, Goods goods) {
		String sql = "select shop_id from shop_has_goods where goods_id = ? and shop_id= ? ";
		try {
			return (boolean) DBUtil2.executeQuery(sql, Arrays.asList(goods.getGoods_id(), shop.getShop_id()),
					new IsNullHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
