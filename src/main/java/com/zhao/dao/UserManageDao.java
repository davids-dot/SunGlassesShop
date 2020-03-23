package com.zhao.dao;

import java.util.List;

import com.zhao.entity.Page;
import com.zhao.entity.User;
import com.zhao.entity.UserCustom;

public interface UserManageDao {
	//查询用户
	public List<UserCustom> queryUsers(Page page) throws Exception;
	//计数
	public Integer queryCount() throws Exception;
	
	//修改用户
	public void updateUser(UserCustom userCustom)throws Exception;
	//删除用户
	public void deleteUser(String userid,String type)throws Exception;
	void activeUser(String userid,String type) throws Exception;
	
	

}
