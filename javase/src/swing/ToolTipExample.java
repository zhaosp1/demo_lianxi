package swing;

import javax.swing.*;

/**
 * TOOlTip——用于提示输入
 */
public class ToolTipExample {
  public static void main(String[] args) {
    //1、创建实体框
    JFrame jFrame=new JFrame("ToolTip案例");

    //2、创建基本元素
    JPasswordField password=new JPasswordField();
    password.setBounds(100,100,100,30);
    password.setToolTipText("enter your password！");
    JLabel label=new JLabel("密码：");
    label.setBounds(20,100,80,30);

    //3、关联实体框和基本元素
    jFrame.add(label);
    jFrame.add(password);
    jFrame.setSize(600,400);
    jFrame.setLayout(null);
    jFrame.setVisible(true);
  }
}
