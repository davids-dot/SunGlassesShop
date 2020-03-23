<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
 
	<meta charset="utf-8">
	<%@ include file="../head.jsp" %>
	<link href="pay1.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.rbox{
	z-index:1000;
	position:relative;	
}
.rbox-table{
	padding-bottom:30px;	
}
.pop-square{
	z-index:1002;	
}
.confirm-tip{
	z-index:900;	
}
.pc2mobile-box{
position: relative;
}

.confirm-head{
	font-size:22px;
}

.rbox-item-pc {
    display: block;
    width:19%;
    float: left;
    background: #f5f7fa;
    border: 1px solid #bfd0e3;
    margin-right: 10px;
    cursor: pointer;
}
.ui-button-text{

 	height: 35px;
    background-image: url(https://i.alipayobjects.com/e/201204/2vCVR5Bh4d.png);
    background-repeat: no-repeat;
    background-color: #2379b5;

	padding: 7px 22px 8px;
    background-position: right -1405px;
    color: #fff;

    font-family: verdana,\5b8b\4f53,\9ED1\4F53,sans-serif;
    font-size: 14px;
    font-weight: 700;

}


.rbox-item-pc .icon {
    width: 40px;
    height: 45px;
    display: block;
    float: left;
    background: url(https://i.alipayobjects.com/e/201308/uixb76yFJ.png) no-repeat -5px -5px;
}

				
</style>

</head>

<body>

<div class="content payment">
            
        <div class="page-head">
    <div class="title"><h2>转账付款</h2></div>
</div>
<!--表单-->


			
        

  <c:set var="payOrder" value="${sessionScope.payOrder}" ></c:set>
  <h4 class="rbox-title">确认您的转账信息</h4>
		<div class="rbox">
	<div class="rbox-bg"><div class="rbox-top"><div class="rbox-bottom"><div class="rbox-border">
		<div class="confirm-head rbox-block">
			<label class="fn-left">订单：</label>
		<span style="overflow:hidden;zoom:1;" class="fn-left">
		
				</span>
			
			<div class="fn-left recipient-text">
				 &nbsp;${payOrder.order_id}
			</div>
		</div>
		<div class="rbox-table" style="padding-top:40px">
		<table>
			<tbody>
				<tr>
					<th class="rbox-label"><span>付款金额：</span></th>
					<td class="rbox-item">
						<span>
							<em>${payOrder.totalPrice}</em>元
                        </span>
					</td>
				</tr>
				<tr>
					<th class="rbox-label"><span>付款说明：</span></th>
					<td class="rbox-item"><span>www</span></td>
				</tr>
				<tr>
				  <th class="rbox-label"><span>顾客：</span></th>
					<td class="rbox-item"><span>${sessionScope.user.name }</span></td>
				</tr>
				
				  <tr class="pc2mobile">
					<th class="rbox-label"><span>选择付款终端：</span></th>
					<td class="rbox-item">
						<div class="pc2mobile-box fn-clear">
							<a href="#" id="J-choose-pc" class="rbox-item-pc box-item-pc-active" >
								<span class="rbox-item-pad">
									<i class="icon"></i>
									<span class="title">电脑付款</span>
                                </span>
							  </a>
					</div>
					</td>
				</tr>
                                

			</tbody>
		</table>
		</div>
	</div></div></div></div>
	</div>


	</div><!--content payment -->

         <div class="confirm-button confirm-button-left">
                <div class="ui-button ui-button-mblue">
                   <form action="${pageContext.servletContext.contextPath}/BussinessServlet" method="post">
                   <input type="hidden" name="type" value="payConfirm"/>
                   <input type="hidden" name="order_id" value="${payOrder.order_id}"/>
                 
                      <input class="ui-button-text" type="submit" value="确认信息并付款" id="nextbtn">
                   </form>
                </div>
        </div>

   

			
</body>
</html>