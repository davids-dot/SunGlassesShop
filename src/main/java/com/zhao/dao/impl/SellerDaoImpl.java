package com.zhao.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.zhao.dao.SellerDao;
import com.zhao.entity.Goods;
import com.zhao.entity.Seller;
import com.zhao.entity.Shop;
import com.zhao.util.BeanHandler;
import com.zhao.util.DBUtil;
import com.zhao.util.DBUtil2;
import com.zhao.util.IsNullHandler;

public class SellerDaoImpl implements SellerDao {

	public SellerDaoImpl() {
	}

	@Override
	public void addSeller(Seller sel) {

	}

	@Override
	public void updateSeller(Seller sel, String name) {

		List<Object> param = new ArrayList<Object>();

		StringBuilder sb = new StringBuilder();
		sb.append("update Seller set ");

		if (sel.getAddress() != null) {
			sb.append(",address = ? ");
			param.add(sel.getAddress());
		}

		if (sel.getId_card() != null) {
			sb.append(",id_card = ? ");
			param.add(sel.getId_card());
		}

		if (sel.getRealName() != null) {
			sb.append(",realName = ? ");
			param.add(sel.getRealName());
		}

		if (sel.getPhotoURI() != null) {
			sb.append(",photoURI = ? ");
			param.add(sel.getPhotoURI());
		}

		sb.deleteCharAt(sb.indexOf(","));
		sb.append(" where name = ? ");
		param.add(name);

		try {
			DBUtil.executeUpdate(sb.toString(), param);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Seller findSeller(String name) {

		String sql = "select * from Seller  where name=?";
		List<Object> params = new ArrayList<Object>();
		params.add(name);

		try {
			return (Seller) DBUtil2.executeQuery(sql,new BeanHandler<Seller>(Seller.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addGoodsToShop(Seller sel, Goods goods, Shop shop) throws SQLException {

		String sql = "insert  into  shop_has_goods(shop_id,goods_id) values(?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(shop.getShop_id());
		params.add(goods.getGoods_id());
		DBUtil2.executeUpdate(sql, params);

	}

	@Override
	public boolean existGoodsInShop(Goods goods, Shop shop) {
		String sql = " select * from shop_has_goods where 1=1 and goods_id=? and shop_id = ? ";

		try {
			return !(boolean) DBUtil2.executeQuery(sql,
					new IsNullHandler(), goods.getGoods_id(), shop.getShop_id() );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	// @Override
	// public Shop findShop(Seller sel) {
	// String sql = "select * from shop where 1=1 and seller_id = ? ";
	// try {
	// return (Shop) DBUtil2.executeQuery(sql,
	// Arrays.asList(sel.getSeller_id()),
	// new BeanHandler<Shop>(Shop.class));
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	//
	// return null;
	// }

}
