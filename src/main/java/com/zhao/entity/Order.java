package com.zhao.entity;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.zhao.dao.impl.CustomerDaoImpl;
import com.zhao.dao.impl.GoodsDaoImpl;
import com.zhao.util.BeanListHandler;
import com.zhao.util.DBUtil2;

public class Order {

	private Long order_id;
	private Integer customer_id;
	private Integer status;
	private List<OrderDetail> items;

	private String customerName;

	public Order() {

	}

	// 产生确定顾客的订单 , order 所有属性都赋值
	public Order(Integer customer_id, List<DefinitizedGoods> dgoods) {
		this.customer_id = customer_id;
		this.status = 0;
		items = new ArrayList<OrderDetail>();

		Iterator<DefinitizedGoods> it = dgoods.iterator();
		while (it.hasNext()) {
			DefinitizedGoods dg = it.next();
			// OrderDetail(goods_id,shop_id,num) //dg.shop_id 赋值错误
			items.add(new OrderDetail(dg.getGoods_id(), dg.getShop_id(), 1));
		}

		createOrder_id();

	}

	public Order(Integer customer_id, ArrayList<CartItem> cartItems) {
		this.customer_id = customer_id;
		this.status = 0;
		items = new ArrayList<OrderDetail>();

		Iterator<CartItem> it = cartItems.iterator();
		while (it.hasNext()) {
			CartItem cartItem = it.next();
			// OrderDetail(goods_id,shop_id,num) //dg.shop_id 赋值错误
			items.add(new OrderDetail(cartItem.getGoods_id(), cartItem.getShop_id(), cartItem.getNum()));
		}

		createOrder_id();

	}

	private void createOrder_id() {
		int o1 = (int) (Math.random() * 10);
		int o2 = (int) (Math.random() * 10);
		Long o3 = System.currentTimeMillis();
		String odno = String.valueOf(o1) + String.valueOf(o2) + String.valueOf(o3);
		this.order_id = Long.parseLong(odno);
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	@SuppressWarnings("unchecked")
	public List<OrderDetail> getItems() {
		if (items != null)
			return items;

		try {
			String sql = "select goods_id,shop_id,num from Order_detail where order_id = ? ";

			setItems((List<OrderDetail>) DBUtil2.executeQuery(sql,
					new BeanListHandler<OrderDetail>(OrderDetail.class),
					getOrder_id()));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return items;
	}

	public void setItems(List<OrderDetail> items) {
		this.items = items;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Double getTotalPrice() {

		Iterator<OrderDetail> it = getItems().iterator();
		BigDecimal bd = new BigDecimal(0);

		while (it.hasNext()) {
			OrderDetail od = it.next();
			bd = bd.add(new BigDecimal(od.getGoods().getPrice() * od.getNum()));
		}

		return bd.doubleValue();
	}

	public String toString() {
		String s = "customer_id:" + customer_id + "\norder_id:" + order_id + "\nstatus:" + status + "\n";
		if (items == null)
			return s;
		return s + items.toString();
	}

	public String getCustomerName() {
		if (customerName != null)
			return customerName;
		CustomerDaoImpl cdao = new CustomerDaoImpl();
		this.customerName = cdao.find("customer_id", this.getCustomer_id()).getName();
		return customerName;
	}

}
