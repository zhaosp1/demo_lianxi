package config.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/13 0:38
 */
@WebFilter(filterName = "loginFilter", urlPatterns = "/*", initParams = {@WebInitParam(name = "login", value = "login", description = "登录功能"),
        @WebInitParam(name = "signout", value = "signout", description = "注销功能")})
public class LoginFilter implements Filter {
  Logger log = Logger.getLogger(LoginFilter.class.getName());
  private static final List<String> list = new ArrayList<>();

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    log.info("初始化filter...");
    String login = filterConfig.getInitParameter("login");
    String signout = filterConfig.getInitParameter("signout");
    list.add(login);
    list.add(signout);
  }

  private boolean check(String path) {
    if(path.indexOf("/jsp/login")>0||path.indexOf("/servlet/login")>0)
      return true;
    else
      return false;
  }

  @Override
  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
    resp.setContentType("text/html;charset=utf-8");
    PrintWriter out = resp.getWriter();

    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) resp;

    String isLogin=String.valueOf(request.getSession().getAttribute("isLogin"));
    boolean flag=true;
    if(isLogin==null||"null".equalsIgnoreCase(isLogin)){
      flag=false;
    }
    String url=request.getRequestURL().toString();
    log.info("被filter过滤.......");
    String contextpath = request.getContextPath();
    if ("/".equals(contextpath)) {
      contextpath = "";
    }
    if (check(url)||flag) {
      log.info("白名单");
      chain.doFilter(request, response);
    } else{
      log.info("黑名单");
      response.sendRedirect(response.encodeURL(contextpath + "/servlet/login"));
    }
  }

  @Override
  public void destroy() {
    log.info("销毁filter....");
  }
}
