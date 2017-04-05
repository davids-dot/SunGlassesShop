package com.zhao.dao;

import java.util.List;

import com.zhao.entity.User;

public interface UserDao {

	public void addUser(User user);

	public void deleteUser(String user_id);

	public void changeUserInfo(User user);

	public List<User> queryUser(User user);

	public boolean existUser(User user);

}
