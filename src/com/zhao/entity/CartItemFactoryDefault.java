package com.zhao.entity;

import java.sql.SQLException;
import java.util.Arrays;

import com.zhao.dao.impl.GoodsDaoImpl;
import com.zhao.exception.NoAvailableGoodsException;
import com.zhao.util.BeanHandler;
import com.zhao.util.DBUtil2;

public class CartItemFactoryDefault implements CartItemFactory {

	/*
	 * CartItem private Integer goods_id; private Integer num; private Integer
	 * shop_id; private Goods goods; private Integer stock
	 * 
	 * @see com.zhao.entity.CartItemFactory#createCartItem(java.lang.Integer)
	 */

	// 写的时候糊涂，不知道有什么用
	@Override
	public CartItem createCartItem(Integer goods_id) throws NoAvailableGoodsException {

		try {
			String sql = "select goods_id,shop_id ,stock from shop_has_goods where stock >0 and goods_id = ? ";
			CartItem cartItem = (CartItem) DBUtil2.executeQuery(sql, Arrays.asList(goods_id),
					new BeanHandler<CartItem>(CartItem.class));
			//
			if (cartItem == null) {
				throw new NoAvailableGoodsException("该商品暂时缺货");
			}

			GoodsDaoImpl gdao = new GoodsDaoImpl();
			System.out.println("goods_id==null" + (goods_id == null));
			cartItem.setGoods(gdao.find("goods_id", goods_id));
			cartItem.setNum(1);
			return cartItem;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
