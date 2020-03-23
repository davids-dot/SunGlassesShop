<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/my" prefix="my" %>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.servletContext.contextPath}/css/bootstrap.css" type="text/css" rel="stylesheet" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

  <style>
  th{
  background-color:#a7ce87;
  }
  
  .table td{
      padding:3px 7px 2px 7px;
  }
  
  .table > tbody > tr > td{
  line-height:50px;
  }
  
ul.page {
	padding: 1em 0 1em 1em;
	
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
  
  </style>
</head>
<body>




 <div class="container" style="margin-top:30px;">
   <table class="table table-bordered">
     <tr>
     	<th>Id</th>
        <th>名称</th>
        <th>条形码</th>
        <th>生产厂家</th>
        <th>品牌</th>
        <th>生产日期</th>
        <th>产品图片</th>
        <th>价格</th>
        <th>操作</th>
     </tr>
     
     <c:forEach var="goods" items="${requestScope.page.list}">
       <tr>
       		<td>${goods.goods_id}</td>
       		<td>${goods.name}</td>
       		<td>${goods.barCode}</td>
       		<td>${goods.manufacturer}</td>
       		<td>${goods.brand}</td>
       		<td>${goods.productionDate}</td>
       		<td><img src="${my:mapToServer(goods.picURI)}" height="50" width="80" alt="商品图片"/></td>
       		<td>${goods.price}</td>
       		<td>
       		   <a href="">编辑</a>
       		</td>
       </tr>
     </c:forEach>
   
   </table> 
   
   
   			
   			
			 
			 
			 
			
		
			
			
			
				<p>
				共有商品${requestScope.page.totalRecords}件，
				共有商品${requestScope.page.totalPage}页，
				当前是第${requestScope.page.currentPage}页，
				
				每页显示商品${requestScope.page.pageSize}件，
				前一页是${requestScope.page.previous}页，
				后一页是${requestScope.page.next}页，
				目前可见页面范围${requestScope.page.pageBar[0]}
				</p>
				
	<!--  真他妈操蛋，foreach 一直不显示，删完，改样式名称才显示 -->
		 <ul class="page">
		   <c:if test="${requestScope.page.currentPage!=1}">
		         <li ><a href="${pageContext.servletContext.contextPath}/GoodsManageServlet?type=queryGoods&cur=${requestScope.page.previous}"><i></i></a></li>
		   </c:if>
		 
			<c:forEach var="h" items="${requestScope.page.pageBar}">
				  <c:if test="${h==requestScope.page.currentPage}">
		         <li> <span> ${h}</span></li>
		         </c:if>
		         <c:if test="${h!=requestScope.page.currentPage}">
		         	<li class="arrow"><a href="${pageContext.servletContext.contextPath}/GoodsManageServlet?type=queryGoods&cur=${h}">${h}</a></li>
		         </c:if>
			</c:forEach>
			
			 
			
			 <c:if test="${requestScope.page.currentPage!=requestScope.page.totalPage}">
		         <li ><a href="${pageContext.servletContext.contextPath}/GoodsManageServlet?type=queryGoods&cur=${requestScope.page.next}"><i  class="next"> </i></a></li>
		   </c:if>
		   
		   <li>共${requestScope.page.totalPage}页</li>
		</ul>
   			
   				
   				
</div>  <!-- container 结束 -->
</body>
</html>