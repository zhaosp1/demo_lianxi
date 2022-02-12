package com.example.springboot.spring.jdbc.jdbctemplate;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: zhaosp1
 * @description: 测试
 * @version: 1.0
 * @createDate: 2021/09/13 20:28
 */
public class Demo {
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/example/springboot/spring/jdbc/jdbctemplate/spring-config.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.findAll().forEach(user -> {
            System.out.println(user);
        });
//        userDao.deleteUser(2);
//        userDao.update(3);
//        userDao.addUser();
    }
}
