package com.zhao.dao.impl;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.zhao.dao.CartDao;
import com.zhao.entity.Cart;
import com.zhao.entity.CartItem;
import com.zhao.entity.Goods;
import com.zhao.util.BeanListHandler;
import com.zhao.util.DBUtil2;

public class CartDaoImpl implements CartDao {

	/*
	 * cart 中customer_id ,item 中goods_id,shop_id,num,shop_id必须有值
	 * 
	 * @see com.zhao.dao.CartDao#addToCart(com.zhao.entity.CartItem,
	 * com.zhao.entity.Cart) 从数据库中查询用户的cart
	 */

	@Override
	public void addToCart(CartItem item, Cart cart) {

		String sql = "insert into Cart_Detail(customer_id,goods_id,num,shop_id) values(?,?,?,?)";
		try {
			DBUtil2.executeUpdate(sql,
					Arrays.asList(cart.getCustomer_id(), item.getGoods_id(), item.getNum(), item.getShop_id()));
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAll(CartItem cart) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addNums(CartItem cartItem, Cart cart) {
		String sql = "update Cart_Detail set num=? where goods_id=? and shop_id = ? and customer_id = ? ";
		try {
			DBUtil2.executeUpdate(sql, Arrays.asList(cartItem.getNum(), cartItem.getGoods_id(), cartItem.getShop_id(),
					cart.getCustomer_id()));
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void removeFromCart(Integer goods_id, Integer shop_id, Cart cart) {
		String sql = "delete from Cart_Detail where goods_id=? and shop_id = ? and customer_id = ? ";
		try {
			DBUtil2.executeUpdate(sql, Arrays.asList(goods_id, shop_id, cart.getCustomer_id()));
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}