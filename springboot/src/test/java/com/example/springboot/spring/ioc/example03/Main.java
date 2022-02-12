package com.example.springboot.spring.ioc.example03;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/24 16:39
 */

@ContextConfiguration(classes = SpringConfig.class)
public class Main {

    //配置文件加载配置(需要在spring的配置文件中指定context:property-placeholder的路径信息）
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/example/springboot/spring/ioc/example03/spring-config.xml");
        JdbcDTO jdbcDTO = (JdbcDTO) context.getBean("jdbcDTO");
        System.out.println(jdbcDTO);
    }

    //java类加载配置
    @Test
    public void test2() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        JdbcDTO jdbcDTO = (JdbcDTO) context.getBean("jdbcDTO");
        System.out.println(jdbcDTO.getUrl());
    }

    //java类加载配置（默认组件名为容器名首字母小写，如
    @Test
    public void test3() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        CustomerDao customerDao=(CustomerDao) context.getBean("customDao");
        customerDao.save();
    }
}
