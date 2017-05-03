package com.zhao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhao.dao.SellerDao;
import com.zhao.dao.ShopDao;
import com.zhao.dao.impl.GoodsDaoImpl;
import com.zhao.dao.impl.SellerDaoImpl;
import com.zhao.dao.impl.ShopDaoImpl;
import com.zhao.entity.Goods;
import com.zhao.entity.PageBean;
import com.zhao.entity.QueryInfo;
import com.zhao.entity.QueryResult;
import com.zhao.entity.Seller;
import com.zhao.entity.Shop;
import com.zhao.exception.GoodsHasExistException;
import com.zhao.exception.IllegalException;
import com.zhao.service.SellerService;

public class SellerServiceImpl implements SellerService {

	public SellerServiceImpl() {

	}

	@Override
	public void changeInfo(Seller sel, String name) {
		SellerDao sdao = new SellerDaoImpl();
		sdao.updateSeller(sel, name);
	}

	@Override
	public void addShop(Shop shop) {
		ShopDao sd = new ShopDaoImpl();
		sd.addShop(shop);
	}

	@Override
	public Seller findSeller(String name) {

		SellerDao sdao = new SellerDaoImpl();
		return sdao.findSeller(name);

	}

	public static void main(String[] args) {

	}

	@Override
	public Integer ensureStatus(Seller sel) {

		/*
		 * 数据库无身份证信息 ，状态1
		 * 
		 */
		SellerDao sdao = new SellerDaoImpl();

		Seller newSell = sdao.findSeller(sel.getName());
		if (newSell.getId_card() == null)
			return 1;

		/*
		 * 无商铺，状态二
		 */
		ShopDao spdao = new ShopDaoImpl();
		Shop shop = spdao.findShop(newSell.getSeller_id());
		if (shop == null)
			return 2;

		/*
		 * 有商铺，商铺未认证，状态三
		 */

		if (shop.getVerify().equals(0))
			return 3;

		/*
		 * 有商铺,商铺已认证，状态四
		 */

		return 4;
	}

	//

	@Override
	public void addToShop(Seller sel, Goods goods) {

		/*
		 * 先查看Goods 表中是否有同名商品，若有，再添加至shop_has_goods中。
		 * #若没有，先添加到goods中，再添加到shop_has_Goods 中。
		 */

		try {

			GoodsDaoImpl gdao = new GoodsDaoImpl();
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("barCode", goods.getBarCode());
			boolean exist = gdao.exist(params);
			if (!exist) {
				gdao.add(goods);
			}

			goods = gdao.find("barCode", goods.getBarCode());//

			SellerDao sdao = new SellerDaoImpl();
			ShopDao shdao = new ShopDaoImpl();
			Shop shop = shdao.findShop(sel.getSeller_id());// sel 必须得有id

			exist = sdao.existGoodsInShop(goods, shop);// 再此之前，需要获得goods_id
			if (exist) {
				throw new GoodsHasExistException();
			}

			// 在此处。获取goods_id

			sdao.addGoodsToShop(sel, goods, shop);

			System.out.println("添加商品完成");

			/*
			 * shop_has_goods //shop_id ,goods_id, stock
			 *
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	@Deprecated
	public List<Goods> queryGoods(Seller sel) throws IllegalException {

		if (sel == null || sel.getSeller_id() == null) {
			throw new IllegalException("sel 或sel_id 未赋值");
		}

		ShopDao sdao = new ShopDaoImpl();
		Shop shop = sdao.findShop(sel.getSeller_id());

		GoodsDaoImpl gdao = new GoodsDaoImpl();
		return gdao.selectGoodsInshop(shop);

	}

	@Override
	public PageBean queryGoods(Seller sel, QueryInfo queryInfo) throws IllegalException {

		/*
		 * 准备工作
		 */
		if (sel == null || sel.getSeller_id() == null) {
			throw new IllegalException("sel 或sel_id 未赋值");
		}

		ShopDao sdao = new ShopDaoImpl();
		Shop shop = sdao.findShop(sel.getSeller_id());

		//
		GoodsDaoImpl gdao = new GoodsDaoImpl();
		QueryResult qr = gdao.selectGoodsInshop(shop, queryInfo.getStartIndex(), queryInfo.getPageSize());

		PageBean page = new PageBean();
		page.setList(qr.getList());
		page.setCurrentPage(queryInfo.getCurrentPage());
		page.setPageSize(queryInfo.getPageSize());
		page.setTotalRecords(qr.getTotalRecords());

		return page;
	}

}
