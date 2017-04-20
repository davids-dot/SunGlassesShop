package com.zhao.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhao.dao.ShopDao;
import com.zhao.entity.Shop;
import com.zhao.util.DBUtil2;

public class ShopDaoImpl implements ShopDao {

	@Override
	public void addShop(Shop shop) {
		String sql = "insert into  Shop(name,logoURI,seller_id) values(?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(shop.getName());
		params.add(shop.getLogoURI());
		params.add(shop.getSeller_id());
		try {
			DBUtil2.executeUpdate(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void changeStatus(String name) {

	}

}
