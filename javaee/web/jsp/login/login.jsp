<%@ page language="java" contentType="text/html;charset=utf-8" %>
<html>
<html>
<head>
    <meta charset="utf-8">
    <title>一点教程网-使用JSP完成用户登录</title>
</head>
<body>

<h1>使用JSP完成用户登录</h1>
<form action="/jsp/login" method="post">
    用户名:<input type="text" name="username"/><br/><br/>
    密码:<input type="password" name="password"/><br/><br/>
    <input type="submit" value="登录"/><a href="/jsp/register">注册</a>
</form>
</body>
</html>