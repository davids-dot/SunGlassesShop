package com.zhao.service;

import com.zhao.dao.UserDao;
import com.zhao.dao.UserDaoImpl;
import com.zhao.entity.User;

/**
 * 
 * @author david stark
 * @description 提供客户名字，手机号是否存在的验证服务
 *
 */
public class VerifyService {

	UserDao udao = new UserDaoImpl();
	User user;

	/**
	 * 判断给定用户名的用户是否存在， 由于是为判断 注册合法性服务，所以不合法输入 返回该用户存在
	 * 
	 * @param name
	 * @param userType
	 * @return
	 */
	public boolean nameExist(String name, String userType) {
		System.out.println("验证的用户名是" + name);
		if (name == null || "".equals(name)) {
			return true;
		}

		user = new User();
		user.setName(name);
		user.setType(userType);
		return udao.existUser(user);
	}

	public boolean phoneExist(String telephone, String userType) {
		if (telephone == null || "".equals(telephone)) {
			return true;
		}

		user = new User();
		user.setTelephone(telephone);
		user.setType(userType);
		return udao.existUser(user);
	}

}
