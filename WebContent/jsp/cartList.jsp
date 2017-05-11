<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="/my" prefix="my" %>
<jsp:useBean id="now" class="java.util.Date" ></jsp:useBean>
 
<!DOCTYPE HTML>
<html>
  <head>
    <title>cartlist.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="${pageContext.servletContext.contextPath}/js/jquery-3.1.1.js"></script>
	
	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/cartList.css?${now.time}">
<script type="text/javascript">

function round(num,dec){ 
    var strNum = num + '';/*把要转换的小数转换成字符串*/
    var index = strNum.indexOf("."); /*获取小数点的位置*/
    if(index < 0) {
        return num;/*如果没有小数点，那么无需四舍五入，返回这个整数*/
    }
    var n = strNum.length - index -1;/*获取当前浮点数，小数点后的位数*/
    if(dec < n){ 
    	/*把小数点向后移动要保留的位数，把需要保留的小数部分变成整数部分，只留下不需要保留的部分为小数*/ 
        var e = Math.pow(10, dec);
        num = num * e;
        /*进行四舍五入，只保留整数部分*/
        num = Math.round(num);
        /*再把原来小数部分还原为小数*/
        return num / e;
    } else { 
        return num;/*如果当前小数点后的位数等于或小于要保留的位数，那么无需处理，直接返回*/
    } 
} 



$(function() {
	
	    var selectAll =document.getElementById("selectAll");
		/*
		给全选添加click事件
		*/
					$("#selectAll").click(function() {
					       
						   var checked = selectAll.checked;
						
					        $(":checkbox[name=checkboxBtn]").each(
					       	      function(){
					       	      	  		this.checked=checked;
					       	      }
					       	);
					        setJieSuan(checked);
			
					       	showTotal();

					});
		
		

					/*
					给所有条目的复选框添加click事件
					*/


					 $(":checkbox[name=checkboxBtn]").each(
	 		    		function(){
	 		    			 this.onclick = checkAll;
				       	 }
	 				);



	
	/*
	给减号添加click事件
	*/
	$(".jian").click(function() {
		// 获取cartItemId
		
		var numInput = $(this).parent().find('input');
		
		  var str = numInput.attr('id');
		  var result =str.match(/^([0-9]+)&([0-9]+)$/);
		  var goods_id =result[1];
		  var shop_id =result[2];
		  var quantity = numInput.val();
		// 判断当前数量是否为1，如果为1,那就不是修改数量了，而是要删除了。
		if(quantity == 1) {
			if(confirm("您是否真要删除该条目？")) {
				location = "/goods/CartItemServlet?method=batchDelete&cartItemIds=" + numInput.attr('id');
			}
		} else {
			sendUpdateQuantity(goods_id,shop_id,quantity-1);
		}
	});
	
	// 给加号添加click事件
	$(".jia").click(function() {
		// 获取cartItemId
		var numInput = $(this).parent().find('input');
	    var str = numInput.attr('id');
		var result =str.match(/^([0-9]+)&([0-9]+)$/);
		var goods_id =result[1];
		var shop_id =result[2];
		
		var quantity = numInput.val();
		sendUpdateQuantity(goods_id,shop_id,Number(quantity)+1);
	});
	
	$(document).ajaxError(function(event,request,settings,throwError){
		console.log("event"+event);
		console.log(request);
		console.log(settings);
		console.log(throwError);
	});
	
	$("#selectAll").click();
});

// 请求服务器，修改数量。
function sendUpdateQuantity(goods_id,shop_id,quantity) {
	$.ajax({
		async:true,
		cache:false,
		url:"/SunGlassesShop/AjaxServlet",
		data:{type:"cart",method:"updateQuantity",cartItemId:goods_id,shopId:shop_id,num:quantity},
		type:"POST",
		dataType:"json",
		success:function(answer) {
			//1. 修改数量
			
		    var numInput = document.getElementById(goods_id + "&"+shop_id);
			numInput.value=answer.quantity;
			//2. 修改小计
			$("#" + goods_id + "Subtotal").text(answer.subTotal);
			//3. 重新计算总计
			showTotal();
		},
		error:function(xhr){
			console.log(xhr);
			
		}
	});
}

/*
 * 计算总计
 */
function showTotal() {
	var total = 0;
	$(":checkbox[name=checkboxBtn]:checked").each(function() {
		var str = $(this).val();
		var id =str.substring(0,str.indexOf("&"));
		var text = $("#" + id + "Subtotal").text();
		total += Number(text);
	});
	$("#total").text(round(total, 2));//round()函数的作用是把total保留2位
	
}


/*
 * 设置结算按钮样式
 */
function setJieSuan(bool) {
	if(bool) {
		$("#jiesuan").removeClass("kill").addClass("jiesuan");
		$("#jiesuan").unbind("click");//撤消当前元素止所有click事件
	} else {
		$("#jiesuan").removeClass("jiesuan").addClass("kill");
		$("#jiesuan").click(function() {return false;});
	}
	
}

/*
 * 批量删除
 */
function batchDelete() {
	// 1. 获取所有被选中条目的复选框
	// 2. 创建一数组，把所有被选中的复选框的值添加到数组中
	// 3. 指定location为CartItemServlet，参数method=batchDelete，参数cartItemIds=数组的toString()
	var cartItemIdArray = new Array();
	$(":checkbox[name=checkboxBtn][checked=true]").each(function() {
		cartItemIdArray.push($(this).val());//把复选框的值添加到数组中
	});
	location = "/goods/CartItemServlet?method=batchDelete&cartItemIds=" + cartItemIdArray;
}

