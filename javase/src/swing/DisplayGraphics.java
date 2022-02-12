package swing;

import javax.swing.*;
import java.awt.*;

/**
 * TODO
 *
 * swing使用Graphics绘制图形
 */
public class DisplayGraphics extends Canvas {
  @Override
  public void paint(Graphics g) {
    g.drawString("Hello",40,40);
    setBackground(Color.WHITE);
    g.fillRect(130, 30,100, 80);
    g.drawOval(30,130,50, 60);
    setForeground(Color.RED);
    g.fillOval(130,130,50, 60);
    g.drawArc(30, 200, 40,50,90,60);
    g.fillArc(30, 130, 40,50,180,40);
  }

  public static void main(String[] args) {
    DisplayGraphics s=new DisplayGraphics();
    JFrame jFrame=new JFrame();
    jFrame.setTitle("swing使用Graphics绘制图形");
    jFrame.add(s);
    jFrame.setSize(500,500);
    jFrame.setVisible(true);
  }
}
