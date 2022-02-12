package servlet.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * servlet实现http的get请求
 */
@WebServlet(displayName = "HttpGetServelt",name = "getServlet",urlPatterns = "/servlet/get")
public class GetServlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param=req.getParameter("name");
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		PrintWriter ps=resp.getWriter();
		ps.write("<h1>hello "+param+"!</h1>");
		ps.flush();
	}
}
