package servlet.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/12 22:12
 */
public class FirstHttpServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name=req.getParameter("name");

    resp.setContentType("text/html");
    resp.setCharacterEncoding("utf-8");
    PrintWriter out=resp.getWriter();
    out.print("<html><body>");
    out.print("<b>FirstHttpServlet——这是一个HttpServlet的Servlet程序,是HTTP的GET请求</b>");
    out.print("<br>您传递的参数是："+name);
    out.print("</body></html>");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name=req.getParameter("name");

    resp.setContentType("text/html");
    resp.setCharacterEncoding("utf-8");
    PrintWriter out=resp.getWriter();
    out.print("<html><body>");
    out.print("<b>FirstHttpServlet——这是一个HttpServlet的Servlet程序，,是HTTP的POST请求</b>");
    out.print("您传递的参数是："+name);
    out.print("</body></html>");
  }
}
