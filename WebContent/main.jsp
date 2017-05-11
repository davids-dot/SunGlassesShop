<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/my" prefix="my" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>明宇太阳镜商城</title>
<link href="${pageContext.servletContext.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
			
<link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet" type="text/css" media="all" />	
			
		<link type="text/css" rel="stylesheet" href="index.css"></link>	
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.servletContext.contextPath}/js/jquery-3.1.1.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->

<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery.flexisel.js"></script>
<!--//theme-style-->


<style>
ul.page {
	padding: 1em 0 1em 15em;
	
	display:block;
	
}
ul.page li {
	display: inline-block;
    padding: 0 0.25em;
}
ul.page li.arrow a, ul.page li span {
	text-decoration: none;
	color: #362f2f;
	font-size: 1em;
	padding: 0.4em 0.9em;
	background: rgb(217,217,217);
	
	border-radius: 5px;
	display:block;
	font-weight: 400;
}
ul.page li span,ul.page li.arrow a:hover{
	background: rgb(252,94,53);
	color:#fff;
}
ul.page li a i{
	background: url(/SunGlassesShop/images/img-sprite.png)no-repeat -90px -56px;
	width: 36px;
	height: 36px;
	display:inline-block;
	vertical-align:middle;	
}
ul.page li a i.next {
	background-position:-136px -54px;
}


.head-top{
  padding:0 82px;
}
.head-top li{
  
    float:right;
    padding:0 5px;
}
.head-top a{
   
   color:#fff;
   text-decoration:underline;
       vertical-align: -webkit-baseline-middle;
     
}


.search_text {
    width: 30%;
    background-color: #90c31f;
    text-align: center;
}

#search_main {
    width: 80%;
    margin-top: 15px;
    height: 35px;
    border: 1px solid white;
    background: url(images/find.png) no-repeat right center;
    background-color: white;
    padding-right: 15px;
}


.shoppingCart {
    margin-left: 100px;
    background-color: #999999;
}

.cart {
    vertical-align: middle;
    margin: 10px;
    background-color: #fff;
    line-height: 40px;
    height: 40px;
    text-align: center;
}

.icons {
    height: 40px;
    width: 20px;
    background: url(images/toolbars.png) no-repeat 0 10px;
    float: left;
    margin: 0 5px;
}

.cart a {
    display: block;
    float: left;
    text-decoration: none;
    color: red;
}

#cart_num {
    height: 15px;
    width: 15px;
    line-height: 12px;
    margin: 8px 5px;
    border-radius: 50%;
    background-color: red;
    float: left;
    color: black;
    font-size: 12px;
}

.login_register {
    float: right;
    width: 20%;
    margin-right: 40px;
    height: 60px;
    background-color: #90c31f;
}

.login_pic {
    width: 40px;
    height: 50px;
    margin: 5px 5px;
    float: left;
}

.login_pic img {
    height: 100%;
    border-radius: 23px;
}

.login_register p {
    margin: 8px 5px;
    padding-left: 55px;
    font: 14px Microsoft YaHei,tahoma;
}

