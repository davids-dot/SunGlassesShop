<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8" />
		<title>商户中心</title>
		<link href="../../css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
		<link href="../../css/SellerManage.css" rel="stylesheet" type="text/css" />
	<link href="../../css/style.css" rel="stylesheet" type="text/css" media="all" />
		<script type="text/javascript" src="../../js/jquery-3.1.1.js"></script>
		
	


	</head>


    <body>
			<div class="seller-nav"></div>

			<header>
				
				<div class="top_nav">
					<ul>
						<li>首页</li>
						<li>首页</li>
						<li>首页</li>
						<li>首页</li>
						<li>首页</li>
						<li>首页</li>
					</ul>
				</div>
			</header>

					<div class="page"> 
					   <div class="content"> 
					    <div class="content-main">
					    	
					    	
					    	
					    	<!-- 一个导航头 -->
					    	
<div class="header">
		<div class="header-top" style="background-color:#d1965d;">
			<div class="container">	
			<div class="header-top-in">			
				
				<div class="header-in" style="float:left;">
					<ul class="icon1 sub-icon1" style="float:left;">
								<li  ><a href="wishlist.html">新订单</a> </li>
							<li  ><a href="account.html">已付款订单</a></li>
							<li ><a href="#" >已发货订单</a></li>
							<li > <a href="" >已确认订单</a> </li>	
							<li > <a href="checkout.html" >注销</a> </li>	
	
					</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
			</div>
		</div>
		
				           
				            <!-- 一个导航头 -->
				       
						
						 <iframe name="open-page" class="open-page" id="open-page" >
						 	 </iframe>
						 
						  <script>
						  

						  function GetQueryString(name)
						  {
						       var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
						       var r = window.location.search.substr(1).match(reg);
						       if(r!=null)return  unescape(r[2]); return null;
						  }
						  
						     var type= GetQueryString("h");
						     if(type==null||type==undefined){
						    	 $("#open-page").attr("src","realaddGoods.jsp");
						     }else  if(type=="1"){
						    	 $("#open-page").attr("src","realaddGoods.jsp");
						     }else  if(type=="2"){
						    	 
						     }else  if(type=="3"){
						    	 $("#open-page").attr("src","${pageContext.servletContext.contextPath}/GoodsManageServlet?type=queryGoods");
						     }
						  
						  </script>
						 	



					

 



						</div> <!-- header -->
			         </div> <!--content-main 结束-->
			         



					    <div class="content-sub"> 
					     <div class="manage-title">
					      我的事务
					     </div> 
					     <ul class="manage"> 
					      <li class="manageType"> 
					       <div class="type-name"> 
					        <span class="manage-icon" style="background:url(../../images/shop.PNG) no-repeat ;"> </span> 
					        <span class="name">店铺管理</span> 
					        <span class="toggle"></span> 
					       </div> 
					       <ul class="manage-detail-ls"> 
					        <li class="manage-detail"> <a href="#">我要开店</a> </li> 
					        <li class="manage-detail"> <a href="#">状态查询</a> </li> 
					        <li class="manage-detail"> <a href="#">我要开店</a> </li> 
					       </ul> </li> 
					      <li class="manageType"> 
					       <div class="type-name"> 
					        <span class="manage-icon" style="background:url(../../images/trading.PNG) no-repeat ;"> </span> 
					        <span class="name">交易管理</span> 
					        <span class="toggle"></span> 
					       </div> 
					       <ul class="manage-detail-ls"> 
					        <li class="manage-detail"> <a href="${pageContext.servletContext.contextPath}/GoodsManageServlet?type=order&query=new" target="open-page">新订单</a> </li> 
					        <li class="manage-detail"> <a href="${pageContext.servletContext.contextPath}/GoodsManageServlet?type=order&query=paid"  target="open-page">已付款订单</a> </li>
					        <li class="manage-detail"> <a href="${pageContext.servletContext.contextPath}/GoodsManageServlet?type=order&query=delivered"  target="open-page">已发货订单</a> </li>
					        <li class="manage-detail"> <a href="${pageContext.servletContext.contextPath}/GoodsManageServlet?type=order&query=confirmed"  target="open-page">已确认订单</a> </li> 
					       </ul> </li> 
					      <li class="manageType"> 
					       <div class="type-name"> 
					        <span class="manage-icon" style="background:url(../../images/goods.PNG) no-repeat ;"> </span> 
					        <span class="name">宝贝管理</span> 
					        <span class="toggle"></span> 
					       </div> 
					       <ul class="manage-detail-ls"> 
					 					        <li class="manage-detail"> <a  href="/SunGlassesShop/jsp/addGoods.jsp?h=1" >添加宝贝</a> </li> 
					        <li class="manage-detail"> <a href="/SunGlassesShop/jsp/addGoods.jsp?h=2">宝贝下架</a> </li> 
					        <li class="manage-detail"> <a href="/SunGlassesShop/jsp/addGoods.jsp?h=3">宝贝内容更新</a></li> 
					       </ul> </li> 
					      <li class="manageType"> 
					       <div class="type-name"> 
					        <span class="manage-icon" style="background:url(../../images/logistics.PNG) no-repeat ;"> </span> 
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
					        <span class="manage-icon" style="background:url(../../images/service.PNG) no-repeat ;"> </span> 
					        <span class="name">客户服务</span> 
					        <span class="toggle"></span> 
					       </div> 
					       <ul class="manage-detail-ls"> 
					        <li class="manage-detail"> <a href="#">我要开店</a> </li> 
					        <li class="manage-detail"> <a href="#">我要开店</a> </li> 
					        <li class="manage-detail"> <a href="#">我要开店</a> </li> 
					       </ul> </li> 
					     </ul> 
					    </div> <!--content-sub,即左侧导航结束-->
					  </div> 
				</div>
			   
			<footer></footer>
	
    	

    </body>

    <script>
			$(window).ready(
		   
		   function(){
				    var appname=navigator.appVersion;	   
  					var mainheight =(appname.indexOf('Chrome')>-1)
  					?641:$("#open-page").contents().find("body").height();
  					mainheight=(641<mainheight)?mainheight:641;
  					$("#open-page").height(mainheight);
  					window.addEventListener("message",function(){
  					},false);
			}
		   );
			
			
		</script>

</html>