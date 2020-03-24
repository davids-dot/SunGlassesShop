package com.zhao.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.zhao.dao.CommodityManageDao;
import com.zhao.entity.GoodsCustom;
import com.zhao.entity.Page;
import com.zhao.entity.Shop;
import com.zhao.util.BeanListHandler;
import com.zhao.util.DBUtil2;
import com.zhao.util.ResultSizeHandler;

public class CommodityManageDaoImpl implements CommodityManageDao {

	@Override
	public List<GoodsCustom> queryCommodits(Page page,String userid) throws Exception {
		//查询用户所对应的商铺id
		String sql="select goods .* from goods where goods_id in "
				+ "(select goods_id from shop_has_goods where shop_id="
				+ "(select shop_id from shop where seller_id="
				+ "(select seller_id from seller where name= ?)))"
				+ " limit " + page.getCurrentPage() * 5 + "," + 5;
		return (List<GoodsCustom>) DBUtil2.executeQuery(sql, new BeanListHandler<GoodsCustom>(GoodsCustom.class),
				userid);
	}

	@Override
	public Integer queryCount(String userid) throws Exception {
		String sql="select goods .* from goods where goods_id in "
				+ "(select goods_id from shop_has_goods where shop_id="
				+ "(select shop_id from shop where seller_id="
				+ "(select seller_id from seller where name= ?)))";
 		return (Integer) DBUtil2.executeQuery(sql,  new ResultSizeHandler(), userid);
	}

	@Override
	public void updateCommodity(GoodsCustom commodityCustom) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCommodity(Integer commodityid) throws Exception {
		String sql = "delete from shop_has_goods where goods_id=?";
		List<Object> params=new ArrayList<>();
 		params.add(commodityid);
		DBUtil2.executeUpdate(sql, params);
	}



}
