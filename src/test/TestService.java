package com.zhao.test;

import java.sql.Date;

import javax.servlet.http.HttpServlet;

import org.junit.Test;

import com.zhao.dao.impl.GoodsDaoImpl;
import com.zhao.entity.Cart;
import com.zhao.entity.Goods;
import com.zhao.entity.Order;
import com.zhao.entity.PageBean;
import com.zhao.entity.QueryInfo;
import com.zhao.entity.Seller;
import com.zhao.exception.NoAvailableGoodsException;
import com.zhao.service.CustomerService;
import com.zhao.service.SellerService;
import com.zhao.service.impl.CustomerServiceImpl;
import com.zhao.service.impl.SellerServiceImpl;

public class TestService {

	// public void addToShop(Seller sel, Goods goods) {
	@Test
	public void testSellerAddToShop() {
		Seller sel = new Seller();
		sel.setSeller_id(1);

		Goods goods = new Goods("name", "111111", "picuri", "manufacturer", "brand", "area");
		goods.setProductionDate(Date.valueOf("2017-03-01"));
		goods.setPrice(12.8);

		SellerService ss = new SellerServiceImpl();
		ss.addToShop(sel, goods);

	}

	/*
	 * addToCart(goods_id,cart) Cart(customer_id)
	 */
	@Test
	public void testCustomerService() {
		CustomerService cs = new CustomerServiceImpl();
		try {
			cs.addToCart(2, Cart.getCart(2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// @Test
	// public void testAddToCart(){
	// CustomerService cs = new CustomerServiceImpl();
	// cs.addToCart(2, Cart.getCart(2));
	// }

	@Test
	public void testBuyGoods() {
		CustomerService cs = new CustomerServiceImpl();
		try {
			cs.buyGoods(2, 2);
		} catch (NoAvailableGoodsException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testQuerySomeOrder() {
		CustomerService cs = new CustomerServiceImpl();
		QueryInfo queryInfo = new QueryInfo();
		PageBean page = cs.querySomeOrders(3, queryInfo);
		System.out.println(page.getList());
	}

	@Test
	public void testOrderId() {

		for (int i = 0; i < 100; i++) {
			int o1 = (int) (Math.random() * 10);
			int o2 = (int) (Math.random() * 10);
			Long o3 = System.currentTimeMillis();
			String odno = String.valueOf(o1) + String.valueOf(o2) + String.valueOf(o3);
			System.out.println(odno);
		}

	}

	@Test
	public void testOteher() {
		System.out.println(String.valueOf(0));
	}

}
