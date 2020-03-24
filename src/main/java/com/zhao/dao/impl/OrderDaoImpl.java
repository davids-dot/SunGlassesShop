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
import com.zhao.entity.Goods;
import com.zhao.entity.Order;
import com.zhao.entity.OrderDetail;
import com.zhao.entity.QueryInfo;
import com.zhao.entity.QueryResult;
import com.zhao.servlet.OrderType;
import com.zhao.util.BeanListHandler;
import com.zhao.util.DBUtil2;
import com.zhao.util.IsNullHandler;
import com.zhao.util.ResultSizeHandler;

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
			return !(boolean) DBUtil2.executeQuery(sql, new IsNullHandler(), order_id);
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

			Object[] para = new Object[params.size()] ;
            int i = 0;
			for (Entry<String, Object> entry : params.entrySet()) {
				sb.append(" and " + entry.getKey() + " = ? ");
				para[i++] = entry.getValue();
			}

			List<Order> orders = (List<Order>) DBUtil2.executeQuery(sb.toString(),new BeanListHandler<Order>(Order.class), para
					);

			for (Order order : orders) {

				String sql = "select goods_id,shop_id,num from Order_detail where order_id = ? ";
				order.setItems((List<OrderDetail>) DBUtil2.executeQuery(sql,
						new BeanListHandler<OrderDetail>(OrderDetail.class),
						order.getOrder_id() ));

			}
			return orders;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public QueryResult querySomeOrders(Integer customer_id, int startIndex, int pageSize) {

		QueryResult qr = new QueryResult();

		try {

			String sql = "select order_id, customer_id,status from orders where 1=1 and customer_id = ? limit ?,? ";

			qr.setList((List<Order>) DBUtil2.executeQuery(sql,
					new BeanListHandler<Order>(Order.class),
				     customer_id, startIndex, pageSize ));

			String sql2 = "select count(*) from orders where 1=1 and customer_id = ? ";

			Integer totalRecords;

			totalRecords = (Integer) DBUtil2.executeQuery(sql2,  new ResultSizeHandler(),
					customer_id);
			qr.setTotalRecords(totalRecords);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return qr;

	}

	@SuppressWarnings("unchecked")
	@Override
	public QueryResult querySomeOrders(Map<String, Object> queryParam, int startIndex, int pageSize) {
		QueryResult qr = new QueryResult();

		try {

			StringBuilder sb = new StringBuilder();
			sb.append("select order_id, customer_id,status from orders where 1=1  ");
			Object[] param = new Object[queryParam.size()];
			int idx = 0;
			for (Entry<String, Object> entry : queryParam.entrySet()) {
				sb.append(" and " + entry.getKey() + " =  ? ");
				param[idx++] = entry.getValue();
			}
			sb.append(" limit ? , ? ");
			param[idx++] = startIndex;
			param[idx++] = pageSize;

			qr.setList(
					(List<Order>) DBUtil2.executeQuery(sb.toString(),new BeanListHandler<Order>(Order.class),
					param));

			int start = sb.indexOf("order_id");
			sb.replace(start, start + 28, "count(*)");

			Integer totalRecords;
			param[--idx] = null;
			param[--idx] = null;

			sb.delete(sb.indexOf("limit"), sb.length());

			totalRecords = (Integer) DBUtil2.executeQuery(sb.toString(), new ResultSizeHandler(), param);
			qr.setTotalRecords(totalRecords);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return qr;
	}

	@SuppressWarnings("unchecked")
	@Override
	public QueryResult querySellerOrder(OrderType type, Integer shop_id, QueryInfo queryInfo) {
		QueryResult qr = new QueryResult();

		try {

			String sql = "select distinct (Orders.order_id), customer_id,status from Orders,Order_detail "
					+ " where Orders.order_id = Order_detail.order_id " + " and shop_id = ? and status = ? limit ? , ?";

			qr.setList((List<Order>) DBUtil2.executeQuery(sql,
					new BeanListHandler<Order>(Order.class),
					shop_id, type.ordinal(), queryInfo.getStartIndex(), queryInfo.getPageSize() ));

			String sql2 = "select count(distinct Orders.order_id) from Orders,Order_detail where Orders.order_id = Order_detail.order_id "
					+ " and shop_id = ? and status = ? ";

			Integer totalRecords;

			totalRecords = (Integer) DBUtil2.executeQuery(sql2,
					new ResultSizeHandler(),
					shop_id, type.ordinal());
			qr.setTotalRecords(totalRecords);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return qr;

	}

}
