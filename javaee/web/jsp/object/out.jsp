<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<html>
<head>
    <meta charset="utf-8">
    <title>一点教程网-JSP out内置对象</title>
</head>
<body>
<% out.print("今天是:"+java.util.Calendar.getInstance().getTime()); %>
</body>
</html>