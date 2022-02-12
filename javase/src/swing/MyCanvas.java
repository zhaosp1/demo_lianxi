package swing;

import javax.swing.*;
import java.awt.*;

/**
 * TODO
 * swing利用Canvas绘制图片
 */
public class MyCanvas extends Canvas {
  @Override
  public void paint(Graphics g) {
    Toolkit toolkit=Toolkit.getDefaultToolkit();
    Image image=toolkit.getImage("C:\\Users\\lucky\\Desktop\\qq.png");
    g.drawImage(image,200,200,this);
  }

  public static void main(String[] args) {
    MyCanvas myCanvas=new MyCanvas();

    JFrame jFrame=new JFrame();
    jFrame.setTitle("swing绘制图片");
    jFrame.add(myCanvas);
    jFrame.setSize(500,500);
    jFrame.setVisible(true);
  }
}
