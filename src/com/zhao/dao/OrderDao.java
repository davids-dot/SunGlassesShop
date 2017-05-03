package com.zhao.dao;

import java.util.List;
import java.util.Map;

import com.zhao.entity.Order;

public interface OrderDao {

	public void addOrder(Order order);

	public boolean existOrder(Long order_id);

	void changeOrderStatus(Long order_id, Integer status);

	public List<Order> queryOrders(Map<String, Object> params);
}
