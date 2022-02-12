<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>页面点击量</h1>
<div>
<%
	Integer count=(Integer)application.getAttribute("click");
	if(count==null||count.equals(0)){
		count=1;
		application.setAttribute("click", count);
	}else{
		count+=1;
		application.setAttribute("click", count);
	}
%>
<p>页面访问量：<%=count %></p>
</div>
</body>
</html>