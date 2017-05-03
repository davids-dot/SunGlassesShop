package com.zhao.entity;

import com.zhao.exception.NoAvailableGoodsException;

public interface CartItemFactory {

	// 根据goods_id 产生CartItem
	public CartItem createCartItem(Integer goods_id) throws NoAvailableGoodsException;
}
