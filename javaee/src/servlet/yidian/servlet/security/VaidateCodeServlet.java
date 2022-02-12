package servlet.yidian.servlet.security;


import util.common.ImageUtil;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 一点教程网 - http://www.yiidian.com
 */

@WebServlet(urlPatterns = "/vaidateCode")
public class VaidateCodeServlet extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    //创建图像
    BufferedImage bi = ImageUtil.createImage(request.getSession(), 5);
    //以png格式   输出响应流到界面
    ImageIO.write(bi, "png", response.getOutputStream());

    /** 设置浏览器不缓存图片*/
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("expires", -1);
  }
}