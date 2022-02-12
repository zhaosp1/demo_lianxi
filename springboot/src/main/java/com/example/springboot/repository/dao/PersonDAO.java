package com.example.springboot.repository.dao;



import com.example.springboot.component.pojo.Person;

import java.util.List;

public interface PersonDAO {
  Person getPersonById(Integer id);
  public List<Person> getPersonList();
  public int add(Person Person);
  public int update(Integer id, Person Person);
  public int delete(Integer id);
}
