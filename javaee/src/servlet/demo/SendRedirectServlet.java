package servlet.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servlet实现——http的重定向
 */

//重定向——永久重定向缓存跳转关联，sendRedirect临时重定向302
@WebServlet(displayName = "HttpResendServlet",name = "resend",urlPatterns = "/servlet/resend")
public class SendRedirectServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param=req.getParameter("url").trim();
		resp.sendRedirect(param);
		
		//301永久重定向
//		resp.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
//		resp.setHeader("Location", "/hello");
	}
}
