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
  ${now.time}

</body>
</html>