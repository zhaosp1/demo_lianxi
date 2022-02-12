package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/10 13:25
 */

@SpringBootApplication
@ServletComponentScan
@EnableCaching
public class BootApp {
  public static void main(String[] args) {
    SpringApplication.run(BootApp.class,args);
  }


//  //注册Servlet程序
//  @Bean
//  public ServletRegistrationBean getServletRegistrationBean(){
//    ServletRegistrationBean bean = new ServletRegistrationBean(new HelloServlet());
//    //设置访问路径
//    bean.addUrlMappings("/helloServlet");
//    return bean;
//  }
//
//  //注册Filter
//  @Bean
//  public FilterRegistrationBean getFilterRegistrationBean(){
//    FilterRegistrationBean bean = new FilterRegistrationBean(new HelloFilter());
//    //过滤器拦截路径
//    bean.addUrlPatterns("/helloServlet");
//    return bean;
//  }
//
//  //注册Listener
//  @Bean
//  public ServletListenerRegistrationBean<HelloListener> getServletListenerRegistrationBean(){
//    ServletListenerRegistrationBean<HelloListener> bean = new ServletListenerRegistrationBean<HelloListener>(new HelloListener());
//    return bean;
//  }
}
