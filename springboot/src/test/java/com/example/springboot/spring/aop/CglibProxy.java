package com.example.springboot.spring.aop;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/24 22:00
 */
public class CglibProxy {
  public static Object getProxy(final Object target){
    return Enhancer.create(CustomerServiceImpl.class, new MethodInterceptor() {
      @Override
      public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib代理方法，不需要定义代理接口");
        return method.invoke(target,objects);
      }
    });
  }
}
