package com.example.springboot.configuration.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// @WebServlet:声明该类为Servlet程序
/**
 * 等同于web.xml配置
 *     <servlet>
 *         <servlet-name>helloServlet</servlet-name>
 *         <servlet-class>com.yiidian.controller.HelloServlet</servlet-class>
 *     </servlet>
 *     <servlet-mapping>
 *     	   <servlet-name>helloServlet</servlet-name>
 *         <url-pattern>/helloServlet</url-pattern>
 *     </servlet-mapping>
 * @author lenovo
 *
 */
@WebServlet(name = "helloServlet",urlPatterns = "/helloServlet")
public class HelloServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("执行HelloServlet的doGet方法...");
    PrintWriter ps=resp.getWriter();
    resp.setContentType("text/html;charset=utf-8");
    ps.print("helloServlet");

  }
}
