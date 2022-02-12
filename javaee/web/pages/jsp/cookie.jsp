<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String s = request.getParameter("name");
		Cookie name = new Cookie("name", s);
		Cookie url = new Cookie("url", request.getRequestURI());
		//设置cookie过期时间为24小时。
		name.setMaxAge(60 * 60 * 24);
		url.setMaxAge(60 * 60 * 24);

		//在响应头部添加cookie
		response.addCookie(name);
		response.addCookie(url);
	%>
	<title>设置 Cookie</title>
</body>
<body>

	<h1>设置 Cookie</h1>

<ul>
<li><p>
				<b>网站名:</b>
   <%=request.getParameter("name")%>
</p></li>
<li><p>
				<b>网址:</b>
   <%=request.getParameter("url")%>
</p></li>
</ul>

<div>
<br/>
<%
   Cookie cookie = null;
   Cookie[] cookies = null;
   // 获取 cookies 的数据,是一个数组
   cookies = request.getCookies();
   if( cookies != null ){
      out.println("<h2> 当前Cookie 名与值</h2>");
      for (int i = 0; i < cookies.length; i++){
         cookie = cookies[i];
        
         out.print("参数名 : " + cookie.getName());
         out.print("<br>");
         out.print("参数值: " + URLDecoder.decode(cookie.getValue(), "utf-8") +" <br>");
         out.print("------------------------------------<br>");
      }
  }else{
      out.println("<h2>没有发现 Cookie</h2>");
  }
%>
</div>
</body>


</html>