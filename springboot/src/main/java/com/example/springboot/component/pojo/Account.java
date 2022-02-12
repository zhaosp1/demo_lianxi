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
 * @date 2021/7/5 19:34
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
  private String id;
  private String no;
  private String user;
  private String balance;
}
