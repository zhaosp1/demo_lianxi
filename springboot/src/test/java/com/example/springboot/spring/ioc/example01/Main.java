package com.example.springboot.spring.ioc.example01;

import com.example.springboot.spring.ioc.common.BeanFactory;
import com.example.springboot.spring.ioc.common.Custom;
import com.example.springboot.spring.ioc.common.CustomImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 对象的调用方式
 */
public class Main {

    //接口方式调用方法（通过java接口形式调用实例）
    @Test
    public void test1() {
        Custom custom = new CustomImpl();
        custom.save();
    }

    //工厂方式调用方法（自定义工厂类来调用实例）
    @Test
    public void test2(){
        Custom custom = BeanFactory.getBean("custom");
        custom.save();
    }

    //spring容器调用方法（通过spring的IoC容器来调用实例）
    @Test
    public void test3(){
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:com/example/springboot/spring/ioc/example01/spring-config.xml");
        Custom custom=(Custom)context.getBean("custom");
        System.out.println("spring的IoC容器创建");
        custom.save();
    }
}
