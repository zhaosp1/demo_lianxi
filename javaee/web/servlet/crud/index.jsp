<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>一点教程网-使用Session完成增删改成（CRUD）</title>
</head>
<body>
<h1>添加客户</h1>
<form action="/saveServlet" method="post">
    <table>
        <tr><td>客户名称:</td><td><input type="text" name="name"/></td></tr>
        <tr><td>性别:</td><td><input type="radio" name="gender" value="男"/>男<input type="radio" name="gender" value="女"/>女</td></tr>
        <tr><td>联系电话:</td><td><input type="text" name="telephone"/></td></tr>
        <tr><td>地址:</td><td><input type="text" name="address"/></td></tr>
        <tr><td colspan="2"><input type="submit" value="保存"/></td></tr>
    </table>
</form>

<br/>
<a href="/viewServlet">查询客户</a>
</body>
</html>