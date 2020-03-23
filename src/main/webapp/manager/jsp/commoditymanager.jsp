<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/my" prefix="my" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/js/head.jsp"%>
<link href="${pageContext.servletContext.contextPath}/css/bootstrap.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery-3.1.1.js"></script>
<script src="<%=path%>/manager/js/myjs.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品管理</title>

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
  

container{
 width:85%;
 margin:20px auto;
}
  
td a{
  text-decoration:underline;
}

td a:active,td a:hover{
  color:red;
}
td a:link{
  color:blue;
}
td a:visited{
  color:grey;
}
  </style>
<script type="text/javascript">
	$(function() {
		var commodityManageList = "${commodityManageList}";
	
		if (commodityManageList == null || commodityManageList == "" || commodityManageList == undefined) {
			$("#nextPage").val("0");
			$("#userManageForm").submit();
		} 
	});
</script>
</head>

<body>
	
<c:choose>
 <c:when test="${empty requestScope.commodityManageList}">
   <h1>该商家商铺内空空如也</h1>
 </c:when>
 
 <c:otherwise>
    <div class="container" >
   <table class="table table-bordered">
     <tr>
     	<th>商品ID</th>
     	<th>商品图片</th>
        <th>商品名</th>
        <th>地区</th>
        <th>品牌</th>
        <th>商品价格</th>
        
        <c:if test="${param.query!='new'&&param.query!='delivered'}"><th>操作</th></c:if>
     </tr>
     
     <c:forEach items="${commodityManageList}" var="manage" varStatus="idx">
       <tr id="order${manage.goods_id}">
            <td>${manage.goods_id}</td>
            <td>${manage.name}</td>
       		<td><img height="50" width="50" alt="" src="${my:mapToServer(manage.picURI)}"></td>
       		<td>${manage.area}</td>
       		<td>${manage.brand}</td>
       		<td>${manage.price}</td>
       		<c:url value="/CommodityManageSevlet" var="commodityop">
       		        <c:param name="option" value="delete"></c:param>
					<c:param name="goodId" value="${manage.goods_id}"></c:param>
			</c:url>
       		<td><a href="${commodityop}">下架</a></td>


       </tr>
     </c:forEach>
   
   </table> 
 
								<!-- 使用这个表单中的隐藏input来保存和提交数据 -->
			<form action="${pageContext.request.contextPath }/CommodityManageSevlet"
				method="post" name="userManageForm" id="userManageForm">
			<input type="hidden" name="page.nextPage"
					value="${page.nextPage}" id="nextPage" />
			<input type="hidden" name="userid"
					value="${userid}" id="userid" />
			</form>
			<div id="end">
				<input type="button" value="首页" onclick="tzPage('0')" /> <input
					type="button" value="上一页" onclick="tzPage('-1')" /> <input
					type="button" value="下一页" onclick="tzPage('1')" /> <input
					type="button" value="末页" onclick="tzPage('2')" />
			</div>
	</div><!-- container 结束 -->
	</c:otherwise>
</c:choose>
	</body>

</html>