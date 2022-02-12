package com.example.springboot.repository.bo.impl;


import com.example.springboot.repository.bo.PersonBO;
import com.example.springboot.repository.dao.PersonDAO;
import com.example.springboot.component.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/7 0:11
 */
public class PersonBOImpl implements PersonBO {
  @Autowired
  private JdbcTemplate jdbcTemplate;


  public Person getPersonById(Integer id) {
    List<Person> list = jdbcTemplate.query("select * from person where id = ?", new Object[]{id}, new BeanPropertyRowMapper(Person.class));
    if(list!=null && list.size()>0){
      return list.get(0);
    }else{
      return null;
    }
  }


  public List<Person> getPersonList() {
    List<Person> list = jdbcTemplate.query("select * from person", new Object[]{}, new BeanPropertyRowMapper(Person.class));
    if(list!=null && list.size()>0){
      return list;
    }else{
      return null;
    }
  }


  public int add(Person person) {
    return jdbcTemplate.update("insert into person(username, age, ctm) values(?, ?, ?)",
            person.getId(),person.getName(), new Date());
  }


  public int update(Integer id, Person person) {
    return jdbcTemplate.update("UPDATE tb_user SET username = ? , age = ? WHERE id=?",
            person.getId(),person.getName(), id);
  }


  public int delete(Integer id) {
    return jdbcTemplate.update("DELETE from person where id = ? ",id);
  }
}
