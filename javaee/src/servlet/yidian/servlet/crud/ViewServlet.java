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
import java.util.List;

/**
 * 一点教程网 - http://www.yiidian.com
 */
@WebServlet("/viewServlet")
public class ViewServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out=response.getWriter();
    out.println("<a href='/crud/index.jsp'>添加客户</a>");
    out.println("<h1>客户列表</h1>");

    List<Customer> list= CustomerDao.getAllEmployees();

    out.print("<table border='1' width='100%'");
    out.print("<tr><th>Id</th><th>客户名称</th><th>性别</th><th>联系电话</th><th>地址</th><th>编辑</th><th>删除</th></tr>");
    for(Customer e:list){
      out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getGender()+"</td>  "
              +" <td>"+e.getTelephone()+"</td><td>"+e.getAddress()+"</td><td><a href='/editServlet?id="+e.getId()+"'>编辑</a></td>  "
              +"<td><a href='/deleteServlet?id="+e.getId()+"'>删除</a></td></tr>");
    }
    out.print("</table>");

    out.close();
  }
}