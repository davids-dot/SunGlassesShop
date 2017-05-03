package com.zhao.entity;

import com.zhao.dao.impl.GoodsDaoImpl;

public class OrderDetail {

	private Integer goods_id;
	private Integer shop_id;
	private Integer num;

	private Goods goods;

	public OrderDetail() {
	}

	public OrderDetail(Integer goods_id, Integer shop_id, Integer num) {
		this.goods_id = goods_id;
		this.shop_id = shop_id;
		this.num = num;
	}

	public Integer getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}

	public Integer getShop_id() {
		return shop_id;
	}

	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String toString() {
		return "goods_id:" + goods_id + "\tshop_id:" + shop_id + "\tnum:" + num + "\n";
	}

	public Goods getGoods() {
		if (this.goods != null)
			return this.goods;
		GoodsDaoImpl gdao = new GoodsDaoImpl();
		this.goods = gdao.find("goods_id", this.getGoods_id());
		return this.goods;
	}

}
