<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8" />
		<title>商户中心</title>
		
	
		    		<link href="${pageContext.servletContext.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
		<link href="${pageContext.servletContext.contextPath}/css/SellerManage.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet" type="text/css" media="all" />
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery-3.1.1.js"></script>


		
	</head>


    <body>
			<div class="seller-nav"></div>

			<header>
				
				<div class="top_nav">
					<ul>
						<li><a href="${pageContext.servletContext.contextPath}">首页</a></li>
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
					    <div class="content-main" id="contentMain">
					    	<h1>免费开店</h1>
					    	<p>申请淘宝店铺完全免费; 一个身份只能开一家店; 开店后店铺无法注销; 申请到正式开通预计需1~3个工作日。</p>
	
						<!-- 箭头开始 -->
						<div class="arrows">

					     <div class="arrow">
					     	<div class="step-num">1</div>
					        <div class="step-name">阅读开店须知</div>
					        <div class="step-desc">确认符合经营店铺的相关规定</div>
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
				   </div> <!--content-main 结束--> 
						   <script >
				            function direction(){
				            	
								var status=parseInt("${status}");
								
								if(status==3) return "../html/openShopFinish.html";
								if(status==4) return "../html/sellerAd.html";
								 return "../html/openShopRead.html";
							}
				            
				            $("#open-page").attr("src",direction());
				         </script>
						 	

             


					    



					    <div class="content-sub"> 
					   <%@ include file="content-sub.jsp"%>
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