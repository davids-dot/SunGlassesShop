package com.zhao.entity;

public class DefinitizedGoods {

	private Integer goods_id;
	private Integer shop_id;
	private Integer stock;

	public DefinitizedGoods() {

	}

	public DefinitizedGoods(CartItem item) {
		this.goods_id = item.getGoods_id();
		this.shop_id = item.getShop_id();
		this.stock = item.getStock();
	}

	public DefinitizedGoods(Integer goods_id, Integer shop_id) {

		this.goods_id = goods_id;
		this.shop_id = shop_id;
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

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
}
