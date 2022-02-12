<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="com.example.jsp.util.ImageUtil" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.io.BufferedInputStream" %>
<%@ page import="java.io.BufferedOutputStream" %>
<%@ page language="java" contentType="text/html;charset=utf-8" %>
<html>
<html>
<head>
    <meta charset="utf-8">
    <title>一点教程网-jsp:userBean动作标签</title>
</head>
<body>

<%
    BufferedImage image= ImageUtil.createImage(request.getSession(),5);
    response.setContentType("image/png");
    ServletOutputStream ps;
    ps = response.getOutputStream();
    FileInputStream fin = new FileInputStream("C:\\Users\\lucky\\Desktop\\util.test.png");

    BufferedInputStream bin = new BufferedInputStream(fin);
    BufferedOutputStream bout = new BufferedOutputStream(ps);
    int ch =0; ;
    while((ch=bin.read())!=-1)
    {
        bout.write(ch);
    }

    bin.close();
    fin.close();
    bout.close();
    out.close();
%>

</body>
</html>