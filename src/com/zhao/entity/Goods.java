package com.zhao.entity;

import java.sql.Date;

public class Goods {
	private Integer goods_id;
	private String name;
	private String barCode;
	private String picURI;
	private String manufacturer;
	private String brand;
	private String area;
	private Date productionDate;
	private Double price;

	public Goods(String name, String barCode, String picURI, String manufacturer, String brand, String area) {
		this.name = name;
		this.barCode = barCode;
		this.picURI = picURI;
		this.manufacturer = manufacturer;
		this.brand = brand;
		this.area = area;
	}

	public Goods(String name, String barCode, String picURI, String manufacturer) {
		this.name = name;
		this.barCode = barCode;
		this.picURI = picURI;
		this.manufacturer = manufacturer;

	}

	public Goods() {

	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getPicURI() {
		return picURI;
	}

	public void setPicURI(String picURI) {
		this.picURI = picURI;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String toString() {
		return "goods_id : " + goods_id + "\nname: " + name + "\nbarCode: " + barCode + "\npicURI: " + picURI
				+ "\nmanufacturer: " + manufacturer + "\nbrand:" + brand + "\narea:" + area + "\nproductionDate:"
				+ productionDate + "\nprice:" + price + "\n";
	}

}
