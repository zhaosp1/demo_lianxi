package servlet.yidian.servlet.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * 一点教程网 - http://www.yiidian.com
 * 获取所有请求头
 */
@WebServlet(urlPatterns = "/request")
public class HeaderServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html;charset=utf-8");
    PrintWriter out = resp.getWriter();

    out.println("所有请求头信息：<br>");

    Enumeration en = req.getHeaderNames();
    while (en.hasMoreElements()) {
      String headerName = (String)en.nextElement();
      String headerValue = req.getHeader(headerName);
      out.print("<b>"+headerName + "</b>: ");
      out.println(headerValue + "<br>");
    }
  }
}