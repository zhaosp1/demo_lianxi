<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>一点教程网-JSP request内置对象</title>
</head>
<body>

<%
    String name=request.getParameter("uname");
    out.print("欢迎你 "+name);
%>

</body>
</html>