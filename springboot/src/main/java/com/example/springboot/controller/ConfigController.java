//package com.example.springboot.controller;
//
//import com.example.springboot.configuration.config.ConfigTest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * TODO
// *
// * @author zhaosp1
// * @version 1.0
// * @date 2021/6/27 11:49
// */
//@RestController
//@RequestMapping("config")
//public class ConfigController {
//  @Value("${username}")
//  private String username;
//  @Value("${password}")
//  private String password;
//  @Autowired
//  private ConfigTest configTest;
//
//  @RequestMapping("/test1")
//  public String getConfig1(){
//    return this.username+"\t"+this.password;
//  }
//
//  @RequestMapping("/test2")
//  public Map getConfig2(){
//    Map map=new HashMap();
//    map.put("username",configTest.getName());
//    map.put("age",configTest.getAge());
//    map.put("list",configTest.getFruits());
//    map.put("map",configTest.getUser());
//    return map;
//  }
//}
