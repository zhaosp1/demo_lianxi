package servlet.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/13 21:37
 */
@WebServlet(name = "sessionServlet",urlPatterns = "/servlet/session")
public class SessionServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    resp.setCharacterEncoding("utf-8");
    String name=req.getParameter("name");
    String value=req.getParameter("value");

    HttpSession session=req.getSession();
    String t1=(String)session.getAttribute("name");
    String t2=(String)session.getAttribute("value");

    if (t1!=null&&t2!=null&&t1.equals(name)&&t2.equals(value)){
      resp.getWriter().print("session中已经存储了"+name);
    }else {
      session.setAttribute("name",name);
      session.setAttribute("value",value);
      session.setMaxInactiveInterval(60*60);
      resp.getWriter().print("session没有存储当前用户名，重新进行存储了！");
    }
  }
}
