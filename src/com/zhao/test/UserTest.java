package com.zhao.test;

import org.junit.Test;

import com.zhao.dao.UserDao;
import com.zhao.dao.impl.UserDaoImpl;
import com.zhao.entity.User;

public class UserTest {

	@Test
	public void addUserTest() {
		User user = new User();
		user.setName("ddd");
		user.setPassword("dddd");
		user.setTelephone("ddd");
		user.setType("Customer");

		UserDao udao = new UserDaoImpl();
		udao.addUser(user);
	}

}
