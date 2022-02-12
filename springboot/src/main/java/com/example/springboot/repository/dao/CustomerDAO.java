package com.example.springboot.repository.dao;

import com.example.springboot.component.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> findAll();
}
