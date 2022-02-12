package servlet.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/13 21:22
 */
@WebServlet(name = "cookiesServlet",urlPatterns = "/servlet/cookies")
public class CookiesServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    resp.setCharacterEncoding("utf-8");
    boolean flag=false;
    String name=req.getParameter("name");
    String value=req.getParameter("value");

    Cookie[] c=req.getCookies();
    if(c!=null&&name!=null&&value!=null){
      for(Cookie t:c){
        if(t.getName().equals(name)&&t.getValue().equals(value)){
          flag=true;
          break;
        }
      }
    }
    if (flag){
      resp.getWriter().print("Cookie中已经存储了"+name);
    }else {
      Cookie cookie=new Cookie(name,value);
      cookie.setMaxAge(60*60*10);
      resp.addCookie(cookie);
      resp.getWriter().print("cookie没有存储当前用户名，重新进行存储了！");
    }
  }
}
