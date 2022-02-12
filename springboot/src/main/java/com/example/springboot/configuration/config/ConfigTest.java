package com.example.springboot.configuration.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/10 13:44
 */
@Component
@ConfigurationProperties(prefix = "user")
public class ConfigTest {
  private String name;
  private int age;
  private List<String> fruits;
  private Map<String,String> user;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public List<String> getFruits() {
    return fruits;
  }

  public void setList(List<String> fruits) {
    this.fruits = fruits;
  }

  public Map<String, String> getUser() {
    return user;
  }

  public void setMap(Map<String, String> user) {
    this.user = user;
  }
}
