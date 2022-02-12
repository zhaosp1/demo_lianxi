<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>一点教程网-使用JSP上传文件</title>
</head>
<body>
<h1>使用JSP上传文件</h1>
<form action="temp/upload.jsp" method="post" enctype="multipart/form-data">
    请选择文件:<input type="file" name="fname"/><br/>
    <input type="submit" value="上传"/>
</form>
</body>
</html>