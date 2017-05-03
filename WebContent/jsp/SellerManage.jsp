<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8" />
		<title>商户中心</title>
		<link href="../css/SellerManage.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-3.1.1.js"></script>
		


		
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
					    	<h1>免费开店</h1>
					    	<p>申请淘宝店铺完全免费; 一个身份只能开一家店; 开店后店铺无法注销; 申请到正式开通预计需1~3个工作日。</p>
	
						<!-- 箭头开始 -->
						<div class="arrows">

					     <div class="arrow">
					     	<div class="step-num">1</div>
					        <div class="step-name">阅读开店须知</div>
					        <div class="step-desc">确认自己符合经营店铺的相关规定</div>
					     </div>
						  <div class="real-arrow"></div>
					     <div class="arrow">
                           <div class="step-num">2</div>
					       <div class="step-name">商家信息认证</div>
					        <div class="step-desc">填写商家真正身份信息以供认证</div>
					     </div>
							 <div class="real-arrow"></div>
					     <div class="last-arrow">
                         	<div class="step-num">3</div>
					       <div class="step-name">申请商铺</div>
					        <div class="step-desc">填写开店相关信息进行申请</div>
                         </div>
                       </div>

				         <!-- 箭头结束-->
				         
				       
						
						 <iframe name="open-page" class="open-page" id="open-page" 
						 >
						 	 </iframe>
						 
						   <script >
				            function direction(){
				            	
								var status=parseInt("${status}");
								
								if(status==3) return "../html/openShopFinish.html";
								if(status==4) return "../html/sellerAd.html";
								 return "../html/openShopRead.html";
							}
				            
				            $("#open-page").attr("src",direction());
				         </script>
						 	

             
					

 




					    </div> <!--content-main 结束-->



					    <div class="content-sub"> 
					     <div class="manage-title">
					      我的事务
					     </div> 
					     <ul class="manage"> 
					      <li class="manageType"> 
					       <div class="type-name"> 
					        <span class="manage-icon" style="background:url(../images/shop.PNG) no-repeat ;"> </span> 
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
					        <span class="manage-icon" style="background:url(../images/trading.PNG) no-repeat ;"> </span> 
					        <span class="name">交易管理</span> 
					        <span class="toggle"></span> 
					       </div> 
					       <ul class="manage-detail-ls"> 
					        <li class="manage-detail"> <a href="#">我要开店</a> </li> 
					        <li class="manage-detail"> <a href="#">状态查询</a> </li> 
					        <li class="manage-detail"> <a href="#">我要开店</a> </li> 
					       </ul> </li> 
					      <li class="manageType"> 
					       <div class="type-name"> 
					        <span class="manage-icon" style="background:url(../images/goods.PNG) no-repeat ;"> </span> 
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
					        <span class="manage-icon" style="background:url(../images/logistics.PNG) no-repeat ;"> </span> 
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
					        <span class="manage-icon" style="background:url(../images/service.PNG) no-repeat ;"> </span> 
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
			});
			
			
		</script>

</html>