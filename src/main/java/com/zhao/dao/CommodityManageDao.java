package com.zhao.dao;

import java.util.List;

import com.zhao.entity.GoodsCustom;
import com.zhao.entity.Page;

public interface CommodityManageDao {
	//查询商品
	public List<GoodsCustom> queryCommodits(Page page,String userid) throws Exception;
	//计数
	public Integer queryCount(String userid) throws Exception;
	
	//修改商品
	public void updateCommodity(GoodsCustom commodityCustom)throws Exception;
	//删除商品
	public void deleteCommodity(Integer commodityid)throws Exception;

	
	

}
