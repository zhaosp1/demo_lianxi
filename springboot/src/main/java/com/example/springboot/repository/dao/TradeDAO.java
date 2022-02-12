package com.example.springboot.repository.dao;


import com.example.springboot.component.pojo.Account;

public interface TradeDAO {
  void trade(Account pay, Account payee, String money);
}
