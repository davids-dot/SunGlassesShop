package com.zhao.entity;

public class User {

	private Integer user_id;

	private String name;
	private String password;
	private String telephone;
	private String type;
	private Integer isDele;

	public User() {

	}

	@Deprecated
	public static User getInstance(String type) {
		if (type.equals("Customer")) {
			return new Customer();
		}
		if (type.equals("Seller")) {
			return new Seller();
		}
		if (type.equals("Admin")) {
			;
		}
		return null;
	}

	public User(User user) {
		this.name = user.name;
		this.password = user.password;
		this.telephone = user.telephone;
		this.type = user.type;
		this.isDele = user.isDele;
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

	public Integer getIsDele() {
		return isDele;
	}

	public void setIsDele(Integer isDele) {
		this.isDele = isDele;
	}

	public String toString() {
		String s = "user_id:" + user_id + "\n" + "name:" + name + "\n" + "password:" + password + "\n" + "telephone"
				+ telephone + "\n" + "isDele:" + isDele + "\n";

		return s;
	}

}
