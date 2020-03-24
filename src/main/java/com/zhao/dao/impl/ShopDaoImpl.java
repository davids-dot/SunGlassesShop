package com.zhao.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.zhao.dao.ShopDao;
import com.zhao.entity.Goods;
import com.zhao.entity.QueryInfo;
import com.zhao.entity.QueryResult;
import com.zhao.entity.Seller;
import com.zhao.entity.Shop;
import com.zhao.util.BeanHandler;
import com.zhao.util.BeanListHandler;
import com.zhao.util.DBUtil;
import com.zhao.util.DBUtil2;
import com.zhao.util.IsNullHandler;
import com.zhao.util.OneAttributeHandler;
import com.zhao.util.ResultSizeHandler;

public class ShopDaoImpl implements ShopDao {

	/*
	 * (non-Javadoc)带有seller_id 的shop 添加到数据库，商铺未验证
	 * 
	 * @see com.zhao.dao.ShopDao#addShop(com.zhao.entity.Shop)
	 */
	@Override
	public void addShop(Shop shop) {

		String sql = "insert into  Shop(name,logoURI,seller_id,verifyInfo) values(?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(shop.getName());
		params.add(shop.getLogoURI());
		params.add(shop.getSeller_id());
		params.add(shop.getVerifyInfo());
		try {
			DBUtil2.executeUpdate(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void changeStatus(String name) {

	}

	/*
	 * @param 找出某个商家的shop
	 * 
	 * @see com.zhao.dao.ShopDao#findShop(java.lang.Integer)
	 */
	@Override
	public Shop findShop(Integer seller_id) {

		String sql = " select * from  shop  where seller_id = ? ";
		try {
			return (Shop) DBUtil2.executeQuery(sql, new BeanHandler<>(Shop.class), seller_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean existGoods(Shop shop, Goods goods) {
		String sql = "select shop_id from shop_has_goods where goods_id = ? and shop_id= ? ";
		try {
			return (boolean) DBUtil2.executeQuery(sql, new IsNullHandler(),
					goods.getGoods_id(), shop.getShop_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public QueryResult queryShopRank(QueryInfo queryInfo) {

		try {
			QueryResult qr = new QueryResult();
			String sql = " select  shop_id,sum(tPrice) as week_amount  from  v_shop_amount_detail "
					+ " where curDate()< date_add(order_date,interval 7 day) group by shop_id order by week_amount desc limit ?, ? ";

			qr.setList((List<? extends Object>) DBUtil2.executeQuery(sql,
					new BeanListHandler<Shop>(Shop.class),
					queryInfo.getStartIndex(), queryInfo.getPageSize() ));

			sql = sql.substring(0, sql.length() - 12);

			qr.setTotalRecords((int) DBUtil2.executeQuery(sql, null, new ResultSizeHandler()));

			return qr;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	/*
	 * seller_id int not null auto_increment, name varchar(30) unique, id_card
	 * varchar(24), address varchar(20),
	 * 
	 * photoURI varchar(60), realName varchar(20), (non-Javadoc)
	 * 
	 * @see com.zhao.dao.ShopDao#findSeller(java.lang.Integer)
	 */
	@Override
	public Seller findSeller(Integer shop_id) {
		String sql = " select Seller.seller_id,Seller.name,id_card,address,realName,photoURI from seller,Shop where Shop.seller_id = seller.seller_id and Shop.shop_id = ? ";
		try {
			return (Seller) DBUtil2.executeQuery(sql, new BeanHandler<Seller>(Seller.class),shop_id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String findAttribute(String string, Integer shop_id) {
		String sql = "select " + string + " from shop where shop_id =  ? ";

		try {
			return (String) DBUtil2.executeQuery(sql,  new OneAttributeHandler(), shop_id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
