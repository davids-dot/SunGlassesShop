<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/my" prefix="my" %>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.servletContext.contextPath}/css/bootstrap.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery-3.1.1.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商家管理页面中订单列表</title>

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
</head>
<body>

		  <c:if test="${param.query=='new'}"><h1 style="color:#0000ff;text-align:center;" >新订单</h1></c:if>
          <c:if test="${param.query=='paid'}"><h1 style="color:#0000ff;text-align:center;" >已付款订单</h1></c:if>
          <c:if test="${param.query=='delivered'}"><h1 style="color:#0000ff;text-align:center;" >已发货订单</h1></c:if>          
          <c:if test="${param.query=='confirmed'}"><h1 style="color:#0000ff;text-align:center;" >已收货订单</h1></c:if>
          
 <div class="container" style="margin-top:30px;">
   <table class="table table-bordered">
     <tr>
     	<th>订单号</th>
        <th>顾客</th>
        <th>商品数量</th>
        <th>商品详细</th>
        <th>金额</th>
        <c:if test="${param.query!='new'&&param.query!='delivered'}"><th>操作</th></c:if>
     </tr>
     
     <c:forEach var="order" items="${requestScope.page.list}">
       <tr id="order${order.order_id}">
       		<td>${order.order_id}</td>
       		<td>${order.customerName}</td>
       		<td>${fn:length(order.items)}</td>
       		<td><a href="javascript:showDetail(${order.order_id});">详情</a></td>
       		<td>${order.totalPrice}</td>
       		<c:if test="${param.query=='paid'}"><td><a href="javascript:deliver(${order.order_id});">发货</a></td></c:if>
       		<c:if test="${param.query=='confirmed'}"><td><a href="javascript:deleteOrder(${order.order_id});">删除</a></td></c:if>
       </tr>
     </c:forEach>
   
   </table> 
 
 
 
 
 
  <script>
function toPage(){
	
	var cur =document.getElementById("toPage").value;
	forPage(cur);
}
//默认大小
function forPage(curr){
	
	myPost('${pageContext.servletContext.contextPath}/GoodsManageServlet',{type:'order',query:"${param.query}",cur:curr});
}
//指定大小
function forPageWithSize(curr,ppsize){
	myPost('${pageContext.servletContext.contextPath}/GoodsManageServlet',{type:'order',cur:curr,pSize:ppsize});
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
 </script>
  
			
				<c:set var="page" value="${requestScope.page}"></c:set>
				<p id="test">共有商品${page.totalRecords}件，
				共有商品${page.totalPage}页，
				当前是第${page.currentPage}页，
				
				每页显示商品${page.pageSize}件，
				前一页是${page.previous}页，
				后一页是${page.next}页，
				
				${param.query }</p>

 
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
			
			<c:if test="${page.currentPage!=requestScope.page.totalPage&&requestScope.page.totalPage!=0}">
		         <li ><a href="javascript:void(0);"  onclick="forPage(${requestScope.page.next})"><i  class="next"> </i></a></li>
		         
		   </c:if>
		    <li>共${page.totalPage}页</li><!--  手动跳页 -->
		 
		    <li>到<input type="number" id="toPage" value="${page.currentPage>page.totalPage?page.totalPage:page.currentPage}"  min="${page.totalPage==0?0:1}" max="${page.totalPage}" style="width:30px;"/>页<li>
		    <li><input type="button"  value="确定" onclick="toPage()"/></li><!--  手动跳页 -->
	  </ul>
	  <!-- GoodsManageServlet?type=order&query=new" -->
</div>
<script>
var temp = document.getElementById("test");
temp.parentNode.removeChild(temp);

  function deliver(order_id){
	  
		$.ajax({
			async:true,
			cache:false,
			url:"/SunGlassesShop/GoodsManageServlet",
			data:{type:"deliver",orderId:order_id},
			type:"POST",
			dataType:"text",
			success:function(answer) {
 
 				window.location.href="/SunGlassesShop/GoodsManageServlet?type=order&query=delivered";
			},
			error:function(xhr){
				console.log(xhr);
				
			}
		});
	  
  }
  
  
  function deleteOrder(order_id){
	  var del = window.confirm("您确认删除该订单记录吗？");
	 if(del == false ) return ;
	  $.ajax({
			async:true,
			cache:false,
			url:"/SunGlassesShop/GoodsManageServlet",
			data:{type:"delete",orderId:order_id},
			type:"POST",
			dataType:"text",
			success:function(answer) {
                var temp =document.getElementById("order"+order_id);
                temp.parentNode.removeChild(temp);
			},
			error:function(xhr){
				console.log(xhr);
				
			}
		});
	  
 }
  
  function showDetail(order_id){
	  window.location.href="${pageContext.servletContext.contextPath}/GoodsManageServlet?type=showDetail&orderId="+order_id;
	  
  }

</script>

  <!-- container 结束 -->
</body>
</html>