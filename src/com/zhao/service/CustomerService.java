package com.zhao.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zhao.entity.Cart;
import com.zhao.entity.CartItem;
import com.zhao.entity.Customer;
import com.zhao.entity.Goods;
import com.zhao.entity.Order;
import com.zhao.entity.PageBean;
import com.zhao.entity.QueryInfo;
import com.zhao.exception.IllegalException;
import com.zhao.exception.NoAvailableGoodsException;

public interface CustomerService {

	public List<Goods> showGoods();

	public List<Goods> newFourGoods();

	public PageBean bestGoodsList(QueryInfo queryInfo);

	public Goods findGoodsById(Goods goods) throws IllegalException;

	public void addToCart(Integer goods_id, Cart cart) throws NoAvailableGoodsException;

	public Customer find(String name);

	public Cart getCart(Integer customer_id);

	public void deleteFromCart(Integer goods_id, Cart cart, Integer shop_id);

	public Order buyGoods(Integer goods_id, Integer customer_id) throws NoAvailableGoodsException;

	public Order buyGoods(Cart cart);

	public Order buyGoods(ArrayList<CartItem> items, Integer custoemr_id);

	public List<Order> queryOrders(Integer customer_id);

	public Order pay(Long order_id);

	public void payConfirm(Long order_id);

	public PageBean querySomeOrders(Integer customer_id, QueryInfo queryInfo);

	public PageBean querySomeOrders(Map<String, Object> queryParam, QueryInfo request2QueryInfo);
}
