package com.example.springboot.spring.ioc.example02;


import com.example.springboot.spring.ioc.common.Custom;

public class CustomerServiceImpl implements CustomerService {
  private Custom custom;

  public CustomerServiceImpl(){
  }

  //关键在这里，提供CustomerDao作为参数的构造方法，待会在配置文件进行注入
  public CustomerServiceImpl(Custom custom) {
    super();
    this.custom = custom;
  }
  //关键在这里，提供CustomerDao作为参数的setter方法，待会在配置文件进行注入
  public void setCustom(Custom custom) {
    this.custom = custom;
  }

  @Override
  public void save() {
    custom.save();
  }

}