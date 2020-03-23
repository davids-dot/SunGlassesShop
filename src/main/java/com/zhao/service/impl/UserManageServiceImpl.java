package com.zhao.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zhao.dao.UserManageDao;
import com.zhao.dao.impl.UserManageDaoImpl;
import com.zhao.entity.Page;
import com.zhao.entity.PageBean;
import com.zhao.entity.UserCustom;
import com.zhao.service.UserManageService;

public class UserManageServiceImpl implements UserManageService {
	private UserManageDao userManageDao = new UserManageDaoImpl();

	@Override
	public List<UserCustom> queryUsers(Page op,HttpServletRequest request) throws Exception {
		
		newPage(op,request);
		Page newPage= (Page) request.getSession().getAttribute("page");
		return userManageDao.queryUsers(newPage);
	}

	@Override
	public void updateUser(UserCustom userCustom) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(String userid,String type) throws Exception {
		userManageDao.deleteUser(userid,type);
	}
	@Override
	public void activeUser(String userid,String type) throws Exception {
		userManageDao.activeUser(userid,type);
	}
	
	//设置新的Page
		private void newPage(Page op,HttpServletRequest request) throws Exception {
			//如果是首页
			Page page =(Page) request.getSession().getAttribute("page");
		    if(0==op.getNextPage()){
		    	firstPage(request);
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
		    	firstPage(request);
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
			Page page = (Page) request.getSession().getAttribute("page");
			page.setCurrentPage(page.getCurrentPage()+1);
			
		}

		private void prePage(HttpServletRequest request) {
			Page page = (Page) request.getSession().getAttribute("page");
			page.setCurrentPage(page.getCurrentPage()-1);
		
		}

		private void lastPage(HttpServletRequest request) {
			Page page = (Page) request.getSession().getAttribute("page");
			// 取得页面总数，设置设置新当前页数为末页
			page.setCurrentPage(page.getTotal()-1);getClass();
		
		}

		private void firstPage(HttpServletRequest request) throws Exception {
			Page page=new Page();
			//获取总页数
			int count = queryCount();
			
			int total = count % 5 != 0 ? count / 5 + 1 : count / 5;
			if(total==0){
				total=1;
			}
			page.setTotal(total);
			//设置当前页数
			page.setCurrentPage(0);
			request.getSession().setAttribute("page", page);
		}

		@Override
		public Integer queryCount() throws Exception {
			
			return userManageDao.queryCount();
		}


}
