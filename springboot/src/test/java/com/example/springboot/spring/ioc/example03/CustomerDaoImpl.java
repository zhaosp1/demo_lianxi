package com.example.springboot.spring.ioc.example03;

import org.springframework.stereotype.Component;

@Component("customDao")
public class CustomerDaoImpl implements CustomerDao {
  @Override
  public void save() {
    System.out.println("CustomerDaoImpl被成功注入！");
  }
}