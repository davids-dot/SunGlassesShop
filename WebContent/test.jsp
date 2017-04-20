<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	

	<% int in =3; 
	  request.setAttribute("hi", in);
	
	%>
	${hi}
	<c:if test="${hi==3}">
	  <h1>去得了3</h1>
	</c:if>

</body>
</html>