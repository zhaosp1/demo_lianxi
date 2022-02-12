package com.example.springboot.service.impl;

import com.example.springboot.repository.dao.PersonMapper;
import com.example.springboot.component.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/6 22:58
 */
@Service
public class PersonServiceImpl {

  @Autowired
  PersonMapper personMapper;
  public Person selectUser(int id) {
    return personMapper.selectUser(id);
  }
  public void addUser(Person person){
    personMapper.add(person);}
}