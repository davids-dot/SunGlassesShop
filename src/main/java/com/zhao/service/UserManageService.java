package com.zhao.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zhao.entity.Page;
import com.zhao.entity.UserCustom;

public interface UserManageService {
	//查询用户
	public List<UserCustom> queryUsers(Page op,HttpServletRequest request) throws Exception;
	//计数
	public Integer queryCount() throws Exception;
	//修改用户
	public void updateUser(UserCustom userCustom)throws Exception;
	//删除用户
	public void deleteUser(String userid,String type)throws Exception;
	void activeUser(String userid,String type) throws Exception;

}
