package com.example.springboot.repository.util.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
  private Object target;

  public CglibProxy(Object target){
    this.target=target;
  }

  public Object getProxyInstance(){
    Enhancer en=new Enhancer();
    en.setSuperclass(target.getClass());
    en.setCallback(this);
    return en.create();
  }

  @Override
  public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy)
    throws Throwable {
    System.out.println("动态代理——cglib代理类代理");
    System.out.println("开始事务...");
    Object returnValue=method.invoke(target,args);
    System.out.println("结束事务...");
    return returnValue;
  }
}
