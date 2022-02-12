package com.example.springboot.component.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/10 15:22
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
  @NotNull(message = "用户名不能为空")
  private String name;
  @Min(value = 0)
  @Max(value = 200)
  private int age;
  @Length(min=4,max=10,message="密码必须在4-10位之间")
  private String password;
  @Email(message="邮箱不合法")
  private String email;

  private String id;
}
