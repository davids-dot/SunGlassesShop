package com.zhao.service;

import com.zhao.entity.Seller;
import com.zhao.entity.Shop;

public interface SellerService {

	public void changeInfo(Seller sel, String name);

	public void addShop(Shop shop);

	public Seller findSeller(String name);

}
