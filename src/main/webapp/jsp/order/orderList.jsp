<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/my" prefix="my" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>顾客订单列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@ include file="../head.jsp" %>
	<link rel="stylesheet" type="text/css"  href="${pageContext.servletContext.contextPath}/jsp/order/list.css?${now.time}" />
	
  </head>
  
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

#messageBox{
position:fixed;width:400px;height:400px;background:#fff;z-index: 1001;
border:1px solid gray;
padding:20px;
left: 474.5px;
top: 156.5px;

}

.close{
  display:inline-block;
  margin-right:5px;
}

#messageBox h4{
  color:green;
}

#messageBox p{
  margin:5px 0px;
  text-indent:2em;
}
  
  </style>
  
  <body>
<div class="divMain">
	<div class="divTitle">
		<span style="margin-left: 150px;margin-right: 280px;">商品信息</span>
		<span style="margin-left: 40px;margin-right: 38px;">金额</span>
		<span style="margin-left: 50px;margin-right: 40px;">订单状态</span>
		<span style="margin-left: 50px;margin-right: 50px;">操作</span>
	</div>
	<br/>
	<table align="center" border="0" width="100%" cellpadding="0" cellspacing="0">

<c:forEach items="${requestScope.page.list}" var="order">

		<tr class="tt">
			<td width="320px">订单号：<a  href="<c:url value='/OrderServlet?method=load&oid=${order.order_id}'/>">${order.order_id }</a></td>
			<td width="200px">下单时间：${my:realDate(order.order_id)}</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr style="padding-top: 10px; padding-bottom: 10px;">
			<td colspan="2">


  <c:forEach items="${order.items}" var="od">
	<a class="link2" href="<c:url value='/BookServlet?method=load&bid=${od.goods.goods_id }'/>">
	    <img border="0" width="70" src="${my:mapToServer(od.goods.picURI)}"/>
	</a>
  </c:forEach>
	



			</td>
			<td width="115px">
				<span class="price_t">&yen;${order.totalPrice }</span>
			</td>
			<td width="142px">
<c:choose>
	<c:when test="${order.status eq 0 }">(等待付款)</c:when>
	<c:when test="${order.status eq 1 }">(准备发货)</c:when>
	<c:when test="${order.status eq 2 }">(已发货)</c:when>
	<c:when test="${order.status eq 3 ||order.status eq 4}">(已确认收货)</c:when>
	<c:when test="${order.status eq 5 }">(已删除)</c:when>
</c:choose>			

			</td>
			<td>
			<a href="<c:url value='/OrderServlet?method=load&oid=${order.order_id }'/>">查看</a><br/>
<c:if test="${order.status eq 0 }">
				<a href="javascript:pay(${order.order_id })">支付</a><br/>
				<a href="javascript:cancel(${order.order_id })">取消</a><br/>						
</c:if>
<c:if test="${order.status eq 2 }">
				<a id="confirmReceipt${order.order_id}" href="javascript:confirmReceipt(${order.order_id  });">确认收货</a><br/>
</c:if>
<c:if test="${order.status eq 3||order.status eq 4 }">
				<a id="evaluate${order.order_id}" href="javascript:evaluate(${order.order_id  });">交易评价</a><br/>
</c:if>
			</td>
		</tr>
</c:forEach>

	</table>
	<br/>
					<p id="test">
			
					<c:set var="page" value="${requestScope.page}"></c:set>
				共有商品${page.totalRecords}件，
				共有商品${page.totalPage}页，
				当前是第${page.currentPage}页，
				
				每页显示商品${page.pageSize}件，
				前一页是${page.previous}页，
				后一页是${page.next}页，
			
				</p>

 
       <ul class="page" id="page">
            <c:if test="${page.currentPage!=1}">
		         <li ><a href="javascript:void(0);"  onclick="forPage(${page.previous})"  ><i></i></a></li>
		   </c:if>	 
       
           <c:forEach var="h" items="${page.pageBar}">
				  <c:if test="${h==page.currentPage}">
		         <li> <span> ${h}</span></li>
		         </c:if>
		         <c:if test="${h!=page.currentPage}">
		         	<li class="arrow"><a href="javascript:void(0);"  onclick="forPage(${h})">${h}</a></li>
		         </c:if>
			</c:forEach>
			
			<c:if test="${page.currentPage!=requestScope.page.totalPage}">
		         <li ><a href="javascript:void(0);"  onclick="forPage(${requestScope.page.next})"><i  class="next"> </i></a></li>
		         
		   </c:if>
		    <li>共${page.totalPage}页</li><!--  手动跳页 -->
		    <li>到<input type="number" id="toPage" value="${page.currentPage}"  min="1" max="${page.totalPage}" style="width:30px;"/>页<li>
		    <li><input type="button"  value="确定" onclick="toPage()"/></li><!--  手动跳页 -->
	  </ul>
	  
<script>

var pageWidth =document.documentElement.scrollWidth;
var pageHeight =document.documentElement.scrollHeight;
var clientHeight = document.documentElement.clientHeight;

function pay(id){
	myPost('${pageContext.servletContext.contextPath}/BussinessServlet',{type:'pay',order_id:id});
}

var temp = document.getElementById("test");
  temp.parentNode.removeChild(temp);

function toPage(){
	
	var cur =document.getElementById("toPage").value;
	forPage(cur);
}
//默认大小
function forPage(curr){
	
	myPost('${pageContext.servletContext.contextPath}/BussinessServlet',{type:'showSome',cur:curr,pSize:3});
}
//指定大小
function forPageWithSize(curr,ppsize){
	myPost('${pageContext.servletContext.contextPath}/BussinessServlet',{type:'showSome',cur:curr,pSize:ppsize});
}




  function   myPost(URL,Params){

	  var temp = document.createElement("form");
	      temp.action =URL;
	      temp.method="post";
	      temp.style.display ="none";
	  
	     for(var param in Params){
			var opt =document.createElement("textarea");
			opt.name = param;
			opt.value  =Params[param];
			temp.appendChild(opt);
	     }
	     document.body.appendChild(temp);
	     temp.submit();
	     return ;
	}
  		   
  function hideMessageBox(){
	  document.getElementById("messageBox").style.display="none";
  }
  
  function confirmReceipt(order_id){
	  
		$.ajax({
			async:true,
			cache:false,
			url:"/SunGlassesShop/BussinessServlet",
			data:{type:"confirmReceipt",orderId:order_id},
			type:"POST",
			dataType:"text",
			success:function(answer) {

		
				/*显示确认订单消息*/
				var messageBox = document.getElementById("messageBox");
				messageBox.innerHTML="<h4>信息提示<span class='close' onclick='hideMessageBox()'>x</span></h4><p>已成功确认收货。</p>";
				messageBox.style.display="block";
				/*删除确认订单按钮*/
				var conlink = document.getElementById("confirmReceipt"+order_id);
				conlink.parentNode.removeChild(conlink);
				
			},
			error:function(xhr){
				console.log(xhr);
				
			}
		});
	  
}
  
  $(function(){
	  document.getElementById("messageBox").style.display="none";
  });

 </script>
	
</div>
	<div id="messageBox" >woooooo</div>
  </body>
</html>
