<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>日期格式化</title>
</head>
<body>
<div>
<h1>日期格式化</h1>
<%
	response.setIntHeader("Refresh", 1);
	Date date=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日  hh时mm分ss秒");
	out.print("当前时间为："+sdf.format(date));
%>
</div>
</body>
</html>