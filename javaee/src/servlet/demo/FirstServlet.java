package servlet.demo;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/12 21:46
 */
public class FirstServlet implements Servlet {
  ServletConfig servletConfig=null;
  @Override
  public ServletConfig getServletConfig() {
    return servletConfig;
  }
  @Override
  public String getServletInfo() {
    return "FirstServlet信息";
  }


  //servlet的三个主要接口方法：init、service、destroy
  @Override
  public void init(ServletConfig servletConfig) throws ServletException {
    this.servletConfig=servletConfig;
    System.out.println("FirstServlet初始化");
    String param=getServletConfig().getInitParameter("param");
    System.out.println("初始化参数为:"+param);
    String global=getServletConfig().getServletContext().getInitParameter("dname");
    System.out.println("全局初始化参数为:"+global);
  }
  @Override
  public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
    servletResponse.setContentType("text/html");
    servletResponse.setCharacterEncoding("utf-8");

    PrintWriter out=servletResponse.getWriter();
    out.print("<html><body>");
    out.print("<b>firstServlet——这是一个简单的Servlet应用!</b>");
    out.print("</body></html>");
  }
  @Override
  public void destroy() {
    System.out.println("FirstServlet销毁");
  }
}
