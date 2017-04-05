package com.zhao.entity;

public class User {

	private Integer user_id;

	private String name;
	private String password;
	private String telephone;
	private String type;

	public User() {

	}

	public User(String name2, String password2, String mobilePhone, String userType) {
		this.name = name2;
		this.password = password2;
		this.telephone = mobilePhone;
		this.type = userType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
