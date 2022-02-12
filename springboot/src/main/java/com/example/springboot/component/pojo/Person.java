package com.example.springboot.component.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/6 22:56
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
  private Integer id;
  private String name;
//  private Integer age;

  @Override
  public String toString() {
    return "id=" + id +
            ", name='" + name + '\'';
  }
}
