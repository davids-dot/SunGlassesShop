<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					    <div class="content-main" id="contentMain">
					    	
					    	
					    	
					    	<!-- 一个导航头 -->
					    	
<div class="header">
		<div class="header-top" style="background-color:#d1965d;">
			<div class="container">	
			<div class="header-top-in">			
				
				<div class="header-in" style="float:left;">
					<ul class="icon1 sub-icon1" style="float:left;" id="navBarr">
						 <li  ><a href="${pageContext.servletContext.contextPath}/jsp/realaddGoods.jsp" target="open-page">添加宝贝</a> </li>
							<li  ><a href="${pageContext.servletContext.contextPath}/jsp/realaddGoods.jsp" target="open-page">宝贝下架</a></li>
							<li ><a href="${pageContext.servletContext.contextPath}/GoodsManageServlet?type=queryGoods"  target="open-page">宝贝内容更新</a></li>
							<li > <a href="" >注销</a> </li>	
					</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
			</div>
		</div>
		
				           
				            <!-- 一个导航头 -->
				       
						
						 <iframe name="open-page" class="open-page" id="open-page" >
						 	 </iframe>
					</div> <!--content-main 结束-->	 
						  <script>
						  

						  function GetQueryString(name)
						  {
						       var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
						       var r = window.location.search.substr(1).match(reg);
						       if(r!=null)return  unescape(r[2]); return null;
						  }
						  
						     var type= GetQueryString("h");
						     var hi=$("#open-page").attr("src");
						     
						     if(type==null||type==undefined){
						    	 $("#open-page").attr("src","${pageContext.servletContext.contextPath}/jsp/realaddGoods.jsp");
						     }else  if(type=="1"){
						    	 $("#open-page").attr("src","${pageContext.servletContext.contextPath}/jsp/realaddGoods.jsp");
						     }else  if(type=="2"){
						    	 
						     }else  if(type=="3"){
						    	 $("#open-page").attr("src","${pageContext.servletContext.contextPath}/GoodsManageServlet?type=queryGoods");
						     }
						  
						  </script>
						
						</div> <!-- header -->
			         
			         

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
			}
		   );
			
			
		</script>

</html>