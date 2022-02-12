<%@ page import="com.example.jsp.dao.CustomerDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>一点教程网-使用JSP完成CRUD</title>
</head>
<body>
<jsp:useBean id="customer" class="com.example.jsp.bean.Customer"></jsp:useBean>
<jsp:setProperty property="*" name="customer"/>
<%
    CustomerDao.delete(customer);
    response.sendRedirect("viewcusts.jsp");
%>
</body>
</html>