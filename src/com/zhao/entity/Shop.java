package com.zhao.entity;

import com.zhao.dao.ShopDao;
import com.zhao.dao.impl.ShopDaoImpl;

public class Shop {

	private Integer shop_id;
	private String name;
	private String logoURI;
	private Integer seller_id;
	private Integer verify;
	private String verifyInfo;
	private Integer priority;

	// 后添加的
	private Double week_amount;
	private Seller seller;

	private static final ShopDao MYDAO = new ShopDaoImpl();

	public Shop() {

	}

	public String toString() {

		String s = "shop_id:" + shop_id + "\name:" + name + "\nlogoURI:" + logoURI + "\nseller_id:" + seller_id
				+ "\nverify:" + verify + "\nverifyInfo:" + verifyInfo;

		return s;
	}

	public Shop(String name2, String verifyInfo, String logoURI2, Integer seller_id2) {
		this.name = name2;
		this.verifyInfo = verifyInfo;
		this.logoURI = logoURI2;
		this.seller_id = seller_id2;
	}

	public Integer getShop_id() {
		return shop_id;
	}

	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}

	public String getName() {
		if (name != null)
			return name;
		name = MYDAO.findAttribute("name", this.getShop_id());
		return name;
	}

	public Seller getSeller() {
		if (seller != null)
			return seller;
		return MYDAO.findSeller(shop_id);

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

	public String getVerifyInfo() {
		return verifyInfo;
	}

	public void setVerifyInfo(String verifyInfo) {
		this.verifyInfo = verifyInfo;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Double getWeek_amount() {
		return week_amount;
	}

	public void setWeek_amount(Double week_amount) {
		this.week_amount = week_amount;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

}
