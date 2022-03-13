package com.example.springboot.repository.util.proxy;

/**
 * 静态代理——静态代理是基于接口实现的代理，具体的功能实现是在代理类中进行的，属于编译时代理模式。
 * 缺点是必须通过实现统一接口来代理，静态代理模式属于接口隔离的一种应用。
 */
class StaticProxy implements Subject {
  Subject real=new RealSubject();
  @Override
  public void show() {
    System.out.println("静态代理——接口代理");
    real.show();
  }
}
