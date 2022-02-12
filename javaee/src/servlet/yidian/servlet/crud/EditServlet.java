package servlet.yidian.servlet.crud;



import servlet.yidian.bean.Customer;
import servlet.yidian.dao.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 一点教程网 - http://www.yiidian.com
 */
@WebServlet("/editServlet")
public class EditServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();
    out.println("<h1>编辑客户</h1>");
    String sid = request.getParameter("id");
    int id = Integer.parseInt(sid);

    Customer e = CustomerDao.getEmployeeById(id);

    out.print("<form action='editServlet' method='post'>");
    out.print("<table>");
    out.print("<tr><td></td><td><input type='hidden' name='id' value='" + e.getId() + "'/></td></tr>");
    out.print("<tr><td>客户名称:</td><td><input type='text' name='name' value='" + e.getName() + "'/></td></tr>");
    out.print("<tr><td>性别:</td><td>");
    if (e.getGender().equals("男")) {
      out.print("<input type='radio' name='gender' value='男' checked/>男");
    } else {
      out.print("<input type='radio' name='gender' value='男'/>男");
    }
    if (e.getGender().equals("女")) {
      out.print("<input type='radio' name='gender' value='女' checked/>女");
    } else {
      out.print("<input type='radio' name='gender' value='女'/>女");
    }
    out.print("</td></tr>");
    out.print("<tr><td>联系电话:</td><td><input type='text' name='telephone' value='" + e.getTelephone() + "'/></td></tr>");
    out.print("<tr><td>地址:</td><td><input type='text' name='address' value='" + e.getAddress() + "'/></td></tr>");
    out.print("<tr><td colspan='2'><input type='submit' value='编辑保存'/></td></tr>");
    out.print("</table>");
    out.print("</form>");

    out.close();
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();

    String sid = request.getParameter("id");
    int id = Integer.parseInt(sid);
    String name = request.getParameter("name");
    String gender = request.getParameter("gender");
    String telephone = request.getParameter("telephone");
    String address = request.getParameter("address");

    Customer e = new Customer();
    e.setId(id);
    e.setName(name);
    e.setGender(gender);
    e.setTelephone(telephone);
    e.setAddress(address);

    int status = CustomerDao.update(e);
    if (status > 0) {
      response.sendRedirect("/viewServlet");
    } else {
      out.println("抱歉!更新失败");
    }

    out.close();
  }
}