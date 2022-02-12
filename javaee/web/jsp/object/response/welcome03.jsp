<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>一点教程网-JSP config内置对象</title>
</head>
<body>

<%
    out.print("欢迎你 "+request.getParameter("uname"));

    String driver=config.getInitParameter("dname");
    out.print(" 驱动名称是="+driver);
%>

</body>
</html>