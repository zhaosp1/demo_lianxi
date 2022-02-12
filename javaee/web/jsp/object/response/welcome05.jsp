<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>一点教程网-JSP session内置对象</title>
</head>
<body>

<%

    String name=request.getParameter("uname");
    out.print("欢迎 "+name);
    session.setAttribute("user",name);
%>

<a href="welcome051.jsp">second.jsp页面</a>

</body>
</html>