.login_register a {
    display: inline-block;
    margin-right: 30px;
    text-decoration: none;
    color: #666;
}
  
  </style>
		
	</head>


		
		<body>

				<header>
					<div class="header_pic" style="width:114%;margin-left:-7%;background-color:#b7b1a0">
							<ul class="head-top">
							    <li><a href="${pageContext.servletContext.contextPath}/SellerLogin.jsp">我是商家</a></li>
							    <li></li>
							    <li></li>
							    <li></li> 
							</ul>
					
					</div>
					<div class="header_main">

							<div id="logo">
								<img src="images/logo.gif" />
							</div>

							<div class="search_text">
									<input type="text" id="search_main"></input>
							</div>

							<div id="search_text_right">
								
							</div>


					       <div class="shoppingCart">
								<div class="cart">
								<div class="icons"> </div>
									<a id="cart_a" href="${pageContext.servletContext.contextPath}/CartServlet?type=showAll"> 我的购物车</a>
									<div id="cart_num">0</div>
								</div>
							</div>


				<div class="login_register">
									<div class="login_pic">
										<img src="images/no_login.jpg" alt="no_login"/>
									</div>
									<p>欢迎来到明宇眼镜</p>

									<p><a href="login.jsp">登录</a> 
									<a href="SellerLogin.jsp">注册</a><p>
							</div>
					</div>
				</header>


 <div class="wide_bg">
     <div class="wide_page">
				<div class="wide_channel">
					<div class="wide_channel_category">
							全部商品分类

							<ul class="category_info" >
									<li class="list_item">
											<div class="icon"></div>
											 <h3 class="sub_category">透明隐形眼镜</h3>
											<div class="item_blank">&gt;&gt;</div>
                                            <div class="list_item_line"></div>



                                          
                                            <div class="child_list" >
                                            		<ul class="child_list_left">
                                            			<li class="child_list_dt">
                                            			<b>品牌&nbsp;&gt;</b></li>

										                <li class="child_list_dd">
										                    <span><a href="/boshilun.html" target="_blank">博士伦</a></span>
										                    <a href="/qiangsheng.html" target="_blank">强生</a>
										                    <a href="/shikang.html" target="_blank">视康爱尔康</a>
										                    <span><a href="/coopervision.html" target="_blank">库博</a></span>
										                    <a href="/haichang.html" target="_blank">海昌</a>
										                    <a href="/weikang.html" target="_blank">卫康</a>
										                    <a href="/miacare.html" target="_blank">美若康</a>
										                    <span><a href="/miru.html" target="_blank">Miru米如</a></span>
										                    <a href="/yishiming.html" target="_blank">依视明</a>
										                    <a href="/aokela.html" target="_blank">奥克拉</a>
										                    <a href="/freshkon.html" target="_blank">菲士康</a>
										                    <a href="/clearlab.html" target="_blank">科莱博</a>
										                    <a href="/hoelen.html" target="_blank">海俪恩</a>
										                    <a href="/zeiss.html" target="_blank">蔡司</a>
										                    <a href="/clalen.html" target="_blank">茵洛</a>
										                    <a href="/sap.html" target="_blank">SAP思汉普</a>
										                    <a href="/yinxingyanjing.html" target="_blank">更多品牌<b>&gt;&gt;</b></a>
										                </li>

										                  <li class="child_list_dt"><b>周期&gt;</b></li>
											                <li class="child_list_dd">
											                    <span><a href="/yinxingyanjing.html?wordId=5" target="_blank">日抛</a></span>
											                    <a href="/yinxingyanjing.html?wordId=3" target="_blank">双周抛</a>
											                    <a href="/yinxingyanjing.html?wordId=44" target="_blank">月抛</a>
											                    <a href="/yinxingyanjing.html?wordId=45" target="_blank">季抛</a>
											                    <span><a href="/yinxingyanjing.html?wordId=46" target="_blank">半年抛 </a></span>
											                    <a href="/yinxingyanjing.html?wordId=4" target="_blank">年抛</a>
											                </li>

											              <li class="child_list_dt"><b>含水量&gt;</b></li>
											                <li class="child_list_dd">
											                    <span><a href="/yinxingyanjing.html?wordId=47" target="_blank">43-69%</a></span>
											                    <a href="/yinxingyanjing.html?wordId=7" target="_blank">38-42%</a>
											                    <a href="/yinxingyanjing.html?wordId=6" target="_blank">≤37%</a>
											                </li>

                                            		</ul>





                                            		<ul class="child_list_right" >
                                            		      <li><img  width="100%" height="50%" src="images/ad_pic1.jpg" /></li>
                                            		      <li><img  width="100%" height="50%" src="images/ad_pic2.jpg" /></li>
                                            		</ul>

                                            </div>
									</li>



									 <li class="list_item">
							        <div  class="icon"></div>
							        <h3 class="sub_category"><a href="/meitong.html">彩色隐形眼镜</a></h3>

							        <div class="item_blank">&gt;&gt;</div>

							        <div class="list_item_line"></div>
							        <div class="child_list">
							            <ul class="child_list_left">
							                <li class="child_list_dt"><b>品牌&nbsp;&gt;</b></li>
							                <li class="child_list_dd">
							                    <span><a href="/boshilunmt.html" target="_blank">博士伦</a></span>
							                    <span><a href="/qiangshengmeitong.html" target="_blank">强生</a></span>
							                    <a href="/haichangmt.html" target="_blank">海昌</a>
							                    <span><a href="/shitongcaipian.html" target="_blank">实瞳</a></span>
							                    <span><a href="/nuosi.html" target="_blank">诺思</a></span>
							                    <a href="/latte.html" target="_blank">心の拉花</a>
							                    <a href="/cibavisionclrs.html" target="_blank">视康</a>
							                    <a href="/clb.html" target="_blank">科莱博</a>
							                    <a href="/hailiencaipian.html" target="_blank">海俪恩</a>
							                    <a href="/freshkonmt.html" target="_blank">菲士康</a>
							                    <a href="/annasui.html" target="_blank">安娜苏</a>
							                    <a href="/neo.html" target="_blank">NEO</a>
							                    <a href="/miacarec.html" target="_blank">美若康</a>
							                    <a href="/weikangmt.html" target="_blank">卫康</a>
							                    <a href="/interojo.html" target="_blank">茵洛</a>
							                    <a href="/zhuangmeitang.html" target="_blank">妆美堂</a>
							                    <a href="/sancai.html" target="_blank">散光彩瞳</a>
							                    <a href="/mtmore.html" target="_blank">更多<b>&gt;&gt;</b></a>
							                </li>
							                <li class="clear"></li>
							                <li class="child_list_dt">周期<b>&gt;</b></li>
							                <li class="child_list_dd">
							                    <span> <a href="/meitong.html?wordId=5" target="_blank">日抛</a></span>
							                    <span><a href="/meitong.html?wordId=3" target="_blank">双周抛</a></span>
							                    <a href="/meitong.html?wordId=44" target="_blank">月抛</a>
							                    <a href="/meitong.html?wordId=46" target="_blank">半年抛</a>
							                    <a href="/meitong.html?wordId=4" target="_blank">年抛</a>
							                </li>
							                <li class="clear"></li>
							                <li class="child_list_dt">色系<b>&gt;</b></li>
							                <li class="child_list_dd">
							                    <a href="/meitong.html?wordId=68" target="_blank">黑色</a>
							                    <span> <a href="/meitong.html?wordId=72" target="_blank">棕色</a></span>
							                    <a href="/meitong.html?wordId=69" target="_blank">灰色</a>
							                    <a href="/meitong.html?wordId=70" target="_blank">蓝色</a>
							                    <a href="/meitong.html?wordId=71" target="_blank">紫色</a>
							                    <a href="/meitong.html?wordId=73" target="_blank">粉色</a>
							                    <a href="/meitong.html?wordId=2" target="_blank">绿色</a>
							                </li>
							                <li class="clear"></li>
							                <li class="child_list_dt">直径<b>&gt;</b></li>
							                <li class="child_list_dd">
							                    <a href="/meitong.html?wordId=49" target="_blank">≤13.5mm</a>
							                    <a href="/meitong.html?wordId=50" target="_blank">13.6mm-14.00mm</a>
							                    <span> <a href="/meitong.html?wordId=51" target="_blank">≥14.1mm</a></span>
							                </li>
							                <li class="clear"></li>
							                <li class="child_list_dt">价格<b>&gt;</b></li>
							                <li class="child_list_dd">
							                    <a href="/meitong.html?wordId=304" target="_blank">&lt;100元</a>
							                    <a href="/meitong.html?wordId=305" target="_blank">100-199元</a>
							                    <span> <a href="/meitong.html?wordId=306" target="_blank">200-299元</a></span>
							                </li>
							                <li class="clear"></li>
							                <li class="child_list_dt">热门<b>&gt;</b></li>
							                <li class="child_list_dd">
							                    <span><a href="/ziran.html" target="_blank">自然甜美</a></span>
							                    <span> <a href="/dazhijing.html" target="_blank">大直径</a></span>
							                    <a href="/gexing.html" target="_blank">个性混血</a>
							                    <span> <a href="/zengda.html" target="_blank">小圆环(增大增亮)</a></span>
							                    <a href="/leisi.html" target="_blank">蕾丝花纹</a>
							                    <span> <a href="/boy.html" target="_blank">男生美瞳</a></span>
							                </li>
							                <li class="clear"></li>
							            </ul>
							            <ul class="child_list_right">
							                <li class="child_list_imgup"><a href="/nsaaa17.html" target="_blank"><img alt="" src="http://pic.keede.com/Images/index_scb/20160728/cp_a1.jpg"></a></li>
							                <li class="child_list_imgdown"><a href="http://www.keede.com/miacarec.html" target="_blank"><img alt="" src="http://pic.keede.com/Images/index_scb/20161109/cp_a2g2.jpg"></a></li>
							            </ul>
							        </div>
							    </li>



							</ul>




                                 
					</div><!--wide_channel_category 结束 -->


						

























					<div class="wide_channel_other">

					  <ul class="other_links">
					  			<li><a>首页</a></li>
					  			<li><a>彩瞳</a></li>
					  			<li><a>框架眼镜</a></li>
					  			<li><a>美妆个护</a></li>
					  			<li><a>时尚</a></li>
					  			<div class="clear" />
					  </ul>


					</div>

				</div><!--wide_channel 结束-->
	</div><!--wide_page 结束 -->


				 <div class="containe" >

						<div class="list" style="left:0">
							 <img src="images/ad1.jpg"  alt=""/>
							 <img src="images/ad2.jpg"  alt=""/>
							 <img src="images/ad3.jpg"  alt=""/>
							 <img src="images/ad4.jpg"  alt=""/>
							 <img src="images/ad5.jpg"  alt=""/>
				   			
				   	    </div>

				   	    <div class="buttons">
				   	    		<span class="focus_button" index="1" clicking=""></span>
				   	    		<span class="focus_button" index="2" clicking=""></span>
				   	    		<span class="focus_button" index="3" clicking=""></span>
				   	    		<span class="focus_button" index="4" clicking=""></span>
				   	    		<span class="focus_button" index="5" clicking=""></span>
				   	    </div>

				   	    <a href=""  id="prev" class="arro">&lt;</a>
				   	    <a href="" id="next" class="arro"> &gt;</a>
				</div><!-- container 焦点图结束 -->

			
						<div id="new_comer">
						       <img src="images/new_come.jpg" />
						</div>

	</div><!-- wide_bg 结束-->

						








			<!--	<div class="mycontent">
					<div class="content_top">
								 <div class="usual_search">
								 热门筛选
								 </div>

								 <div class="rub_discount">
								 		抢优惠券
								 </div>

								 <div  class="ad_picture">
                                           <img alt="img1" />
								 </div>

								 <div class="ad_picture">
								 			<img alt="img2"/>
								 </div>



								 <div class="on_sale_and_dynamic">
											促销 动态
								</div>
					</div>


					<div class="content_floor">
					</div>
				</div>  -->
				
