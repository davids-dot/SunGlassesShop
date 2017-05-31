<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/my" prefix="my" %>
<jsp:useBean id="now1" class="java.util.Date" ></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>顾客商品展示</title>

<style>
*{
   margin:0;
   padding:0;
}
#goodsList{
 
  margin:0 auto;
  overflow:hidden;
}


.goods {
  border:1px solid #ededed;
  padding:1px 5px 1px 5px;
  float:left;
  width:220px;
}

.goods:hover{
  border:1px solid red;
}

.goods .box-img{
   padding:5px;
   border:1px solid #cccccc;
   box-shadow:0 0 5px #ccc;
   border-radius:5px;
}

.goods img{
   width:200px;
   height:auto;
}
.goods .goods-footer{
  
}

.price{
 color:#f40;
 font-size:23px;
}
.payNum,.manufacturer{
 color:#888;
 float:right;
}

.noGoods{
 width:85%;
 margin:20px auto;
 padding-left:37%;
}
</style>

<script type="text/javascript">
 function goGoodsDetail(id){
	 window.parent.location.href="${pageContext.servletContext.contextPath}/CustomerGoodsServlet?goods_id="+id;
 }

</script>
</head>
<body>


<c:if test="${empty requestScope.page.list}" >
       <div class="noGoods"  >
         <img src ="${pageContext.servletContext.contextPath}/images/goodsQuery/noGoods.PNG"  alt="无商品"/>
           <div>亲，暂时没找到您想要的宝贝，请试试搜搜类似的。</div>
       </div>


</c:if>
<c:if test="${not empty requestScope.page.list}">
   <div id="goodsList">

   <c:forEach var="goods" items="${requestScope.page.list}">
   	   <div class="goods">
   	     <div class="box-img">
          <a href="javascript:;" onclick="goGoodsDetail(${goods.goods_id})"><img src="${my:mapToServer(goods.picURI)}" /></a>
         </div>
            <div class="goods-footer">
           <div></div><span class="price">￥${goods.price}</span> <span class="payNum">566人付款</span><div></div>
                                  <div>${goods.name}    </div>
                                  <div><span>品牌：${goods.brand}</span><span class="manufacturer">${goods.manufacturer}</span></div>
          </div>
       </div>
     </c:forEach>  
   	 
   </div>
</c:if>
<script type="text/javascript"  src="${pageContext.servletContext.contextPath}/jsp/goodsQuery/waterFall.js?${now1.time}" ></script>
</body>
</html>