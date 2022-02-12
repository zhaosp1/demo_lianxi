package servlet.yidian.servlet.crud;



import servlet.yidian.dao.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 一点教程网 - http://www.yiidian.com
 */
@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String sid=request.getParameter("id");
    int id=Integer.parseInt(sid);
    CustomerDao.delete(id);
    response.sendRedirect("/viewServlet");
  }
}