package com.zhao.service.impl;

import com.zhao.dao.UserDao;
import com.zhao.dao.impl.UserDaoImpl;
import com.zhao.entity.User;
import com.zhao.service.LoginRegisterService;

public class LoginRegisterServiceImpl implements LoginRegisterService {

	UserDao udao = new UserDaoImpl();

	public LoginRegisterServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isCorrectPair(String userName, String password, String type) {

		User user = new User();
		user.setName(userName);
		user.setPassword(password);
		user.setType(type);
		return udao.existUser(user);
	}

}
