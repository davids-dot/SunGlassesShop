<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="now" class="java.util.Date"  scope="page"></jsp:useBean>
  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link href="${pageContext.servletContext.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<script src="${pageContext.servletContext.contextPath}/js/jquery.min.js"></script>

<link href="${pageContext.servletContext.contextPath}/css/style.css?${now.time}" rel="stylesheet" type="text/css" media="all" />	

<meta name="viewport" content="width=device-width, initial-scale=1">
<!--fonts-->
<!--//fonts-->

				<script type="text/javascript">
					jQuery(document).ready(function($) {
						$(".scroll").click(function(event){		
							event.preventDefault();
							$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
						});
					});
				</script>

<script>$(document).ready(function(c) {
	$('.alert-close').on('click', function(c){
		$('.message').fadeOut('slow', function(c){
	  		$('.message').remove();
		});
	});	  
});
</script>
<script>$(document).ready(function(c) {
	$('.alert-close1').on('click', function(c){
		$('.message1').fadeOut('slow', function(c){
	  		$('.message1').remove();
		});
	});	  
});
</script>

<style>
  .container{
   padding:0px 110px;
  }
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <div class="header-top">
			<div class="container">	
			<div class="header-top-in">			
				<div class="logo" style="background-color:#fb55e33;">
					<a href="index.html"><img src="${pageContext.servletContext.contextPath}/images/logo.png" style ="height:60px;opacity:0.4;" alt=" " ></a>
				</div>
				<div class="header-in">
					<ul class="icon1 sub-icon1">
							<li  ><a href="${pageContext.servletContext.contextPath }">首页</a> </li>
							<li  ><a href="account.html">我的账号</a></li>
							<li  ><a href="${pageContext.servletContext.contextPath}/BussinessServlet?type=showSome">我的订单</a></li>
							<li ><a href="${pageContext.servletContext.contextPath}/CartServlet?type=showAll" >我的购物车</a></li>
							<li > <a href="${pageContext.servletContext.contextPath}" >注销</a> </li>	
							<li><div class="cart">
									<a href="#" class="cart-in"> </a>
									<span>0</span>
								</div>
					<!-- 一个悬浮的购物车最新 -->
					<ul class="sub-icon1 list"><li>
						  <h3>最近添加宝贝(2)</h3>
						  <div class="shopping_cart">
							  <div class="cart_box">
							   	 <div class="message">
							   	     <div class="alert-close"> </div> 
					                <div class="list_img"><img class="img-responsive" alt=""/></div>
								    <div class="list_desc"><h4><a href="#">宝贝1</a></h4>1 x<span class="actual">
		                             ￥12.00</span></div>
		                              <div class="clearfix"></div>
	                              </div>
	                            </div>
	                            <div class="cart_box1">
								  <div class="message1">
							   	     <div class="alert-close1"> </div> 
					                <div class="list_img"><img /></div>
								    <div class="list_desc"><h4><a href="#">宝贝2</a></h4>1 x<span class="actual">
		                             ￥12.00</span></div>
		                              <div class="clearfix"></div>
	                              </div>
	                            </div>
	                        </div>
	                        <div class="total">
	                        	<div class="total_left">总价: </div>
	                        	<div class="total_right">$250.00</div>
	                        	<div class="clearfix"></div>
	                        </div>
                            <div class="login_buttons">
							  <div class="check_button"><a href="checkout.html">注销</a></div>
							  <div class="clearfix"></div>
						    </div>
					      <div class="clearfix"></div>
					      </li>
						</ul>
						 <!-- 一个悬浮的购物车最新 -->
						
						
							</li>
						</ul>
				</div><!-- header-in 结束 -->
				<div class="clearfix"> </div>
			</div>
			</div>
		</div>