package com.example.springboot.spring.jdbc.jdbctemplate;

import java.util.List;

public interface UserDao {
    void update(int id);
    List<User> findAll();
    void addUser();
    void deleteUser(int id);
}
