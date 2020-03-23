package com.zhao.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhao.dao.CartDao;
import com.zhao.dao.OrderDao;
import com.zhao.dao.impl.CartDaoImpl;
import com.zhao.dao.impl.CustomerDaoImpl;
import com.zhao.dao.impl.GoodsDaoImpl;
import com.zhao.dao.impl.OrderDaoImpl;
import com.zhao.entity.Cart;
import com.zhao.entity.CartItem;
import com.zhao.entity.CartItemFactory;
import com.zhao.entity.CartItemFactoryDefault;
import com.zhao.entity.Customer;
import com.zhao.entity.DefinitizedGoods;
import com.zhao.entity.Goods;
import com.zhao.entity.Order;
import com.zhao.entity.PageBean;
import com.zhao.entity.QueryInfo;
import com.zhao.entity.QueryResult;
import com.zhao.exception.IllegalException;
import com.zhao.exception.NoAvailableGoodsException;
import com.zhao.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public List<Goods> showGoods() {

		GoodsDaoImpl gdao = new GoodsDaoImpl();
		return gdao.queryAll();

	}

	@Override
	public List<Goods> newFourGoods() {
		GoodsDaoImpl gdao = new GoodsDaoImpl();
		return gdao.newFourGoods();
	}

	@Override
	public PageBean bestGoodsList(QueryInfo queryInfo) {

		GoodsDaoImpl gdao = new GoodsDaoImpl();

		QueryResult qr = gdao.bestGoodsList(queryInfo.getStartIndex(), queryInfo.getPageSize());
		PageBean page = new PageBean(queryInfo.getCurrentPage(), queryInfo.getPageSize(), qr.getTotalRecords());
		page.setList(qr.getList());

		return page;

	}

	@Override
	public Goods findGoodsById(Goods goods) throws IllegalException {

		if (goods == null || goods.getGoods_id() == null) {
			throw new IllegalException();
		}
		GoodsDaoImpl gdao = new GoodsDaoImpl();
		return gdao.find("goods_id", goods.getGoods_id());
	}

	//
	public Order buyGoods(Cart cart) {

		return null;
	}

	@Override
	public void addToCart(Integer goods_id, Cart cart) throws NoAvailableGoodsException {
		// TODO Auto-generated method stub

		/*
		 * 
		 * 根据goods_id 产生cartItem 对象
		 */

		CartItemFactory cf = new CartItemFactoryDefault();
		CartItem cartItem = cf.createCartItem(goods_id);

		/*
		 * 将cartItem 添加 到用户cart
		 */
		// 竟然没获取cart

		List<CartItem> items = cart.getItems();

		System.out.println(items);

		CartDao cdao = new CartDaoImpl();
		/*
		 * 如果购物车内已有当前项
		 */
		if (items.contains(cartItem)) {
			int i = items.indexOf(cartItem);
			CartItem src = items.get(i);
			src.setNum(src.getNum() + 1);
			cdao.addNums(src, cart);
			return;
		}

		/*
		 * 调用dao 方法，写入到 数据库
		 */
		// 把cartItem 添加到cart
		items.add(cartItem);
		cdao.addToCart(cartItem, cart);

	}

	@Override
	public Customer find(String name) {
		CustomerDaoImpl cdao = new CustomerDaoImpl();
		return cdao.find("name", name);
	}

	@Override
	public Cart getCart(Integer customer_id) {
		return Cart.getCart(customer_id);

	}

	@Override
	public void deleteFromCart(Integer goods_id, Cart cart, Integer shop_id) {

		CartItem item = new CartItem(goods_id, shop_id);
		List<CartItem> items = cart.getItems();
		boolean remove = items.remove(item);
		if (!remove) {
			System.out.println("想删除购物车内没有的商品");
			return;
		}

		CartDao cdao = new CartDaoImpl();
		cdao.removeFromCart(goods_id, shop_id, cart);

	}

	@Override
	public List<Order> queryOrders(Integer customer_id) {
		OrderDao odao = new OrderDaoImpl();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("customer_id", customer_id);
		return odao.queryOrders(param);

	}

	@Override
	public Order buyGoods(Integer goods_id, Integer customer_id) throws NoAvailableGoodsException {

		CartItemFactory cf = new CartItemFactoryDefault();
		CartItem cartItem = cf.createCartItem(goods_id);
		DefinitizedGoods dgoods = new DefinitizedGoods(cartItem);
		Order order = new Order(customer_id, Arrays.asList(dgoods));
		//
		OrderDao odao = new OrderDaoImpl();
		odao.addOrder(order);

		return order;

	}

	@Override
	public Order buyGoods(ArrayList<CartItem> items, Integer custoemr_id) {

		Order order = new Order(custoemr_id, items);

		OrderDao odao = new OrderDaoImpl();
		odao.addOrder(order);

		return order;
	}

	@Override
	public Order pay(Long order_id) {

		OrderDao odao = new OrderDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("order_id", order_id);
		List<Order> orders = odao.queryOrders(map);
		if (orders.size() != 1) {
			System.out.println("严重错误");
		}

		return orders.get(0);

	}

	@Override
	public void payConfirm(Long order_id) {

		OrderDao odao = new OrderDaoImpl();
		odao.changeOrderStatus(order_id, 1);
		return;
	}

	@Override
	public PageBean querySomeOrders(Integer customer_id, QueryInfo queryInfo) {

		OrderDao odao = new OrderDaoImpl();

		QueryResult qr = odao.querySomeOrders(customer_id, queryInfo.getStartIndex(), queryInfo.getPageSize());
		PageBean page = new PageBean(queryInfo.getCurrentPage(), queryInfo.getPageSize(), qr.getTotalRecords());
		page.setList(qr.getList());

		return page;

	}

	@Override
	public PageBean querySomeOrders(Map<String, Object> queryParam, QueryInfo queryInfo) {
		OrderDao odao = new OrderDaoImpl();

		QueryResult qr = odao.querySomeOrders(queryParam, queryInfo.getStartIndex(), queryInfo.getPageSize());
		PageBean page = new PageBean(queryInfo.getCurrentPage(), queryInfo.getPageSize(), qr.getTotalRecords());
		page.setList(qr.getList());

		return page;
	}

	@Override
	public PageBean queryGoods(Map<String, String> map, QueryInfo queryInfo) {
		GoodsDaoImpl gdao = new GoodsDaoImpl();

		String keyword = map.get("keyword");
		String brand = map.get("brand");
		String lowPrice = map.get("lowPrice");
		String highPrice = map.get("highPrice");

		Map<String, Object> param = new HashMap<String, Object>();
		if (keyword != null) {
			param.put("keyword", keyword);
		}
		if (brand != null) {
			param.put("brand", brand);
		}
		if (lowPrice != null) {
			param.put("lowPrice", Double.parseDouble(lowPrice));
		}
		if (highPrice != null) {
			param.put("highPrice", Double.parseDouble(highPrice));
		}

		QueryResult qr = gdao.GoodsList(param, queryInfo.getStartIndex(), queryInfo.getPageSize());
		PageBean page = new PageBean(queryInfo.getCurrentPage(), queryInfo.getPageSize(), qr.getTotalRecords());
		page.setList(qr.getList());

		return page;

	}

}
