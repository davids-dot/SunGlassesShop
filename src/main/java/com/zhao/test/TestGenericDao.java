package com.zhao.test;

import java.util.HashMap;
import java.util.Map;

import com.zhao.dao.impl.GoodsDaoImpl;
import com.zhao.entity.Goods;

public class TestGenericDao {

	public static void main(String[] args) {

		GoodsDaoImpl gdao = new GoodsDaoImpl();
		Goods gs = new Goods("海尔冰箱", "79854562", "C:/fddgg", "江南制造厂");
		gs.setArea("111111");
		gs.setBrand("康师傅");
		gs.setPrice(12.8);
		gs.setProductionDate(java.sql.Date.valueOf("2011-04-03"));

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("barCode", gs.getBarCode());
		boolean exist = gdao.exist(params);
		if (!exist) {
			gdao.add(gs);
		}

		Goods goods = gdao.find("barCode", gs.getBarCode());
		System.out.println(goods);

	}

}
