package util.mail;

import util.common.MailUtil;

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

@WebServlet(urlPatterns = "/sendMail")
public class SendMailServlet extends HttpServlet {

  public void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();

    String to=request.getParameter("to");
    String subject=request.getParameter("subject");
    String msg=request.getParameter("msg");

    try {
      MailUtil.sendMsg(to, subject, msg);
    } catch (Exception e) {
      e.printStackTrace();
    }
    out.print("邮件已经发送完成!");
    out.close();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.sendRedirect("/mail/index.jsp");
  }
}