<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>一点教程网-useBean的使用</title>
</head>
<body>
<jsp:useBean id="user" class="com.example.jsp.bean.User" scope="request"></jsp:useBean>

<form action="temp/welcome.jsp" method="post">
    用户名:<input type="text" name="username"><br>
    密码:<input type="password" name="password"><br>
    <input type="submit" value="注册">
</form>
</body>
</html>