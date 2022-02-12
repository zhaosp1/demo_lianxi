package servlet.yidian.servlet.login;
import config.filter.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
 * @date 2021/7/13 23:39
 */
@WebServlet(displayName = "Servlet15",name = "Servlet15",urlPatterns = Constant.SERVLET_PROFILE)
public class ProfileServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    response.setContentType("text/html;charset=utf-8");
    PrintWriter out=response.getWriter();

    request.getRequestDispatcher("/servlet/jsp/link.jsp").include(request, response);

    Cookie ck[]=request.getCookies();

    String name = null;

    for(Cookie c:ck){
      if(c.getName().equals("name")) {
        name = c.getValue();
      }
    }

    if(name!=null){
      out.print("<b>欢迎进入个人中心</b>");
      out.print("<br>欢迎你, "+name);
    }else{
      out.print("请先进行<a href=\"/servlet/login\">登录</a>");
    }
    out.close();
  }
}