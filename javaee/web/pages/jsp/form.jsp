<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP表单处理</h1>
	<div>
		<table>
			<%
			Enumeration<String> params=request.getParameterNames();
			while(params.hasMoreElements()){
				String name=(String)params.nextElement();
				String value=(String)request.getParameter(name);
				out.print("<tr><td>" + name + "</td>\n");
				out.print("<td> " + value + "</td></tr>\n");
			}
		%>
		</table>
	</div>
</body>
</html>