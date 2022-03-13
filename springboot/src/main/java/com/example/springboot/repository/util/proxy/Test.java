package com.example.springboot.repository.util.proxy;


public class Test {
  public static void main(String[] args) {
    //静态代理——接口代理
    Subject proxy=new StaticProxy();
    proxy.show();
    System.out.println();

    //动态代理——JDK代理（通过反射机制进行代理）
    Subject subject=new RealSubject();
    Subject proxy1=(Subject)new JdkProxy(subject).getProxyInstance();
    proxy1.show();
    System.out.println();

    //动态代理——Cglib代理（通过反射机制进行代理）
    Subject realSubject=new RealSubject();
    Subject proxy2=(Subject)new CglibProxy(realSubject).getProxyInstance();
    proxy2.show();
  }
}

