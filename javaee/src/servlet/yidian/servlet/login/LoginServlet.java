package servlet.yidian.servlet.login;

import config.filter.Constant;
import servlet.yidian.dao.LoginDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 一点教程网 - http://www.yiidian.com
 */
@WebServlet(urlPatterns = Constant.SERVLET_LOGIN)
public class LoginServlet extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    response.setContentType("text/html;charset=utf-8");
    RequestDispatcher rd = request.getRequestDispatcher("/servlet/jsp/login.jsp");
    rd.include(request, response);

  }


  public void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();

    String name = request.getParameter("username");
    String pass = request.getParameter("password");

    if (LoginDao.validate(name, pass)) {
      request.getSession().setAttribute("isLogin","1");
      request.getSession().setMaxInactiveInterval(60*1000);
      RequestDispatcher rd = request.getRequestDispatcher("/servlet/jsp/link.jsp");
      rd.forward(request, response);
    } else {
      out.print("抱歉，用户名或密码错误");
      RequestDispatcher rd = request.getRequestDispatcher("/servlet/jsp/login.jsp");
      rd.include(request, response);
    }

    out.close();
  }
}