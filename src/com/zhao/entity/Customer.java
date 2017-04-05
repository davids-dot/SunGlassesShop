package com.zhao.entity;

public class Customer extends User {

	private Integer customer_id;
	private String name;
	private String address;
	private String id_card;

	public Integer getId() {
		return customer_id;
	}

	public void setId(Integer id) {
		this.customer_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "姓名：" + name + "\n" + "密码：" + getPassword() + "\n" + "电话：" + getTelephone() + "\n";
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
