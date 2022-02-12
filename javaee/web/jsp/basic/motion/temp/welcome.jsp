<%--
  Created by IntelliJ IDEA.
  User: lucky
  Date: 2021/7/17
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>

<jsp:useBean id="user" class="com.example.jsp.bean.User"></jsp:useBean>
<jsp:setProperty name="user" property="username" param="username"></jsp:setProperty>
<jsp:setProperty name="user" property="password" param="password"></jsp:setProperty>

<%="欢迎您！"%>

<jsp:getProperty name="user" property="username"/>
<jsp:getProperty name="user" property="password"/>
</body>
</html>
