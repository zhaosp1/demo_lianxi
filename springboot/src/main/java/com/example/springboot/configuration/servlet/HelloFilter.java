package com.example.springboot.configuration.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/10 20:41
 */
@WebFilter(filterName="helloFilter",urlPatterns="/helloServlet")
public class HelloFilter implements Filter {
  @Override
  public void destroy() {

  }

  @Override
  public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
          throws IOException, ServletException {
    System.out.println("执行了前面代码");

    //放行执行目标资源：HelloServlet
    arg2.doFilter(arg0, arg1);

    System.out.println("执行了后面代码");
  }

  @Override
  public void init(FilterConfig arg0) throws ServletException {

  }
}
