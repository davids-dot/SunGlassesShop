<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/my" prefix="my" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>订单列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css"  href="${pageContext.servletContext.contextPath}/css/order/list.css" />
	
  </head>
  
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

<c:forEach items="${sessionScope.orders}" var="order">

		<tr class="tt">
			<td width="320px">订单号：<a  href="<c:url value='/OrderServlet?method=load&oid=${order.order_id}'/>">${order.order_id }</a></td>
			<td width="200px">下单时间：${order.order_id}</td>
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
	<c:when test="${order.status eq 1 }">(等待付款)</c:when>
	<c:when test="${order.status eq 2 }">(准备发货)</c:when>
	<c:when test="${order.status eq 3 }">(等待确认)</c:when>
	<c:when test="${order.status eq 4 }">(交易成功)</c:when>
	<c:when test="${order.status eq 5 }">(已取消)</c:when>
</c:choose>			

			</td>
			<td>
			<a href="<c:url value='/OrderServlet?method=load&oid=${order.order_id }'/>">查看</a><br/>
<c:if test="${order.status eq 1 }">
				<a href="<c:url value='/OrderServlet?method=paymentPre&oid=${order.order_id }'/>">支付</a><br/>
				<a href="<c:url value='/OrderServlet?method=load&oid=${order.order_id }&btn=cancel'/>">取消</a><br/>						
</c:if>
<c:if test="${order.status eq 3 }">
				<a href="<c:url value='/OrderServlet?method=load&oid=${order.order_id  }&btn=confirm'/>">确认收货</a><br/>
</c:if>
			</td>
		</tr>
</c:forEach>



	</table>
	<br/>
</div>
  </body>
</html>
