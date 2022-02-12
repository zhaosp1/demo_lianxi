package com.example.springboot.service;

import com.example.springboot.component.pojo.Customer;

public interface CustomerService {
    public Customer findById(Integer id);
}
