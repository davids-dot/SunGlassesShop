package com.zhao.entity;

public class Customer extends User {

	private Integer customer_id;
	private String name;
	private String address;
	private String id_card;

	public Customer(User user) {
		super(user);
		this.name = super.getName();
	}

	public Customer() {

	}

	/*
	 * 在原customer 上添加 customer 的新属性
	 */
	public Customer addAttribute(Customer cus) {
		this.setName(cus.getName());
		this.setAddress(cus.getAddress());
		this.setId_card(cus.getId_card());
		this.setCustomer_id(cus.getCustomer_id());
		return this;
	}

	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer id) {
		this.customer_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		super.setName(name);
		this.name = name;
	}

	public String toString() {
		return "姓名：" + name + "\n" + "密码：" + getPassword() + "\n" + "电话：" + getTelephone() + "\n" + super.toString();
	}

	public static void main(String[] args) {

	}

	public String getId_card() {
		return id_card;
	}

	public void setId_card(String id_card) {
		this.id_card = id_card;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
