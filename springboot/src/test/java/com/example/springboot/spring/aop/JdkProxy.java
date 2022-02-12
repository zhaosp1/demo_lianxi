package com.example.springboot.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/24 21:51
 */
public class JdkProxy {
  public static Object getProxy(final Object target){
    return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk代理需要定义代理接口");
        return method.invoke(target,args);
      }
    });
  }
}
