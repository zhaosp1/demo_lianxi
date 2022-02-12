package com.example.springboot.spring.aop;

public class CustomerServiceImpl implements CustomerService {

  @Override
  public void save() {
    System.out.println("执行save方法");
  }

  @Override
  public void update() {
    System.out.println("执行update方法");
  }

}