package jsp.login;

import config.filter.Constant;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "loginServlet",urlPatterns = Constant.JSP_LOGIN)
public class LoginServlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/login/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(name) && "123".equals(password)) {
            request.getRequestDispatcher("/jsp/login/welcome.jsp").forward(request, response);
        } else {
            response.setStatus(301);
            response.setHeader("Location", "/jsp/login/fail.jsp");
        }
    }
}