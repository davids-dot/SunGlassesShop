<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/my" prefix="my" %>

<!DOCTYPE html>
<html>
<head>
<title>Single</title>
<jsp:useBean id="now" class="java.util.Date"  scope="page"></jsp:useBean>
  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link href="${pageContext.servletContext.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<script src="${pageContext.servletContext.contextPath}/js/jquery.min.js"></script>

<link href="${pageContext.servletContext.contextPath}/css/style.css?${now.time}" rel="stylesheet" type="text/css" media="all" />	

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--fonts-->
<link href='https://fonts.googleapis.com/css?family=Exo:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
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
  .nav>li{
  margin:0 1em;
 }
            footer{
                    width:85%;
				 	margin:0 auto;
				 	background-color:#999999;
		
				 }
	     .links{
						margin:5px 0;
					}
					.links li{
							width:10%;
							margin-left: 4%;
							list-style-type: none;
							float:left;
							font: 14px Arial,Verdana,"宋体";
					}

					.links li[pos="first"]{
							width:10%;
							margin-left:0;
							list-style-type: none;
							float:left;
							font: 14px Arial,Verdana,"宋体";
					}

					.copyright{
						margin-top:20px;
						font: 12px Arial,Verdana,"宋体";
						text-align: center;
					}

					
	
	
	

</style>


