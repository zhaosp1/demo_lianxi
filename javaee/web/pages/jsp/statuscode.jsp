<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Setting HTTP Status Code</title>
</head>
<body>
	<%-- 
		设定响应状态码——public void setStatus ( int statusCode )
		设定重定向——public void sendRedirect(String url)
		设定响应错误代码——public void sendError(int code, String message)
 --%>
	
	<%
		// 设置错误代码，并说明原因
		response.sendError(407, "Need authentication!!!");
	%>
</body>
</html>