package com.zhao.entity;

public class CartItem {

	private Integer goods_id;
	private Integer num;// 用户购买数量
	private Integer shop_id;
	// 以上是数据库中有的
	/*
	 * 数据库中还有 customer_id
	 */
	private Goods goods;
	private Integer stock;// 库存数量

	public CartItem() {

	}

	public CartItem(Integer goods_id2, Integer shop_id2) {
		this.goods_id = goods_id2;
		this.shop_id = shop_id2;
	}

	public int hashCode() {
		int result = 17;
		result = 37 * result + goods_id;
		result = 37 * result + shop_id;

		return result;
	}

	public boolean equals(Object o) {
		if (!(o instanceof CartItem))
			return false;
		CartItem other = (CartItem) o;

		return (goods_id == null ? other.getGoods_id() == null : goods_id.equals(other.getGoods_id()))
				&& (shop_id == null ? other.getShop_id() == null : shop_id.equals(other.getShop_id()));

	}

	public Integer getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getShop_id() {
		return shop_id;
	}

	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String toString() {
		String s = "shop_id:" + shop_id + "\ngoods_id:" + goods_id + "\nnum:" + num + "\nstock:" + stock + "\ngoods:"
				+ goods;
		return s;
	}

}
