package servlet.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servlet实现——http的请求转发
 */
//请求转发，浏览器请求一次
@WebServlet(displayName = "HttpForwardServlet",name = "forward",urlPatterns = "/servlet/forward")
public class RequestDispatcherServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//请求转发的路径需要指定相对路径
		req.getRequestDispatcher("/test").forward(req, resp);
	}
}
