package com.zhao.dao;

import java.util.List;
import java.util.Map;

import com.zhao.entity.Order;
import com.zhao.entity.QueryInfo;
import com.zhao.entity.QueryResult;
import com.zhao.servlet.OrderType;

public interface OrderDao {

	public void addOrder(Order order);

	public boolean existOrder(Long order_id);

	void changeOrderStatus(Long order_id, Integer status);

	// findOrder(Integer order_id) ,可通过 queryOrders 来实现
	public List<Order> queryOrders(Map<String, Object> params);

	public QueryResult querySomeOrders(Integer customer_id, int startIndex, int pageSize);

	public QueryResult querySomeOrders(Map<String, Object> queryParam, int startIndex, int pageSize);

	public QueryResult querySellerOrder(OrderType type, Integer shop_id, QueryInfo queryInfo);

}
