<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML>
<html>
  <head>
    <title>ordersucc.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/order/ordersucc.css">
  </head>
  
  <body>
<div class="div1">
	<span class="span1">订单已生成</span>
</div>
<div class="div2">
	<img src="${pageContext.servletContext.contextPath}/images/duihao.jpg" class="img"/>
	<dl>
		<dt>订单编号</dt>
		<dd>${order.order_id}</dd>
		<dt>合计金额</dt>
		<dd><span class="price_t">&yen;${order.totalPrice }</span></dd>
		<dt>收货地址</dt>
		<dd>${sessionScope.user.address}</dd>
	</dl>
	<span>明宇网上商城感谢您的支持，祝您购物愉快！</span>
	<a href="<c:url value='/OrderServlet?method=paymentPre&oid=${order.order_id}'/>" id="linkPay">支付</a>
</div>
  </body>
</html>
