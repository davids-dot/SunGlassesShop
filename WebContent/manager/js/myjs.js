
// JavaScript Document

//windowload
//<%--先看数据有没有都进来，没有就去数据库读数据 --%>


function tzPage(param) {

	$("#nextPage").val(param);
	$("#userManageForm").submit();
}

function setState(param) {
	
	$("#state"+param).val(param);
	$("#nextPage1"+param).val("0");
	$("#userManageForm"+param).submit();
	
}

function logout() {
	var r = confirm("确认注销？");
	if (r == true) {
		window.location.href = "/CshtsAms/user/loginout.action";
	}
}

