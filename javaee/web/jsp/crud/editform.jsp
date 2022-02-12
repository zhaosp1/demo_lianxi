<%@ page import="com.example.jsp.bean.Customer" %>
<%@ page import="com.example.jsp.dao.CustomerDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>一点教程网-使用JSP完成CRUD</title>
</head>
<body>

<%
    String id=request.getParameter("id");
    Customer customer= CustomerDao.getRecordById(Integer.parseInt(id));
%>

<h1>编辑客户</h1>
<form action="editcust.jsp" method="post">
    <input type="hidden" name="id" value="<%=customer.getId() %>"/>
    <table>
        <tr><td>名称:</td><td><input type="text" name="name" value="<%=customer.getName() %>"/></td></tr>
        <tr><td>性别:</td><td>
            <input type="radio" name="gender" value="男" <% if(customer.getGender().equals("男")){%>checked<%}%>/>男
            <input type="radio" name="gender" value="女" <% if(customer.getGender().equals("女")){%>checked<%}%>/>女
        </td></tr>
        <tr><td>联系电话:</td><td><input type="text" name="telephone" value="<%=customer.getTelephone() %>"/></td></tr>
        <tr><td>住址:</td><td>
            <input type="text" name="address" value="<%=customer.getAddress() %>"/>
        </td></tr>
        <tr><td colspan="2"><input type="submit" value="编辑客户"/></td></tr>
    </table>
</form>

</body>
</html>