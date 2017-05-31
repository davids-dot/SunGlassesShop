package com.zhao.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zhao.dao.CommodityManageDao;
import com.zhao.dao.impl.CommodityManageDaoImpl;
import com.zhao.entity.GoodsCustom;
import com.zhao.entity.Page;
import com.zhao.service.CommodityManageService;

public class CommodityManageServiceImpl implements CommodityManageService {
    private CommodityManageDao commodityManageDao=new CommodityManageDaoImpl();
	@Override
	public List<GoodsCustom> queryCommodits(Page op, String userid,HttpServletRequest request) throws Exception {
		
		newPage(op,request,userid);
		Page newPage= (Page) request.getSession().getAttribute("commoditypage");
		return commodityManageDao.queryCommodits(newPage, userid);
	}

	@Override
	public Integer queryCount(String userid) throws Exception {
		// TODO Auto-generated method stub
		return commodityManageDao.queryCount(userid);
	}

	@Override
	public void updateCommodity(GoodsCustom commodityCustom) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCommodity(Integer commodityid) throws Exception {
		commodityManageDao.deleteCommodity(commodityid);

	}
	//设置新的Page
	private void newPage(Page op,HttpServletRequest request,String userid) throws Exception {
		//如果是首页
		Page page =(Page) request.getSession().getAttribute("commoditypage");
	    if(0==op.getNextPage()){
	    	firstPage(request,userid);
	    	return ;
	    }
	    
	    //如果是末页
	    if(2==op.getNextPage()){
	    	 lastPage(request);
	    	 return ;
	    }
	    
	    //如果是上一页
	    if(-1==op.getNextPage()){
	    	//判断当前是不是首页
	    	if(0==page.getCurrentPage()){
	    		//是首页
	    	firstPage(request,userid);
	    	 return ;
	    	}else{
	    		//不是
	    	prePage(request);
	    	 return ;
	    	}
	    	
	    }
	    
	    //如果是下一页
	    if(1==op.getNextPage()){
	    	//判断当前是不是末页
	    	if((page.getTotal()-1)>page.getCurrentPage()){
	    		//不是
	    		nextPage(request);
	    		 return ;
	    	
	    	}else{
	    		//是末页
	    		lastPage(request);
	    		 return ;
	    	}
	    }
	    return ;
	}

	private void nextPage(HttpServletRequest request) {
		Page page = (Page) request.getSession().getAttribute("commoditypage");
		page.setCurrentPage(page.getCurrentPage()+1);
		
	}

	private void prePage(HttpServletRequest request) {
		Page page = (Page) request.getSession().getAttribute("commoditypage");
		page.setCurrentPage(page.getCurrentPage()-1);
	
	}

	private void lastPage(HttpServletRequest request) {
		Page page = (Page) request.getSession().getAttribute("commoditypage");
		// 取得页面总数，设置设置新当前页数为末页
		page.setCurrentPage(page.getTotal()-1);getClass();
	
	}

	private void firstPage(HttpServletRequest request,String userid) throws Exception {
		Page page=new Page();
		//获取总页数
		int count = queryCount(userid);
		
		int total = count % 5 != 0 ? count / 5 + 1 : count / 5;
		if(total==0){
			total=1;
		}
		page.setTotal(total);
		//设置当前页数
		page.setCurrentPage(0);
		request.getSession().setAttribute("commoditypage", page);
	}



}
