package com.zhao.entity;

public class Seller extends User {

	private Integer seller_id;
	private String id_card;
	private String address;
	private String photoURI;
	private String realName;
	private Shop shop;

	public String toString() {
		String s = super.toString() + "seller_id:" + seller_id + "\n" + "id_card:" + id_card + "\n" + "address:"
				+ address + "\n" + "photoURI:" + photoURI + "\n" + "realName:" + realName + "\n";
		return s;
	}

	public Integer getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(Integer seller_id) {
		this.seller_id = seller_id;
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

	public String getPhotoURI() {
		return photoURI;
	}

	public void setPhotoURI(String photoURI) {
		this.photoURI = photoURI;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Seller() {
	}

	// 自产生的
	public Seller(String name2, String password2, String mobilePhone, String userType) {
		super(name2, password2, mobilePhone, userType);
	}

	/*
	 * @author
	 * 
	 */
	public Seller(String userName, String id_card2, String telephone, String area, String photoURI) {
		super();
		this.realName = userName;
		this.id_card = id_card2;
		this.address = area;
		this.photoURI = photoURI;
	}

	public Seller(User user) {
		super(user);
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

}