/*
 * 结算
 */
function jiesuan() {
	// 1. 获取所有被选择的条目的id，放到数组中
	var cartItemIdArray = new Array();
	$(":checkbox[name=checkboxBtn]:checked").each(function() {
		cartItemIdArray.push($(this).val());//把复选框的值添加到数组中
	});	
	// 2. 把数组的值toString()，然后赋给表单的cartItemIds这个hidden
	$("#cartItemIds").val(cartItemIdArray.toString());
	// 把总计的值，也保存到表单中
	$("#hiddenTotal").val($("#total").text());
	// 3. 提交这个表单
	$("#jieSuanForm").submit();
}



//每个子选框变化时
function checkAll(){
	var all =$(":checkbox[name=checkboxBtn]").length;
	var select =$(":checkbox[name=checkboxBtn]:checked").length;
	if(select===all){
		selectAll.checked=true;
		setJieSuan(true);
	}else{
		selectAll.checked=false;
		if(select===0){
			setJieSuan(false);
		}else{
			setJieSuan(true);
		}
	}
	showTotal();
}

	/*判断子选择框是否与父选择框一致*/






 /*无用函数，开发时测试*/
function isChecked(obj){
	if(obj instanceof HTMLInputElement){
		alert(obj.checked);
	}else{
		alert(obj.get(0).checked);
	}
	
}
</script>


<style>
  table{
  border:0;margin:0;border-collapse:collapse;border-spacing:0;
  }
  
 

</style>
  </head>
  <body>

<c:choose>
	<c:when test="${empty sessionScope.cart.items }">
		<h1 style="color:#0000ff;text-align:center;" >我的购物车</h1>
	<table style="width:80%; margin:20px:auto;">
		<tr>
			<td align="right">
				<img align="top" src="${pageContext.servletContext.contextPath}/images/icon_empty.png"/>
			</td>
			<td>
				<span class="spanEmpty">您的购物车中暂时没有商品</span>
			</td>
		</tr>
	</table>  
	</c:when>
	<c:otherwise>
	
	
	<h1 style="color:#0000ff;text-align:center;" >我的购物车</h1>
<table style="width:90%; margin:20px auto;">
	<tr align="center" bgcolor="#efeae5">
		<td align="left" width="50px">
			<input type="checkbox" id="selectAll" /><label for="selectAll">全选</label>
		</td>
		<td>商品图片</td>
		<td>商品名称</td>
		<td>单价</td>
		<td>数量</td>
		<td>小计</td>
		<td>操作</td>
	</tr>



<c:forEach items="${sessionScope.cart.items}" var="cartItem">
	<tr align="center">
		<td ><!-- 单选框 -->
			<input value="${cartItem.goods_id}&${cartItem.shop_id}" type="checkbox" name="checkboxBtn" />
		</td>
		<td ><!-- 图片-->
			<a class="linkImage" href="#"><img border="0" width="54" align="top" src="${my:mapToServer(cartItem.goods.picURI)}"/></a>
		</td>
		<td ><!-- 名称-->
		    <a href="#"><span>${cartItem.goods.name }</span></a>
		</td>
		
		<td><!-- 单价 -->
		<span>&yen;<span class="currPrice" id="${cartItem.goods_id}price">${cartItem.goods.price}元</span></span></td>
		
		<td><!-- 数量 -->
			<a class="jian" id="Jian"></a><input class="quantity" readonly="readonly" id="${cartItem.goods_id}&${cartItem.shop_id}" type="number" value="${cartItem.num}"/><a class="jia" id="Jia"></a>
		</td>
		<td width="100px"><!-- 小计 -->
			<span class="price_n">&yen;<span class="subTotal" id="${cartItem.goods_id}Subtotal">${cartItem.goods.price*cartItem.num}</span></span>
		</td>
		<td>
			<a href="javascript:void(0)" onclick="deleteFromCart(${cartItem.goods_id},${cartItem.shop_id})">删除</a>
		</td>
	</tr>
</c:forEach>


	
	<tr>
		<td colspan="4" class="tdBatchDelete">
			<a href="javascript:batchDelete();">批量删除</a>
		</td>
		<td colspan="3" align="right" class="tdTotal">
			<span>总计：</span><span class="price_t">&yen;<span id="total">${sessionScope.cart.totalPrice}</span></span>
		</td>
	</tr>
	<tr>
		<td colspan="7" align="right">
			<a href="javascript:jiesuan();" id="jiesuan" class="jiesuan"></a>
		</td>
	</tr>
</table>
	<form id="jieSuanForm" action="${pageContext.servletContext.contextPath}/BussinessServlet" method="post">
		<input type="hidden" name="cartItemIds" id="cartItemIds"/>
		<input type="hidden" name="total" id="hiddenTotal"/>
		<input type="hidden" name="method" value="loadCartItems"/>
		<input type="hidden" name="type"  value="buySomeGoods"/>
	</form>

	</c:otherwise>
</c:choose>
  </body>
  
  <script>
  function deleteFromCart(goods_id,shop_id){
	  
	  var del =window.confirm("您确定删除该购物项吗？");
	  if(!del) return ;
	  window.location.href="${pageContext.servletContext.contextPath}/CartServlet?type=delete&goods_id="+goods_id+"&shop_id="+shop_id;
	  
  }
  </script>
</html>
