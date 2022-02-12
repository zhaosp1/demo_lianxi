<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<html>
<head>
    <title>一点教程网-使用JSP上传文件</title>
</head>
<body>

<%
    MultipartRequest m = new MultipartRequest(request, "C:\\Users\\lucky\\Desktop\\util.test");
    out.print("文件上传成功");

%>
</body>
</html>