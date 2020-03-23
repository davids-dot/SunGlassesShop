package com.zhao.dao;

import com.zhao.entity.Cart;
import com.zhao.entity.CartItem;
import com.zhao.entity.Goods;

public interface CartDao {

	public void deleteAll(CartItem cart);

	void addToCart(CartItem item, Cart cart);

	public void addNums(CartItem cartItem, Cart cart);

	public void removeFromCart(Integer goods_id, Integer shop_id, Cart cart);
}
