package com.zhao.entity;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.zhao.dao.impl.GoodsDaoImpl;
import com.zhao.util.BeanListHandler;
import com.zhao.util.DBUtil2;

public class Cart {

	private Integer customer_id;
	private List<CartItem> items;

	private Cart(Integer customer_id) {
		this.customer_id = customer_id;
		this.items = new LinkedList<CartItem>();//
	}

	public List<CartItem> getItems() {
		return items;
	}

	public Double getTotalPrice() {

		Iterator<CartItem> it = getItems().iterator();
		BigDecimal bd = new BigDecimal(0);

		while (it.hasNext()) {
			CartItem item = it.next();
			Goods goods = item.getGoods();
			bd = bd.add(new BigDecimal(goods.getPrice()).multiply(new BigDecimal(item.getNum())));
		}

		return bd.doubleValue();
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	@SuppressWarnings("unchecked")
	public static Cart getCart(Integer customer_id) {

		try {
			Cart cart = new Cart(customer_id);
			String sql = "select goods_id,num,shop_id from cart_detail where customer_id = ? ";
			cart.setItems((List<CartItem>) DBUtil2.executeQuery(sql,
					new BeanListHandler<CartItem>(CartItem.class),
					customer_id));
			// 每个cartItem 都有了 goods_id,num,shop_id

			/*
			 * 为每个cartItem 添加商品详细信息
			 */
			GoodsDaoImpl gdao = new GoodsDaoImpl();
			Iterator<CartItem> it = cart.getItems().iterator();
			while (it.hasNext()) {
				CartItem item = it.next();
				item.setGoods(gdao.find("goods_id", item.getGoods_id()));
				item.setStock(gdao.findStock(item.getGoods_id(), item.getShop_id()));
			}

			return cart;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
