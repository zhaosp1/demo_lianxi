<%--
  Created by IntelliJ IDEA.
  User: lucky
  Date: 2021/7/17
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>JSP语法基础</title>
</head>
<body>
<%--JSP注释标签--%>
<%!
    //JSP声明——主要用于声明变量
    String s = "jsp声明内容";
%>

<%
    //JSP脚本——主要用于存储java功能代码(所有的含有java脚本代码，均包含在< %java脚本% >中
    out.print(s);
%>

<%="java语法表达式，主要用向静态html脚本中输入内容，等同于out.print('值')"%>
</body>
</html>
