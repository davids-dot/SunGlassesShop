package com.zhao.test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;

import com.zhao.dao.CartDao;
import com.zhao.dao.OrderDao;
import com.zhao.dao.ShopDao;
import com.zhao.dao.impl.CartDaoImpl;
import com.zhao.dao.impl.CustomerDaoImpl;
import com.zhao.dao.impl.GoodsDaoImpl;
import com.zhao.dao.impl.OrderDaoImpl;
import com.zhao.dao.impl.ShopDaoImpl;
import com.zhao.entity.CartItem;
import com.zhao.entity.CartItemFactory;
import com.zhao.entity.CartItemFactoryDefault;
import com.zhao.entity.Customer;
import com.zhao.entity.DefinitizedGoods;
import com.zhao.entity.Goods;
import com.zhao.entity.Order;
import com.zhao.entity.Shop;
import com.zhao.exception.NoAvailableGoodsException;

public class TestDao {

	@Test
	public void testShopDao() {
		ShopDao sdao = new ShopDaoImpl();
		Shop shop = sdao.findShop(1);
		System.out.println(shop);
	}

	@Test
	public void testGoodsDao() {
		GoodsDaoImpl gdao = new GoodsDaoImpl();
		Shop shop = new Shop();
		shop.setShop_id(3);

		try {
			List<Goods> ls = gdao.selectGoodsInshop(shop);
			System.out.println(ls);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGoodsDao2() {
		GoodsDaoImpl gdao = new GoodsDaoImpl();
		System.out.println(gdao.findStock(2, 3));
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCartItemFactory() {
		CartItemFactory cf = new CartItemFactoryDefault();
		try {
			System.out.println(cf.createCartItem(2));
		} catch (NoAvailableGoodsException e) {
			e.printStackTrace();
		}
	}

	// @Test
	// public void testCartDaoImpl(){
	// CartDao cd = new CartDaoImpl();
	// cd.addToCart(, cart);
	// }

	@Test
	public void testCustomerDaoImpl() {
		CustomerDaoImpl cdao = new CustomerDaoImpl();
		Customer cus = cdao.find("name", "11111112");
		System.out.println(cus);

	}

	@Test
	public void testCartItemequals() {

		CartItem c1 = new CartItem();
		c1.setGoods_id(1);
		c1.setShop_id(2);

		CartItem c2 = new CartItem();
		c2.setGoods_id(1);
		c2.setShop_id(2);

		System.out.println(c1.equals(c2) && (c1.hashCode() == c2.hashCode()));
	}

	/*
	 * order(cus_id ，dgoods) dgoods(goods_id,shop_id)
	 */

	@Test
	public void testOrderDao() {
		OrderDao odao = new OrderDaoImpl();
		//
		Order order = new Order(2, Arrays.asList(new DefinitizedGoods(2, 3), new DefinitizedGoods(5, 3)));
		odao.addOrder(order);
	}

	@Test
	public void testOrderDao2() {
		OrderDao odao = new OrderDaoImpl();
		//

		odao.changeOrderStatus(961493707814129L, 1);
	}

	@Test
	public void testUUID() {

		int o1 = (int) (Math.random() * 10);
		int o2 = (int) (Math.random() * 10);
		Long o3 = System.currentTimeMillis();
		String odno = String.valueOf(o1) + String.valueOf(o2) + String.valueOf(o3);
		Long od = Long.parseLong(odno);

	}

	@Test
	public void testDefinitizedGoods() {

		try {
			Class<DefinitizedGoods> c = DefinitizedGoods.class;
			DefinitizedGoods obj = (DefinitizedGoods) c.newInstance();
			Field shop_id = c.getDeclaredField("shop_id");
			shop_id.setAccessible(true);

			shop_id.set(obj, 2);
			System.out.println(obj.getShop_id());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException
				| InstantiationException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testOrderDao3() {

		OrderDao odao = new OrderDaoImpl();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("customer_id", 2);

		System.out.println(odao.queryOrders(param));

	}

	@Test
	public void testFindAttribute() {
		GoodsDaoImpl gdao = new GoodsDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("goods_id", 3);

		System.out.println((Double) gdao.findAttribute("price", map));

	}

}
