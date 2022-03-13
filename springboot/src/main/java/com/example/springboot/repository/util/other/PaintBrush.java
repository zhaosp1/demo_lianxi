package com.example.springboot.repository.util.other;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 画笔的初始用
 *
 * @author M_WBCG
 *
 */
public class PaintBrush extends JFrame implements MouseListener {
  // 画笔初始化
  Graphics g;
  // 坐标的起点和终点的初始化
  int x1, y1, x2, y2;

  public PaintBrush() {
    // TODO Auto-generated constructor stub
    // 创建获得画笔的面板
    JPanel drawPanel = new JPanel();
    // 给窗体添加面板
    add(drawPanel);
    setTitle("画笔");
    setSize(500, 500);
    setVisible(true);
    // 画笔获取要在可见之后,设置成全局属性
    g = drawPanel.getGraphics();
    drawPanel.addMouseListener(this);
  }

  public static void main(String[] args) {
    new PaintBrush();
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mousePressed(MouseEvent e) {
    // TODO Auto-generated method stub
    x1 = e.getX();
    y1 = e.getY();
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub
    x2 = e.getX();
    y2 = e.getY();
    g.drawLine(x1, y1, x2, y2);
    x1 = x2 = y1 = y2 = 0;
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub

  }

}