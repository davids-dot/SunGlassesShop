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
<title>用户信息管理</title>

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
td a:link,td a:visited{
  color:blue;
}



  </style>
  <!-- 
<script type="text/javascript">
	$(function() {
		
		var userMangeList = "${userMangeList}";
		if (userMangeList == null || userMangeList == "" || userMangeList == undefined) {
			$("#nextPage").val("0");
			$("#userManageForm").submit();
		
		} 
	});
</script>
   -->
</head>

<body>
     
 <div class="container">
   <table class="table table-bordered">
     <tr>
     	<th>用户编号</th>
        <th>用户ID</th>
        <th>用户密码</th>
        <th>联系方式</th>
        <th>用户类型</th>
        <th>用户状态</th>
        <c:if test="${param.query!='new'&&param.query!='delivered'}"><th>操作</th></c:if>
     </tr>
     
     <c:forEach items="${userMangeList}" var="manage" varStatus="idx">
       <tr id="order${manage.user_id}">
            <td>${manage.user_id}</td>
       		<td>${manage.name}</td>
       		<td>${manage.password}</td>
       		<td>${manage.telephone}</td>
       		<c:choose>
       		<c:when test="${manage.type eq 'Customer'}">
       		<td>顾客</td>
       		</c:when>
       		<c:when test="${manage.type eq 'Seller'}">
       		<c:url value="/CommodityManageSevlet" var="sellerdetail">
					<c:param name="userid" value="${manage.name}"></c:param>
					<c:param name="page.nextPage" value="0"></c:param>
			</c:url>
       		<td>商家&nbsp;<a href="${sellerdetail}">查看详情</a></td>
       		</c:when>
       		</c:choose>
       		
       		
       		<c:choose>
       		<c:when test="${manage.isDele eq 0}">
       		<td>活跃</td>
       		<c:url value="/UserManageServlet"
										var="detail">
					<c:param name="option" value="delete"></c:param>
					<c:param name="userid" value="${manage.name}"></c:param>
					<c:param name="usertype" value="${manage.type}"></c:param>
			</c:url>
       		<td><a href="${detail}">冻结</a></td>
       		</c:when>
       		<c:when test="${manage.isDele eq 1}">
       		<td>冻结</td>
       		<c:url value="/UserManageServlet"
										var="detail">
					<c:param name="option" value="active"></c:param>
					<c:param name="userid" value="${manage.name}"></c:param>
					<c:param name="usertype" value="${manage.type}"></c:param>
			</c:url>
       		<td><a href="${detail}">激活</a></td>
       		</c:when>
       		</c:choose>

       </tr>
     </c:forEach>
   
   </table> 
 
								<!-- 使用这个表单中的隐藏input来保存和提交数据 -->
		<form action="${pageContext.request.contextPath }/UserManageServlet"
			method="post" name="userManageForm" id="userManageForm">
		<input type="hidden" name="page.nextPage"
				value="${page.nextPage}" id="nextPage" />
		</form>
		<div id="end">
			<input type="button" value="首页" onclick="tzPage('0')" /> <input
				type="button" value="上一页" onclick="tzPage('-1')" /> <input
				type="button" value="下一页" onclick="tzPage('1')" /> <input
				type="button" value="末页" onclick="tzPage('2')" />
		</div>
	
  </div><!-- container结束 -->
	</body>

</html>