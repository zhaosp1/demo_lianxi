<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>一点教程网-JSP pageContext内置对象</title>
</head>
<body>
<%

    String name=(String)pageContext.getAttribute("user",PageContext.SESSION_SCOPE);
    out.print("你好 "+name);

%>
</body>
</html>