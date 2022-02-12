package util.report;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 一点教程网 - http://www.yiidian.com
 */
@WebServlet(urlPatterns = "/exportImage")
public class DisplayImage extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    response.setContentType("image/png");
    ServletOutputStream out;
    out = response.getOutputStream();
    FileInputStream fin = new FileInputStream("d:\\upload\\logo.png");

    BufferedInputStream bin = new BufferedInputStream(fin);
    BufferedOutputStream bout = new BufferedOutputStream(out);
    int ch =0; ;
    while((ch=bin.read())!=-1)
    {
      bout.write(ch);
    }

    bin.close();
    fin.close();
    bout.close();
    out.close();
  }
}