</head>
<body>
  <!--header-->
	<div class="header">
		<div class="header-top">
			<div class="container">	
			<div class="header-top-in">			
				<div class="logo">
					<a href="index.html"><img src="${pageContext.servletContext.contextPath}/images/logo.png" alt=" " ></a>
				</div>
				<div class="header-in">
					<ul class="icon1 sub-icon1">
							<li  ><a href="wishlist.html">我的收藏<span>(0)</span></a> </li>
							<li  ><a href="account.html">我的账号</a></li>
							<li  ><a href="${pageContext.servletContext.contextPath}/BussinessServlet?type=showAll">我的订单</a></li>
							<li ><a href="${pageContext.servletContext.contextPath}/CartServlet?type=showAll" >我的购物车</a></li>
							<li > <a href="checkout.html" >注销</a> </li>	
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
					                <div class="list_img"><img src="${pageContext.servletContext.contextPath}/images/girl1.jpg" class="img-responsive" alt=""></div>
								    <div class="list_desc"><h4><a href="#">宝贝1</a></h4>1 x<span class="actual">
		                             ￥12.00</span></div>
		                              <div class="clearfix"></div>
	                              </div>
	                            </div>
	                            <div class="cart_box1">
								  <div class="message1">
							   	     <div class="alert-close1"> </div> 
					                <div class="list_img"><img src="images/15.jpg" class="img-responsive" alt=""></div>
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
		<div class="header-bottom">
		<div class="container">
			<div class="h_menu4">
				<a class="toggleMenu" href="#">Menu</a>
				<ul class="nav">
					<li class="active"><a href="index.html"><i> </i>首页</a></li>
					<li ><a href="#" >Laptops &amp; Notebooks</a>
						<ul class="drop">
							<li><a href="products.html">Sony(2)</a></li>
							<li><a href="products.html">Android(4)</a></li>
							
						</ul>
					</li> 						
						<li><a href="products.html" >首页</a></li>            
						<li><a href="products.html" >首页</a></li>   						  				 
						<li><a href="products.html" >首页</a></li>   						  				 
						<li><a href="products.html" >首页</a></li>   						  				 
						<li><a href="products.html" >首页</a></li>   						  				 
						<li><a href="products.html" >首页</a></li>   						  				 
						<li><a href="products.html" >首页</a></li>   						  				 
					
				</ul>
				<script type="text/javascript" src="js/nav.js"></script>
			</div>
		</div>
		</div>
		<div class="header-bottom-in">
		<div class="container">
		
		<div class="header-bottom-on">
			<p class="wel"><a href="#">欢迎光临，您可以现在登录或申请账号。</a></p>
			<div class="header-can">
				<ul class="social-in">
						<li><a href="#"><i> </i></a></li>
						<li><a href="#"><i class="facebook"> </i></a></li>
						<li><a href="#"><i class="twitter"> </i></a></li>					
						<li><a href="#"><i class="skype"> </i></a></li>
					</ul>	
					<div class="down-top">		
						  <select class="in-drop">
							  <option value="Dollars" class="in-of">商品</option>
							  <option value="Euro" class="in-of">商铺</option>
							</select>
					 </div>
					<div class="search">
						<form>
							<input type="text"  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}">
							<input type="submit" value="搜索">
						</form>
					</div>
					<div class="clearfix"> </div>
			</div>
			<div class="clearfix"></div>
		</div>
		</div>
		</div>
	</div>
	<!---->
		<div class="container">
			<div class="single">
				<div class="col-md-9 top-in-single">
					<div class="col-md-5 single-top">	<!-- 左边图像 -->
					
				            <div >
							        <!-- FlexSlider -->
										<script src="${pageContext.servletContext.contextPath}/js/imagezoom.js"></script>
										
										<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/flexslider.css" type="text/css" media="screen" />

									

							  <ul style="list-style-type:none;">
								<li data-thumb="${my:mapToServer(requestScope.goods.picURI)}">
									<div class="thumb-image"> <img src="${my:mapToServer(requestScope.goods.picURI)}" data-imagezoom="true" class="img-responsive" style="width:100%;height:406px"> </div>
								</li>
							
							  </ul>
							<div class="clearfix"></div>
					     </div>
					</div>	<!-- 左边图像 结束-->
					
					<div class="col-md-7 single-top-in">
						<div class="single-para">
							<h4>${goods.name}</h4>
							<div class="para-grid">
								<span  class="add-to">￥${goods.price}</span>
								<a href="javascript:void(0);" onclick="addTocart(${goods.goods_id})" class="hvr-shutter-in-vertical cart-to">加入购物车</a>					
								<div class="clearfix"></div>
							 </div>
							<h5>库存999</h5>
							<div class="available">
								<h6>可选:</h6>
								<ul>
									<li>颜色:
										<select>
										<option>银白</option>
										<option>炫黑</option>
										<option>纯黑</option>
										<option>经典红</option>
									</select></li>
								<li>Size:<select>
									<option>Large</option>
									<option>Medium</option>
									<option>small</option>
									<option>Large</option>
									<option>small</option>
								</select></li>
								<li>数量:<select>
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
								</select></li>
							</ul>
						</div>
							<p>
							   宝贝品牌：${goods.brand }<br/>
							   宝贝厂家：${goods.manufacturer} <br/>
							   宝贝出厂日期： ${goods.productionDate }<br/>
							   宝贝条形码： ${goods.barCode}<br/>
							</p>
							
								<a href="javascript:void(0);" class="hvr-shutter-in-vertical " onclick="buyGoods(${goods.goods_id})">立即购买</a>
							
						</div>
					</div>
				<div class="clearfix"> </div>
				<div class="content-top-in">
						<div class="col-md-4 top-single">
							<div class="col-md">
								<img  src="images/pic8.jpg" alt="商品图片" />	
								<div class="top-content">
									<h5>呃呃呃</h5>
									<div class="white">
										<a href="#" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">加入购物车</a>
										<p class="dollar"><span class="in-dollar">$</span><span>20</span></p>
										<div class="clearfix"></div>
									</div>
								</div>							
							</div>
						</div>
						<div class="col-md-4 top-single">
							<div class="col-md">
								<img  src="images/pic8.jpg" alt="商品图片" />	
								<div class="top-content">
									<h5>呃呃呃</h5>
									<div class="white">
										<a href="#" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">加入购物车</a>
										<p class="dollar"><span class="in-dollar">$</span><span>20</span></p>
										<div class="clearfix"></div>
									</div>
								</div>							
							</div>
						</div>
						<div class="col-md-4 top-single-in">
							<div class="col-md">
								<img  src="images/pic8.jpg" alt="商品图片" />	
								<div class="top-content">
									<h5>呃呃呃</h5>
									<div class="white">
										<a href="#" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">加入购物车</a>
										<p class="dollar"><span class="in-dollar">$</span><span>20</span></p>
										<div class="clearfix"></div>
									</div>
								</div>							
							</div>
						</div>
						
					<div class="clearfix"></div>
					</div>
				</div>
				
				<div class="col-md-3">
					<div class="single-bottom">
						<h4>扩展</h4>
						<ul>
						<li><a href="#"><i> </i>内容1</a></li>
						<li><a href="#"><i> </i>内容1</a></li>
						<li><a href="#"><i> </i>内容1</a></li>
						<li><a href="#"><i> </i>内容1</a></li>
						<li><a href="#"><i> </i>内容1</a></li>
						<li><a href="#"><i> </i>内容1</a></li>
						</ul>
					</div>
					<div class="single-bottom">
						<h4>扩展</h4>
						<ul>
						<li><a href="#"><i> </i>内容1</a></li>
						<li><a href="#"><i> </i>内容1</a></li>
						<li><a href="#"><i> </i>内容1</a></li>
						<li><a href="#"><i> </i>内容1</a></li>
						<li><a href="#"><i> </i>内容1</a></li>
						<li><a href="#"><i> </i>内容1</a></li>
						</ul>
					</div>
	
				</div>
				<div class="clearfix"> </div>
		</div>
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		<!---->
				<footer>

						<div class="links">
								<ul style="overflow: hidden">
									<li pos="first"><a> 关于我们</a></li>
									<li><a> 联系我们</a></li>
									<li><a> 人才招聘</a></li>
									<li><a> 商家入驻</a></li>
									<li><a> 广告服务</a></li>
									<li><a> 友情链接</a></li>
									<li><a> EnglishSite</a></li>
								</ul>

								<div class="copyright">
									Copyright &nbsp;&copy; &nbsp;2004-2017 &nbsp; 明宇MY.com &nbsp;版权所有
								</div>

						</div>
				</footer>
			
			<script type="text/javascript">
			        function addTocart(id){
			        	window.location.href="${pageContext.servletContext.contextPath}/CartServlet?type=add&goods_id="+id;
			        }		
			        function buyGoods(id){
			        	window.location.href="${pageContext.servletContext.contextPath}/BussinessServlet?type=buy&goods_id="+id;
			        }
			
			</script>
			
				<!--  goodsDetail 可能发出的URL请求方式
									CartServlet?type=add&goods_id="+id;
									/BussinessServlet?type=buy&goods_id="+id;
									/BussinessServlet?type=showAll
							/CartServlet?type=showAll
		        -->
</body>
</html>