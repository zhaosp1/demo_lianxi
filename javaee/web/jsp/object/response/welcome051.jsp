<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>一点教程网-JSP session内置对象</title>
</head>
<body>
<%

    String name=(String)session.getAttribute("user");
    out.print("你好 "+name);

%>
</body>
</html>