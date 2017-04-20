package com.zhao.entity;

public class Shop {

	private Integer shop_id;

	public Integer getShop_id() {
		return shop_id;
	}

	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogoURI() {
		return logoURI;
	}

	public void setLogoURI(String logoURI) {
		this.logoURI = logoURI;
	}

	public Integer getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(Integer seller_id) {
		this.seller_id = seller_id;
	}

	public Integer getVerify() {
		return verify;
	}

	public void setVerify(Integer verify) {
		this.verify = verify;
	}

	private String name;
	private String logoURI;
	private Integer seller_id;
	private Integer verify;

}
