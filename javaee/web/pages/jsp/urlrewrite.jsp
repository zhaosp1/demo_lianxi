<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String url=response.encodeURL("cookie.jsp");
	out.write(url);
	%>
	<a href='<%=url%>'>hello2.jsp</a>
</body>
</html>