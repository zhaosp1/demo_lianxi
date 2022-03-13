package com.example.springboot.repository.util.proxy;

//真实主题
class RealSubject implements Subject {
  @Override
  public void show() {
    System.out.println("测试输出！");
  }
}
