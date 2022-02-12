package servlet.demo;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/12 22:05
 */
public class FirstGenericServlet extends GenericServlet {
  @Override
  public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
    servletResponse.setContentType("text/html");
    servletResponse.setCharacterEncoding("utf-8");

    PrintWriter out=servletResponse.getWriter();
    out.print("<html><body>");
    out.print("<b>FirstGenericServlet——这是一个GenericServlet的Servlet程序</b>");
    out.print("</body></html>");
  }
}
