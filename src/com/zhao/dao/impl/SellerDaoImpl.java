package com.zhao.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.zhao.dao.SellerDao;
import com.zhao.entity.Seller;
import com.zhao.util.BeanHandler;
import com.zhao.util.DBUtil;
import com.zhao.util.DBUtil2;

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
			DBUtil2.executeUpdate(sb.toString(), param);
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
			return (Seller) DBUtil2.executeQuery(sql, params, new BeanHandler<Seller>(Seller.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
