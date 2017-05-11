<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
	     <div class="manage-title">
					      我的事务
					     </div> 
					     <ul class="manage"> 
					      <li class="manageType"> 
					       <div class="type-name"> 
					        <span class="manage-icon" style="background:url(${pageContext.servletContext.contextPath}/images/shop.PNG) no-repeat ;"> </span> 
					        <span class="name">店铺管理</span> 
					        <span class="toggle"></span> 
					       </div> 
					       <ul class="manage-detail-ls"> 
					        <li class="manage-detail"> <a href="/SunGlassesShop/GoodsManageServlet?type=openShop">我要开店</a> </li> 
					        <li class="manage-detail"> <a href="/SunGlassesShop/GoodsManageServlet?type=openShop">状态查询</a> </li> 
					        <li class="manage-detail"> <a href="/SunGlassesShop/GoodsManageServlet?type=openShop">我要开店</a> </li> 
					       </ul> </li> 
					      <li class="manageType"> 
					       <div class="type-name"> 
					        <span class="manage-icon" style="background:url(${pageContext.servletContext.contextPath}/images/trading.PNG) no-repeat ;"> </span> 
					        <span class="name">交易管理</span> 
					        <span class="toggle"></span> 
					       </div> 
					     <ul class="manage-detail-ls"> 
					        <li class="manage-detail"> <a class="traddingManage" href="${pageContext.servletContext.contextPath}/GoodsManageServlet?type=order&query=new" target="open-page">新订单</a> </li> 
					        <li class="manage-detail"> <a class="traddingManage" href="${pageContext.servletContext.contextPath}/GoodsManageServlet?type=order&query=paid"  target="open-page">已付款订单</a> </li>
					        <li class="manage-detail"> <a class="traddingManage" href="${pageContext.servletContext.contextPath}/GoodsManageServlet?type=order&query=delivered"  target="open-page">已发货订单</a> </li>
					        <li class="manage-detail"> <a class="traddingManage" href="${pageContext.servletContext.contextPath}/GoodsManageServlet?type=order&query=confirmed"  target="open-page">已收货订单</a> </li> 
					       </ul> </li> 
					      <li class="manageType"> 
					       <div class="type-name"> 
					        <span class="manage-icon" style="background:url(${pageContext.servletContext.contextPath}/images/goods.PNG) no-repeat ;"> </span> 
					        <span class="name">宝贝管理</span> 
					        <span class="toggle"></span> 
					       </div> 
					       <ul class="manage-detail-ls"> 
					 					      <li class="manage-detail"> <a  href="${pageContext.servletContext.contextPath}/GoodsManageServlet?type=queryAdd&h=1" >添加宝贝</a> </li> 
					        <li class="manage-detail"> <a href="${pageContext.servletContext.contextPath}/GoodsManageServlet?type=queryAdd&h=2">宝贝下架</a> </li> 
					        <li class="manage-detail"> <a href="${pageContext.servletContext.contextPath}/GoodsManageServlet?type=queryAdd&h=3">宝贝内容更新</a></li> 
					       </ul> </li> 
					      <li class="manageType"> 
					       <div class="type-name"> 
					        <span class="manage-icon" style="background:url(${pageContext.servletContext.contextPath}/images/logistics.PNG) no-repeat ;"> </span> 
					        <span class="name">物流管理</span> 
					        <span class="toggle"></span> 
					       </div> 
					       <ul class="manage-detail-ls"> 
					        <li class="manage-detail"> <a href="#">我要开店</a> </li> 
					        <li class="manage-detail"> <a href="#">我要开店</a> </li> 
					        <li class="manage-detail"> <a href="#">我要开店</a> </li> 
					       </ul> </li> 
					      <li class="manageType"> 
					       <div class="type-name"> 
					        <span class="manage-icon" style="background:url(${pageContext.servletContext.contextPath}/images/service.PNG) no-repeat ;"> </span> 
					        <span class="name">客户服务</span> 
					        <span class="toggle"></span> 
					       </div> 
					       <ul class="manage-detail-ls"> 
					        <li class="manage-detail"> <a href="#">我要开店</a> </li> 
					        <li class="manage-detail"> <a href="#">我要开店</a> </li> 
					        <li class="manage-detail"> <a href="#">我要开店</a> </li> 
					       </ul> </li> 
					     </ul> 
  <script>

   $(function(){
	   
	   var traddings = document.getElementsByClassName("traddingManage");
	   for(var i=0;i<traddings.length;i++){
		   traddings[i].onclick= function(){
		 		  var navBar =document.getElementById("navBarr");
		 		  var contentMain =document.getElementById("contentMain");
		 		  if(navBar==null||navBar==undefined){
		 				var openPage =document.getElementById("open-page");
		 		        contentMain.innerHTML='<div class="header"><div class="header-top" style="background-color:#d1965d;"><div class="container"><div class="header-top-in">	<div class="header-in" style="float:left;"><ul class="icon1 sub-icon1" style="float:left;" id="navBarr"></ul></div><div class="clearfix"> </div></div></div></div> <iframe name="open-page" class="open-page" id="open-page" scrolling="no"  style="min-height:641px;"></iframe>';
		 		  }
		 		
		 		  console.log(contentMain.innerHTML);
		 		 
		 		  navBar =document.getElementById("navBarr");
		 		  console.log(navBar);
		 		  navBar.innerHTML=
		 			"<li><a href='/SunGlassesShop/GoodsManageServlet?type=order&query=new' target='open-page'>新订单</a></li>"+
					"<li><a href='/SunGlassesShop/GoodsManageServlet?type=order&query=paid' target='open-page'>已付款订单</a></li>"+
					"<li><a href='/SunGlassesShop/GoodsManageServlet?type=order&query=delivered' target='open-page'>已发货订单</a></li>"+
					"<li><a href='/SunGlassesShop/GoodsManageServlet?type=order&query=confirmed' target='open-page'>已收货订单</a></li>"+
					"<li><a href='checkout.html'>注销</a></li>";
				 
		    }
	 	 
	   }
	   
   });
  
  
  </script>