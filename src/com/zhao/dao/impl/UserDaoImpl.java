package com.zhao.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhao.dao.UserDao;
import com.zhao.entity.Customer;
import com.zhao.entity.User;
import com.zhao.util.BeanListHandler;
import com.zhao.util.DBUtil;
import com.zhao.util.DBUtil2;
import com.zhao.util.IsNullHandler;

public class UserDaoImpl implements UserDao {

	@Override
	public void addUser(User user) {

		String sql = "insert into User(name,password,telephone,type) values(?,?,?,?)";

		List<Object> params = new ArrayList<Object>();
		params.add(user.getName());
		params.add(user.getPassword());
		params.add(user.getTelephone());
		params.add(user.getType());
		try {
			DBUtil.executeUpdate(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteUser(String user_id) {

	}

	@Override
	public void changeUserInfo(User user) {

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> queryUser(User user) {

		StringBuffer sb = new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		sb.append("select * from User where 1=1 ");
		if (user.getName() != null) {
			sb.append("and name= ? ");
			params.add(user.getName());
		}
		if (user.getTelephone() != null) {
			sb.append("and telephone = ? ");
			params.add(user.getTelephone());
		}

		try {
			return (List<User>) DBUtil.executeQuery(sb.toString(), params, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	// public User findUser(User user){
	//
	// String sql ="select * from user where "
	//
	// }

	@Override
	public boolean existUser(User user) {

		StringBuffer sb = new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		sb.append("select * from User where 1=1 ");
		if (user.getName() != null) {
			sb.append("and name= ? ");
			params.add(user.getName());
		}
		if (user.getTelephone() != null) {
			sb.append("and telephone = ? ");
			params.add(user.getTelephone());
		}
		if (user.getType() != null) {
			sb.append("and type = ? ");
			params.add(user.getType());
		}

		try {
			boolean no_user = (boolean) DBUtil.executeQuery(sb.toString(), params, new IsNullHandler());
			return !no_user;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
