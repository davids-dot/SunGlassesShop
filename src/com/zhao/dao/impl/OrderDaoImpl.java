package com.zhao.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import com.zhao.dao.OrderDao;
import com.zhao.entity.Order;
import com.zhao.entity.OrderDetail;
import com.zhao.util.BeanListHandler;
import com.zhao.util.DBUtil2;
import com.zhao.util.IsNullHandler;

/*
 * create table Orders(

		order_id bigint not null,
		customer_id int,
		status int(1) default 0, # 0,未付款 
		                         # 1，未发货
		                         # 2，已发货
		                         # 3，已收货
		primary key (order_id),

		constraint FK_customer foreign key (customer_id) references Customer(customer_id)

);



create table Order_detail(
	order_id bigint,
	goods_id int,
	num int default 1,
	shop_id int,

	  primary key(order_id,goods_id,shop_id),
	  constraint  FK_shop_order foreign key (shop_id) references Shop(shop_id),
	  constraint  FK_goods_order foreign key (goods_id) references Goods(goods_id),
	  constraint  FK_order foreign key (order_id) references Orders(order_id)

);
 */

public class OrderDaoImpl implements OrderDao {

	@Override
	public void addOrder(Order order) {

		try {

			// 订单中 OrderDetail 中goods 可能不合法，
			String sql1 = "insert into Orders(order_id,customer_id) values (? ,? )";
			DBUtil2.executeUpdate(sql1, Arrays.asList(order.getOrder_id(), order.getCustomer_id()));

			List<OrderDetail> items = order.getItems();
			Iterator<OrderDetail> it = items.iterator();

			StringBuilder sb = new StringBuilder();
			sb.append("insert into Order_detail(order_id,goods_id,shop_id,num) values ");
			List<Object> param = new ArrayList<Object>();
			while (it.hasNext()) {
				OrderDetail od = it.next();
				sb.append("(?,?,?,?),");
				param.add(order.getOrder_id());
				param.add(od.getGoods_id());
				param.add(od.getShop_id());
				// OrderDetail shop_id赋值错误,Order中 items 的OrderDetail 的shop_id
				// 赋值错误
				System.out.println("shop_id：" + od.getShop_id());
				param.add(od.getNum());
			}
			sb.deleteCharAt(sb.lastIndexOf(","));
			System.out.println(sb.toString());

			DBUtil2.executeUpdate(sb.toString(), param);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean existOrder(Long order_id) {
		try {
			String sql = "select order_id from Orders where order_id = ? ";
			return !(boolean) DBUtil2.executeQuery(sql, Arrays.asList(order_id), new IsNullHandler());
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}

	}

	@Override
	public void changeOrderStatus(Long order_id, Integer status) {
		try {
			String sql = "update orders set status = ? where order_id = ? ";
			DBUtil2.executeUpdate(sql, Arrays.asList(status, order_id));
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> queryOrders(Map<String, Object> params) {

		try {
			StringBuilder sb = new StringBuilder();
			sb.append("select order_id, customer_id,status from orders where 1=1 ");

			List<Object> para = new ArrayList<Object>();

			for (Entry<String, Object> entry : params.entrySet()) {
				sb.append(" and " + entry.getKey() + " = ? ");

				para.add(entry.getValue());

			}

			List<Order> orders = (List<Order>) DBUtil2.executeQuery(sb.toString(), para,
					new BeanListHandler<Order>(Order.class));

			for (Order order : orders) {

				String sql = "select goods_id,shop_id,num from Order_detail where order_id = ? ";
				order.setItems((List<OrderDetail>) DBUtil2.executeQuery(sql, Arrays.asList(order.getOrder_id()),
						new BeanListHandler<OrderDetail>(OrderDetail.class)));

			}
			return orders;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
