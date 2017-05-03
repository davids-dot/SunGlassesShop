package com.zhao.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.zhao.dao.impl.GoodsDaoImpl;

public class Order {

	private Long order_id;
	private Integer customer_id;
	private Integer status;
	private List<OrderDetail> items;

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

	public List<OrderDetail> getItems() {
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

		Iterator<OrderDetail> it = items.iterator();
		BigDecimal bd = new BigDecimal(0);

		while (it.hasNext()) {
			OrderDetail od = it.next();
			bd = bd.add(new BigDecimal(od.getGoods().getPrice()));
		}

		return bd.doubleValue();
	}

	public String toString() {
		String s = "customer_id:" + customer_id + "\norder_id:" + order_id + "\nstatus:" + status + "\n";
		if (items == null)
			return s;
		return s + items.toString();
	}

}
