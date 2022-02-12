<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>一点教程网-使用Servlet发送邮件</title>
</head>
<body>
<h1>使用Servlet发送邮件</h1>
<form action="/sendMail" method="post">
    收件人:<input type="text" name="to"/><br/>
    主题:<input type="text" name="subject"><br/>
    正文:<textarea rows="10" cols="70" name="msg"></textarea><br/>
    <input type="submit" value="发送"/>
</form>
</body>
</html>