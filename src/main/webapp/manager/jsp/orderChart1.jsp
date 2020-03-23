<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单折线图</title>
	<script src="${pageContext.servletContext.contextPath}/js/highcharts.js" type="text/javascript"></script>
</head>
<body>

  <div id="container" style="min-width:800px;height:400px" ></div>



<script>

var data = new Array();
var category =new Array();

<c:forEach var="dayAmount" items="${requestScope.list}">
 category.push("${dayAmount.date}");
 data.push(parseFloat("${dayAmount.transaction_amount}"));
</c:forEach>

 var chart = new Highcharts.chart('container',{
	 
	 chart:{
		 type:'line'
	 },
	 
	 title:{
		 text:'交易额统计图'
	 },
	 
	 xAxis:{
		 categories:category
	 },
	 
	 yAxis:{
		 title:{
			 text:'交易总额'
		 }
	 },
	 
	 series:[
	         {name:'交易额',data:data}
	        ]
	 
 });


</script>
</body>
</html>