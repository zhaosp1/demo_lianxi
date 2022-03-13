package com.example.springboot.repository.util.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//JDK的动态代理有一个限制,就是使用动态代理的对象必须实现一个或多个接口,如果想代理没有实现接口的类,就可以使用Cglib实现.
public class JdkProxy {
  private Object target;

  public JdkProxy(Object target){
    this.target=target;
  }

  public Object getProxyInstance(){
    return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
      new InvocationHandler() {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
          System.out.println("动态代理——jdk代理类代理");
          System.out.println("开始事务...");
          Object returnValue=method.invoke(target,args);
          System.out.println("结束事务...");
          return returnValue;
        }
      });
  }
}
