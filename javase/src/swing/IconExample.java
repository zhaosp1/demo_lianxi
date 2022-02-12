package swing;

import java.awt.*;

/**
 * TODO
 *
 *  ToolKit工具包的应用
 *  Frame类的setIconImage() 方法用于更改Frame或Window的图标。它将更改在“Frame”或“Window”左侧显示的图标。
 * 该工具包类用于获取图像类的实例在AWT和Swing的。
 *  Toolkit类是Abstract Window Toolkit(AWT)中每个实现的抽象 超类。Toolkit的子类用于绑定各种组件。它继承了Object类。
 */
public class IconExample {
  IconExample(){
    Frame frame=new Frame();
    frame.setTitle("ToolBar示例");

    Image icon=Toolkit.getDefaultToolkit().getImage("C:\\Users\\lucky\\Desktop\\qq.png");

    frame.setIconImage(icon);
    frame.setLayout(null);
    frame.setSize(600,600);
    frame.setVisible(true);
  }
  public static void main(String[] args) {
    new IconExample();
  }
}
