<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>一点教程网-JSP pageContext内置对象</title>
</head>
<body>

<%

    String name=request.getParameter("uname");
    out.print("欢迎 "+name);

    pageContext.setAttribute("user",name,PageContext.SESSION_SCOPE);

%>

<a href="welcome061.jsp">second.jsp页面</a>

</body>
</html>