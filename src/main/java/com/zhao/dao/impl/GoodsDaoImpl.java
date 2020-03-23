package com.zhao.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zhao.entity.Goods;
import com.zhao.entity.QueryResult;
import com.zhao.entity.Shop;
import com.zhao.exception.IllegalException;
import com.zhao.util.BeanListHandler;
import com.zhao.util.DBUtil2;
import com.zhao.util.ResultSizeHandler;

public class GoodsDaoImpl extends GenericDaoImpl<Goods> {

	@SuppressWarnings("unchecked")
	@Deprecated
	public List<Goods> selectGoodsInshop(Shop shop) throws IllegalException {

		if (shop == null || shop.getShop_id() == null) {
			throw new IllegalException("shop id 未赋值");
		}

		try {
			String sql = "select * from goods where goods_id in(select goods_id from shop_has_goods where"
					+ " shop_id = ? )";
			return (List<Goods>) DBUtil2.executeQuery(sql, Arrays.asList(shop.getShop_id()),
					new BeanListHandler<Goods>(Goods.class));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public List<Goods> newFourGoods() {

		String sql = "select * from goods Order by productionDate  desc limit 0,4";
		try {
			return (List<Goods>) DBUtil2.executeQuery(sql, null, new BeanListHandler<Goods>(Goods.class));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * 版本1， 最好的商品列表， 因为暂时没有其他条件， 其实就是按顺序查询
	 */
	@SuppressWarnings("unchecked")
	public QueryResult bestGoodsList(int startIndex, int pageSize) {
		try {

			QueryResult qr = new QueryResult();
			String sql = "select * from goods limit ?,? ";
			qr.setList((List<Goods>) DBUtil2.executeQuery(sql, Arrays.asList(startIndex, pageSize),
					new BeanListHandler<Goods>(Goods.class)));

			String sql2 = "select count(*) from goods ";

			Integer totalRecords;

			totalRecords = (Integer) DBUtil2.executeQuery(sql2, null, new ResultSizeHandler());
			qr.setTotalRecords(totalRecords);

			return qr;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public Integer findStock(Integer goods_id, Integer shop_id) {

		try {
			String sql = "select stock from shop_has_goods where goods_id=? and shop_id = ? ";
			return (Integer) DBUtil2.executeQuery(sql, Arrays.asList(goods_id, shop_id), new ResultSizeHandler());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public QueryResult selectGoodsInshop(Shop shop, int startIndex, int pageSize) throws IllegalException {

		if (shop == null || shop.getShop_id() == null) {
			throw new IllegalException("shop id 未赋值");
		}

		try {
			QueryResult qr = new QueryResult();

			String sql = "select * from goods where goods_id in(select goods_id from shop_has_goods where"
					+ " shop_id = ? ) limit ?,?";
			qr.setList((List<Goods>) DBUtil2.executeQuery(sql, Arrays.asList(shop.getShop_id(), startIndex, pageSize),
					new BeanListHandler<Goods>(Goods.class)));

			String sql2 = "select count(*) from goods where goods_id in(select goods_id from shop_has_goods where"
					+ " shop_id = ? )";

			Integer totalRecords = (Integer) DBUtil2.executeQuery(sql2, Arrays.asList(shop.getShop_id()),
					new ResultSizeHandler());

			qr.setTotalRecords(totalRecords);

			return qr;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public QueryResult GoodsList(Map<String, Object> param, int startIndex, int pageSize) {
		try {
			// ############################################
			QueryResult qr = new QueryResult();

			StringBuilder sb = new StringBuilder();
			List<Object> queryParam = new ArrayList<Object>();
			sb.append("select * from goods where 1=1 ");

			if (param.get("keyword") != null) {
				sb.append("and  name like ? or manufacturer like ? or brand like ? ");
				String keyword = (String) param.get("keyword");
				queryParam.add("%" + keyword + "%");
				queryParam.add("%" + keyword + "%");
				queryParam.add("%" + keyword + "%");
			}

			if (param.get("brand") != null) {
				sb.append(" and  brand like ? ");
				queryParam.add("%" + param.get("brand") + "%");
			}
			if (param.get("lowPrice") != null) {
				sb.append(" and  price >= ? ");
				queryParam.add(param.get("lowPrice"));
			}
			if (param.get("highPrice") != null) {
				sb.append(" and  price <= ? ");
				queryParam.add(param.get("highPrice"));
			}

			sb.append(" limit ?,? ");
			queryParam.add(startIndex);
			queryParam.add(pageSize);

			qr.setList((List<Goods>) DBUtil2.executeQuery(sb.toString(), queryParam,
					new BeanListHandler<Goods>(Goods.class)));

			String query = sb.toString();
			query = query.replace("*", "count(*)");
			Integer totalRecords;

			// select count(*) where xxx limit y,m
			// xxx对结果有影响，y,m对结果无影响
			totalRecords = (Integer) DBUtil2.executeQuery(query, queryParam, new ResultSizeHandler());
			qr.setTotalRecords(totalRecords);

			return qr;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
