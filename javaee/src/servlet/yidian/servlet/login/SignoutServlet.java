package servlet.yidian.servlet.login;

import config.filter.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/13 23:36
 */
@WebServlet(displayName = "Servlet14",name = "Servlet14",urlPatterns = Constant.SERVLET_SIGNOUT)
public class SignoutServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    response.setContentType("text/html;charset=utf-8");
    PrintWriter out=response.getWriter();
    request.getRequestDispatcher("/servlet/jsp/signout.jsp").include(request, response);
  }
}