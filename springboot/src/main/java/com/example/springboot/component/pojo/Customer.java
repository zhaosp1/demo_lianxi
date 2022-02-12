package com.example.springboot.component.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * 实体类
 * 一点教程网 - www.yiidian.com
 */

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Customer implements Serializable {
  private Integer id;
  private String name;
  private String gender;
  private String telephone;

  @Override
  public String toString() {
    return "Customer{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", gender='" + gender + '\'' +
            ", telephone='" + telephone + '\'' +
            '}';
  }
}