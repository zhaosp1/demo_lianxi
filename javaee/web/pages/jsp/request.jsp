<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP的请求</title>
</head>
<body>
<h1>request的请求头信息</h1>
	<table>
		<%
			Enumeration<String> requestHeaders = request.getHeaderNames();
			while (requestHeaders.hasMoreElements()) {
				String headerName = requestHeaders.nextElement();
				out.print("<tr><td>" + headerName + "</td>\n");
				String headerValue = request.getHeader(headerName);
				out.print("<td> " + headerValue + "</td></tr>\n");
			}
		%>
	</table>
	<br><br>
	<h1>request的方法信息（和servlet的一样）</h1>
	<%
	 out.println("浏览器发出请求时的完整URL，包括协议 主机名 端口(如果有): " + request.getRequestURL());
    out.println("<br>浏览器发出请求的资源名部分，去掉了协议和主机名: " + request.getRequestURI());
    out.println("<br>请求行中的参数部分: " + request.getQueryString());
    out.println("<br>浏览器所处于的客户机的IP地址: " + request.getRemoteAddr());
    out.println("<br>浏览器所处于的客户机的主机名: " + request.getRemoteHost());
    out.println("<br>浏览器所处于的客户机使用的网络端口: " + request.getRemotePort());
    out.println("<br>服务器的IP地址: " + request.getLocalAddr());
    out.println("<br>服务器的主机名: " + request.getLocalName());
    out.println("<br>得到客户机请求方式: " + request.getMethod());
    out.println("<br>得到客户机会话session的id: " + request.getSession().getId());
	%>
</body>
</html>