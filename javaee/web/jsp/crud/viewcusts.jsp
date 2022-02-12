<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*"%>
<%@ page import="com.example.jsp.bean.Customer" %>
<%@ page import="com.example.jsp.dao.CustomerDao" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>一点教程网-使用JSP完成CRUD</title>
</head>
<body>
<h1>客户列表</h1>

<%
    List<Customer> list= CustomerDao.getAllRecords();
    request.setAttribute("list",list);
%>

<table border="1" width="90%">
    <tr><th>编号</th><th>名称</th><th>性别</th><th>联系电话</th>
        <th>住址</th><th>编辑</th><th>删除</th></tr>
    <c:forEach items="${list}" var="cust">
        <tr><td>${cust.id}</td><td>${cust.name}</td><td>${cust.gender}</td>
            <td>${cust.telephone}</td><td>${cust.address}</td>
            <td><a href="editform.jsp?id=${cust.id}">编辑</a></td>
            <td><a href="deletecust.jsp?id=${cust.id}">删除</a></td></tr>
    </c:forEach>
</table>
<br/><a href="addcustform.jsp">添加客户</a>
</body>
</html>
