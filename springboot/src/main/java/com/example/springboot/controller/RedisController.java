package com.example.springboot.controller;

import com.example.springboot.component.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/10 21:08
 */
@Controller
@RequestMapping("/redis")
public class RedisController {
  @Autowired
  private RedisTemplate redisTemplate;

  /**
   * 往Redis存入对象
   */
  @RequestMapping("/put")
  @ResponseBody
  public String put(){
    Customer customer = new Customer();
    customer.setId(1);
    customer.setName("小明");
    customer.setGender("男");
    customer.setTelephone("132444455555");
    //调用Redis的API存入数据
    redisTemplate.opsForValue().set("customer",customer);
    return "success";
  }

  /**
   * 从Redis取出对象
   */
  @RequestMapping("/get")
  @ResponseBody
  public Customer get(){
    return (Customer)redisTemplate.opsForValue().get("customer");
  }
}
