package com.example.struts2;

/**
 *
 * @author 一点教程(yiidian.com)
 *
 */
public class HelloAction {

  public String hello(){
    System.out.println("进入struts2的Action类");
    return "success";
  }
}