package servlet.yidian.servlet.login;

import config.filter.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/12 23:27
 */
@WebServlet(displayName = "Servlet3",name = "Servlet3",urlPatterns = Constant.SERVLET_FORGET)
public class ForgetServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.sendRedirect(req.getContextPath()+"/servlet/jsp/forget.index");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.sendRedirect(req.getContextPath()+"/servlet/jsp/forget.jsp");
  }
}
