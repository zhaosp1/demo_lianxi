package com.example.springboot.hibernate;

import com.example.springboot.component.pojo.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
  public static void main(String[] args) {
    Customer customer = new Customer();
    customer.setName("逗逼");
    customer.setGender("男");
    customer.setTelephone("12345678920");

    //1.读取hibernate.cfg.xml文件
    Configuration cfg = new Configuration().configure("com/example/springboot/hibernate/hibernate-config.xml");

    //2.创建SessionFactory工厂
    SessionFactory factory = cfg.buildSessionFactory();

    //3.创建Session对象
    Session session = factory.openSession();

    //4.开启事务
    Transaction tx = session.beginTransaction();

    //5.执行添加操作
    session.save(customer);

    //6.提交事务
    tx.commit();

    //7.关闭资源
    session.close();
  }
}
