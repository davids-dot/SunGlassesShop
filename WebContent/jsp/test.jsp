<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

  <jsp:useBean id="now" class="java.util.Date"  scope="page"></jsp:useBean>

<form  action="${pageContext.servletContext.contextPath}/jsp/goodsQuery/queryGoods.jsp" method ="post">

  <input type="submit" value="提交" />
</form>

</body>
</html>