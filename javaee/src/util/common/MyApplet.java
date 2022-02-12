package util.common;

import javax.swing.*;
import java.awt.*;

/**
 * 一点教程网 - http://www.yiidian.com
 */
public class MyApplet extends JApplet{

  String img;
  public void paint(Graphics g)
  {
    Image image=getImage(getCodeBase(),img);

    g.drawImage(image,0,0,400,400,this);    //绘制一张图片
    g.setColor(Color.blue);
    g.setFont(new Font("宋体",2,24));
    g.drawString("yiidian",40,170);    //绘制一个字符串
    g.setColor(Color.pink);
    g.setFont(new Font("NewsRoman",2,10));
    g.drawString(new java.util.Date().toString(),10,109);    //绘制一个日期字符串
  }
  public void init()
  {
    img=getParameter("image");    //获取plugin指令中的参数
  }

}