<%@ page language="java" contentType="text/html;charset=utf-8" %>
<html>
<html>
<head>
    <meta charset="utf-8">
    <title>一点教程网-jsp:plugin动作标签</title>
</head>
<body>

<h2>jsp:plugin动作标签</h2>

<jsp:plugin align="middle" type="applet" code="com.example.jsp.util.MyApplet" codebase="." width="200" height="200">
    <jsp:params>
        <jsp:param name="image" value="spring.jpg"/>
    </jsp:params>
    <jsp:fallback>error happens when insert applet</jsp:fallback>
</jsp:plugin>

</body>
</html>