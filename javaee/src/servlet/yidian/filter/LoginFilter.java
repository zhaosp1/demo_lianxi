//package servlet.yidian.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
///**
// * TODO
// *
// * @author zhaosp1
// * @version 1.0
// * @date 2021/7/14 23:34
// */
//@WebFilter(urlPatterns = "/*")
//public class LoginFilter implements Filter {
//  @Override
//  public void init(FilterConfig filterConfig) throws ServletException {
//
//  }
//
//  @Override
//  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, IOException {
//    HttpServletRequest request = (HttpServletRequest) servletRequest;
//    HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//    HttpSession session = request.getSession();
//    String currPath = request.getRequestURI();    //当前请求的URL
//    boolean flag=currPath.equals("/")||currPath.indexOf("/login")!=-1||currPath.indexOf("/index")!=-1||currPath.indexOf("/signsout")!=-1;
//    boolean isLogin;
//    if(session.getAttribute("isLogin")!=null){
//      isLogin=true;
//    }else {
//      isLogin=false;
//    }
//
//
//    if (flag||isLogin) {
//      filterChain.doFilter(servletRequest, servletResponse);
//    } else if (currPath.indexOf("/signout")!=-1&&!isLogin){
//      request.getRequestDispatcher("/signout?flag=0").forward(servletRequest,servletResponse);
//    } else{
//      request.getRequestDispatcher("/jsp/login.jsp").forward(servletRequest,servletResponse);
//    }
//  }
//
//  @Override
//  public void destroy() {
//
//  }
//
//}
