<%@ page import="com.example.jsp.dao.CustomerDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>一点教程网-使用JSP完成CRUD</title>
</head>
<body>
<%
    //设置参数的中文编码
    request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="customer" class="com.example.jsp.bean.Customer"></jsp:useBean>
<jsp:setProperty property="*" name="customer"/>

<%
    int i= CustomerDao.update(customer);
    response.sendRedirect("viewcusts.jsp");
%>

</body>
</html>