<script type="text/javascript" src="index.js"></script>
<%--  这里决定显示商品    --%>

<div class="container" style="width:88%;margin:0 auto; padding:0;" >
			<div class="content">
				<div class="content-top">
					<h3 class="future">最新最热</h3>
					<div class="content-top-in">
					
					  <c:forEach var="goods" items="${requestScope.newFour}">
						<div class="col-md-3 md-col">
							<div class="col-md">
								<a href="${pageContext.servletContext.contextPath}/CustomerGoodsServlet?goods_id=${goods.goods_id}"><img  src="${my:mapToServer(goods.picURI)}" height="50" alt="" /></a>	
								<div class="top-content">
									<h5><a href="${pageContext.servletContext.contextPath}/CustomerGoodsServlet?goods_id=${goods.goods_id}">${goods.name}</a></h5>
									<div class="white">
										<a href="${pageContext.servletContext.contextPath}/CustomerGoodsServlet?goods_id=${goods.goods_id}" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2 ">加入购物车</a>
										<p class="dollar"><span class="in-dollar">￥</span><span>${goods.price}</span></p>
										<div class="clearfix"></div>
									</div>

								</div>							
							</div>
						</div>
					
					</c:forEach>
					<div class="clearfix"></div>
					</div>
				</div>
				<!---->
				<div class="content-middle">
					<h3 class="future">知名品牌</h3>
					<div class="content-middle-in">
					<ul id="flexiselDemo1">		
					 
					   		<li><img src="images/rayBan.jpg"/></li>
					   		<li><img src="images/BoLon.jpg"/></li>
					   		<li><img src="images/prosun.jpg"/></li>
					   		<li><img src="images/parim.jpg"/></li>
					   		<li><img src="images/oakley.jpg"/></li>
					   		<li><img src="images/molsion.jpg"/></li>
					   		<li><img src="images/prsr.jpg"/></li>
					   	
					</ul>
            		<script >
		$(window).on("load",function() {
			$("#flexiselDemo1").flexisel({
				visibleItems: 4,
				animationSpeed: 1000,
				autoPlay: true,
				autoPlaySpeed: 4000,    		
				pauseOnHover: true,
				enableResponsiveBreakpoints: true,
		    	responsiveBreakpoints: { 
		    		portrait: { 
		    			changePoint:480,
		    			visibleItems: 1
		    		}, 
		    		landscape: { 
		    			changePoint:640,
		    			visibleItems: 2
		    		},
		    		tablet: { 
		    			changePoint:768,
		    			visibleItems: 3
		    		}
		    	}
		    });
		    
		});
	</script>
	

					</div>
				</div>
				<!---->
				<div class="content-bottom">
					<h3 class="future">优质促销</h3>
					<div class="content-bottom-in">
					<ul id="flexiselDemo2">			

                       	<c:forEach var="goods" items="${requestScope.page.list}">
						
						<li><div class="col-md men">
								<a href="${pageContext.servletContext.contextPath}/CustomerGoodsServlet?goods_id=${goods.goods_id}" class="compare-in "><img  src="${my:mapToServer(goods.picURI)}" height="202" alt="" />
									<div class="compare in-compare">
									<span>宝贝比较</span>
									<span>加入收藏</span>
								   </div>					
								</a>
								<div class="top-content bag">
									<h5><a href="${pageContext.servletContext.contextPath}/CustomerGoodsServlet?goods_id=${goods.goods_id}">${goods.name}</a></h5>
									<div class="white">
										<a href="${pageContext.servletContext.contextPath}/CustomerGoodsServlet?goods_id=${goods.goods_id}" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">加入购物车</a>
										<p class="dollar"><span class="in-dollar">￥</span><span>${goods.price}</span></p>
										<div class="clearfix"></div>
									</div>
								</div>		
								
							</div>
							</li>
						</c:forEach>
					
					</ul>
					<script>
		$(window).on("load",function() {
			$("#flexiselDemo2").flexisel({
				visibleItems: 4,
				animationSpeed: 1000,
				autoPlay: true,
				autoPlaySpeed: 6000000000,    		
				pauseOnHover: true,
				enableResponsiveBreakpoints: true,
		    	responsiveBreakpoints: { 
		    		portrait: { 
		    			changePoint:480,
		    			visibleItems: 1
		    		}, 
		    		landscape: { 
		    			changePoint:640,
		    			visibleItems: 2
		    		},
		    		tablet: { 
		    			changePoint:768,
		    			visibleItems: 3
		    		}
		    	}
		    });
		    
		});
	</script>
					</div><!-- content-bottom-in -->
				</div><!-- content-bottom -->
			</div><!-- content -->
		</div>	<!-- container -->
				
	 
		 
		
			
		
			
		   
		 
	
				<p id="test">
				共有商品${requestScope.page.totalRecords}件，
				共有商品${requestScope.page.totalPage}页，
				当前是第${requestScope.page.currentPage}页，
				
				每页显示商品${requestScope.page.pageSize}件，
				前一页是${requestScope.page.previous}页，
				后一页是${requestScope.page.next}页，
			
				</p>

 
       <ul class="page" id="page">
            <c:if test="${requestScope.page.currentPage!=1}">
		         <li ><a href="${pageContext.servletContext.contextPath}/CustomerGoodsServlet?cur=${requestScope.page.previous}&pSize=4"><i></i></a></li>
		   </c:if>	 
       
           <c:forEach var="h" items="${requestScope.page.pageBar}">
				  <c:if test="${h==requestScope.page.currentPage}">
		         <li> <span> ${h}</span></li>
		         </c:if>
		         <c:if test="${h!=requestScope.page.currentPage}">
		         	<li class="arrow"><a href="${pageContext.servletContext.contextPath}/CustomerGoodsServlet?cur=${h}&pSize=4">${h}</a></li>
		         </c:if>
			</c:forEach>
			
			<c:if test="${requestScope.page.currentPage!=requestScope.page.totalPage}">
		         <li ><a href="${pageContext.servletContext.contextPath}/CustomerGoodsServlet?cur=${requestScope.page.next}&pSize=4"><i  class="next"> </i></a></li>
		         
		   </c:if>
		    <li>共${requestScope.page.totalPage}页</li>
	  </ul>
			
		









<script>
 $("#test").hide();
 
 $(function(){
	 var auto="${requestScope.auto}";
	 
	 //非自动，跳到底部
	 if(auto==""){
		 
		 $(document.body).animate({
			 scrollTop:640
		 },1000);
	 }
 });  
 
 

 

 
</script>




<%--  显示商品结束    --%>

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
									Copyright &nbsp;&copyright; &nbsp;2004-2017 &nbsp; 明宇MY.com &nbsp;版权所有
								</div>

						</div>

					


				</footer>


				


				
</body>
</html>