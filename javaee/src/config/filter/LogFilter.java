//package config.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.annotation.WebInitParam;
//import java.io.IOException;
//
//@WebFilter(filterName = "logFilter", urlPatterns = "/*", initParams = {@WebInitParam(name = "login", value = "login", description = "登录功能"),
//		@WebInitParam(name = "signout", value = "signout", description = "注销功能")})
//public class LogFilter implements Filter{
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//		System.out.println("拦截器初始化...");
//		// 获取初始化参数
//		String site = filterConfig.getInitParameter("Site");
//		// 输出初始化参数
//		System.out.println("网站名称: " + site);
//	}
//
//	@Override
//	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
//					throws IOException, ServletException {
//		System.out.println("请求拦截器前");
//		arg2.doFilter(arg0, arg1);
//		System.out.println("请求拦截后");
//	}
//
//	@Override
//	public void destroy() {
//		System.out.println("拦截器销毁...");
//	}
//}
