package servlet.yidian.servlet.login;

import config.filter.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
 * @date 2021/7/12 23:00
 */
@WebServlet(displayName = "Servlet2",name = "Servlet2",urlPatterns = Constant.SERVLET_WELCOME)
public class WelcomeServlet  extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();

    String n=request.getParameter("userName");
    out.print("欢迎你，"+n);
  }
}
