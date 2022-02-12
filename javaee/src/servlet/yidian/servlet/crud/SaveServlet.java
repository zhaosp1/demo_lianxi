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
@WebServlet("/saveServlet")
public class SaveServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    //设置请求参数的编码
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out=response.getWriter();

    String name=request.getParameter("name");
    String gender=request.getParameter("gender");
    String telephone=request.getParameter("telephone");
    String address=request.getParameter("address");

    Customer e=new Customer();
    e.setName(name);
    e.setGender(gender);
    e.setTelephone(telephone);
    e.setAddress(address);

    int status= CustomerDao.save(e);
    if(status>0){
      out.print("<p>客户保存成功!</p>");
      request.getRequestDispatcher("index.jsp").include(request, response);
    }else{
      out.println("抱歉!保存失败");
    }

    out.close();
  }
}