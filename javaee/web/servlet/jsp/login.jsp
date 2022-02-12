<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>一点教程网-使用Servlet完成用户登录</title>
</head>
<body>
<h1>使用Servlet完成用户登录</h1>
<form action="/servlet/login" method="post">
    用户名:<input type="text" name="username"/><br/><br/>
    密码:<input type="password" name="password"/><br/><br/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>