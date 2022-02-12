<%--
  Created by IntelliJ IDEA.
  User: lucky
  Date: 2021/7/11
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>登录界面</h1>
<form action="/login" method="post"><p>用户名: <input name="username"></p>
    <p>密&nbsp;&nbsp;码: <input name="password" type="password"></p>
    <p>
        <button type="submit">Sign In</button>
        <a href="/exit">Cancel</a></p>
</form>
</body>
</html>
