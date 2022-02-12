package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/7 23:22
 */
@Controller
public class JspController {
  @RequestMapping("/hello")
  public String hello(Model m) throws Exception {
    m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
//    if(true){
//      throw new Exception("some exception");
//    }
    return "pages/index";
  }
}
