//package com.example.springboot.controller;
//
//
//import com.example.springboot.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * TODO
// *
// * @author zhaosp1
// * @version 1.0
// * @date 2021/7/6 22:59
// */
//
////注意以下restful风格访问接口编写
//@Controller
//@RequestMapping("/user")
//public class UserController {
//  @Autowired
//  private UserService userService;
//
//  @RequestMapping("/hello/{id}")
//  @ResponseBody
//  public String selectUser (@PathVariable int id){
//    return userService.selectUser(id).toString();
//  }
//public static void main(String[] args) {
//
//}
//}
