package com.example.springboot.service;

import com.example.springboot.component.pojo.Person;

public interface PersonService {
    public Person selectUser(int id);
    public void addUser(Person person);
}
