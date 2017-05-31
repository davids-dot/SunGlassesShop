<%@ page language="java" import="java.util.*"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head lang="en">
<%@ include file="/js/head.jsp"%>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

<title>注册</title>

<link href="<%=path%>/framework/AmazeUI-2.4.2/assets/css/admin.css"
	rel="stylesheet" type="text/css">
<link href="<%=path%>/framework/AmazeUI-2.4.2/assets/css/amazeui.css"
	rel="stylesheet" type="text/css">

<link href="<%=path%>/framework/css/personal.css" rel="stylesheet"
	type="text/css">
<link href="<%=path%>/framework/css/infstyle.css" rel="stylesheet"
	type="text/css">
<script src="<%=path%>/framework/AmazeUI-2.4.2/assets/js/jquery.min.js"
	type="text/javascript"></script>
<script src="<%=path%>/framework/AmazeUI-2.4.2/assets/js/amazeui.js"
	type="text/javascript"></script>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.9.1.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

<link rel="stylesheet"
	href="http://jqueryui.com/resources/demos/style.css">

<!-- 导入 jQuery 库 -->
<script type="text/javascript" src="jquery-1.7.2.js"></script>
<script type="text/javascript">
function testNull() {
	var test=1;
	$(".userinput").each(function(i) {
		var mycontent = $.trim($(this).val());
		if (mycontent == '') {
			alert("请检查输入完整性")
			test=2;
			return false;
		}
		
	});
	
	
	if(test==2){
		return false;
	}
	var result=$('input:radio[name="radio10"]:checked').val();
	 if(result==null){
        alert("请做出您的选择");
        return false;
    }
	return true;
}
</script>


</head>

<body>
	<!--头 -->
	<header>
		<article>
			<div class="mt-logo">
				<!--顶部导航条 -->
				<div class="am-container header">
					<ul class="message-l">
						<div class="topMessage">
						
						</div>
					</ul>
					<ul class="message-r">
						<div class="topMessage home">
							<div class="menu-hd">
								<a href="#" target="_top" class="h">商城首页</a>
							</div>
						</div>
					</ul>
				</div>

				<!--悬浮搜索框-->

				<div class="nav white">
					<div class="logoBig">
						<li><img src="<%=path%>/framework/images/mylogo.png" /></li>
					</div>

					<div class="clear"></div>
				</div>
			</div>
		</article>
	</header>
	<b class="line"></b>
	<div class="center">

		<div class="col-main">
			<div class="main-wrap">

				<div class="user-info">
					<!--标题 -->
					<div class="am-cf am-padding">
						<div class="am-fl am-cf">
							<strong class="am-text-danger am-text-lg">注册信息</strong> / <small>register&nbsp;information</small>
						</div>
					</div>
					<hr />

					<!--头像 -->
					<div class="user-infoPic" class="am-form-group">

						<div class="filePic">
							<c:if test="${userDetail.stupic !=null}">
								<img src="<%=path%>/pic/${userDetail.stupic}" width=100 height=100 />
							</c:if>
						</div>

						<p class="am-form-help">头像</p>
						<div>
							<b>学生证照片</b>
						</div>
					</div>
				</div>
				<!--二维码 -->
				<div class="user-infoPic" class="am-form-group">

					<div class="filePic">
						<c:if test="${userDetail.stupic !=null}">
							<img src="<%=path%>/pic/${userDetail.qrcode}" width=100 height=100 />
						</c:if>
					</div>

					<p class="am-form-help">二维码</p>


					<div>
						<b>二维码</b>
					</div>
				</div>

				<!--个人信息 -->
				<div class="info-main" class="am-form-group">
					<div class="am-form-group">
						<label for="user-Id" class="am-form-label">用户名</label>
						<div class="am-form-content">
							${userDetail.userid}
						</div>
					</div>
					<div class="am-form-group">
						<label for="user-password" class="am-form-label">密码</label>
						<div class="am-form-content">
							${userDetail.password}
						</div>
					</div>
					<div class="am-form-group">
						<label for="user-name" class="am-form-label">姓名</label>
						<div class="am-form-content">
						${userDetail.username}
						</div>
					</div>

					<div class="am-form-group">
						<label class="am-form-label">性别</label>
						<div class="am-form-content sex">
						<c:if test="${userDetail.sex eq 0}">
							保密
						</c:if>
						<c:if test="${userDetail.sex eq 1}">
							男
						</c:if>
						<c:if test="${userDetail.sex eq 2}">
							女
						</c:if>
						</div>
					</div>

					<div class="am-form-group">
						<label for="user-birth" class="am-form-label">生日</label>
						<div class="am-form-content birth">
							<div class="birth-select">
								<fmt:formatDate value="${userDetail.birthday}" pattern="yyyy-MM-dd"/>
							</div>
						</div>

					</div>
					<div class="am-form-group">
						<label for="user-phone" class="am-form-label">电话</label>
						<div class="am-form-content">
							${userDetail.phone}
						</div>
					</div>
					<div class="am-form-group">
						<label for="user-email" class="am-form-label">电子邮件</label>
						<div class="am-form-content">
							${userDetail.email}
						</div>
					</div>
					<div class="am-form-group">
						<label for="user-studentId" class="am-form-label">学号</label>
						<div class="am-form-content">
							${userDetail.studentid}
						</div>
					</div>
					<div class="am-form-group">
						<label for="user-class" class="am-form-label">班级</label>
						<div class="am-form-content">
							${userDetail.classid}

						</div>
					</div>
					<div class="am-form-group">
						<label for="user-college" class="am-form-label">学院</label>
						<div class="am-form-content">
							${userDetail.college}

						</div>
					</div>
					<div class="am-form-group">
						<label for="user-school" class="am-form-label">学校</label>
						<div class="am-form-content">
						   ${userDetail.school}

						</div>
					</div>
					<div class="am-form-group">
						<label for="user-address" class="am-form-label">地址</label>
						<div class="am-form-content">
							${userDetail.address}

						</div>
					</div>
					<div>
			<form
				action="${pageContext.request.contextPath }/usermanage/handrequest.action"
				method="post" name="userManageForm" id="userManageForm2" onSubmit="return testNull()" >
				<div class="am-form-group">
				<label class="am-form-label">处理</label>
				<div class="am-form-content">
					<label class="am-radio-inline"> <input type="radio"
						name="radio10" value="1" data-am-ucheck> 通过
					</label> <label class="am-radio-inline"> <input type="radio"
						name="radio10" value="2" data-am-ucheck> 不通过
					</label>
				</div>
				</div>
				<div class="am-form-group">
						<label for="user-address" class="am-form-label">原因</label>
						<div class="am-form-content">
							<input class="userinput" id="user-reason" placeholder="请输入原因"
								type="text" name="reason" >
                            <input type="hidden" value="${itemid}" name="itemid">
						</div>
				</div>
			</form>
                  </div>
				</div>


			</div>
		</div>
		<div class="info-btn">
			<div class="am-btn am-btn-danger" onclick='$("#userManageForm2").submit()'>提交</div>
		</div>

	</div>

	</div>

	</div>
	<!--底部-->
	<div class="footer">
		<div class="footer-hd">
			<p>
				<b>|</b> <a href="#">商城首页</a> <b>|</b> <a href="#">支付宝</a> <b>|</b>
				<a href="#">物流</a>
			</p>
		</div>
		<div class="footer-bd"></div>
	</div>
	</div>


	</div>

</body>

</html>