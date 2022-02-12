package com.example.springboot.spring.ioc.example02;


import com.example.springboot.spring.ioc.common.BeanFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring容器的三种对象注入方式——接口注入、构造方法注入、set方法注入
 * spring的配置文件用于指定实例化对象的类（配置文件需要与配置的类命名相对应）
 */
public class Main {
    //构造方法注入（需要对应类存在相应的构造方法）
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/example/springboot/spring/ioc/example02/spring-config.xml");
        CustomerService customerService = (CustomerService) context.getBean("customerService1");
        customerService.save();
    }

    //setter方法注入（需要对应类存在相应的setter方法）
    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/example/springboot/spring/ioc/example02/spring-config.xml");
        CustomerService customerService = (CustomerService) context.getBean("customerService2");
        customerService.save();
    }

    //注解方式注入（需要在指定的配置文件中指定扫描的包路径）
    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/example/springboot/spring/ioc/example02/spring-config.xml");
        BeanFactory beanFactory = (BeanFactory) context.getBean("beanFactory");
        beanFactory.show();
    }
}
