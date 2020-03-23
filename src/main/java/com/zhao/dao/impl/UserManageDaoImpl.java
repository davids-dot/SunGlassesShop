package com.zhao.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.zhao.entity.Page;
import com.zhao.entity.UserCustom;
import com.zhao.util.BeanListHandler;
import com.zhao.util.DBUtil2;
import com.zhao.util.ResultSizeHandler;

public class UserManageDaoImpl implements com.zhao.dao.UserManageDao {

	@Override
	public List<UserCustom> queryUsers(Page page) throws Exception {
		String sql = "select *"
				+ "from user " + " limit " + page.getCurrentPage() * 5 + "," + 5;
		return (List<UserCustom>) DBUtil2.executeQuery(sql, null, new BeanListHandler<UserCustom>(UserCustom.class));
	}

	@Override
	public void updateUser(UserCustom userCustom) throws Exception{
		//String sql = "update user set commentText=? where  user_id =?";

	}

	@Override
	public void deleteUser(String userid,String type) throws Exception{
		String sql = "update user set isDele=1 where name =? and type=?";
		List<Object> params=new ArrayList<>();
 		params.add(userid);
 		params.add(type);
		DBUtil2.executeUpdate(sql, params);

	}
	@Override
	public void activeUser(String userid,String type) throws Exception{
		String sql = "update user set isDele=0 where name =? and type=?";
		List<Object> params=new ArrayList<>();
 		params.add(userid);
 		params.add(type);
		DBUtil2.executeUpdate(sql, params);

	}

	@Override
	public Integer queryCount() throws Exception {
		String sql = "select count(*) from user";
		return (Integer) DBUtil2.executeQuery(sql, null, new ResultSizeHandler());
	}

}
