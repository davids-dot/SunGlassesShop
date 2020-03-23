<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="now" class ="java.util.Date" ></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品排行列表</title>

<link href="${pageContext.servletContext.contextPath}/css/bootstrap.css?${now.time}" type="text/css" rel="stylesheet"></link>
<style>
 
 .table{
  width:85%;
   margin:20px auto;
 }
 
 

</style>
</head>



<body>

   <table class="table table-striped table-condensed table-hover">
     <tr class="success">
      <th>排行</th>
      <th>商铺名</th>
      <th>商家名</th>
      <th>周交易额</th>
      <th>操作</th>
     </tr>
     
     <c:forEach var ="shop" items="${requestScope.page.list}">
       <tr>
         <td>${requestScope.queryInfo.startIndex+1}</td>
          <td>${shop.name}</td>
           <td>${shop.seller.name}</td>
            <td>${shop.week_amount}</td>
            <td><a href="#">查看周交易趋势</a></td>
       </tr>
     
     </c:forEach>
   
   </table>

</body>
</html>