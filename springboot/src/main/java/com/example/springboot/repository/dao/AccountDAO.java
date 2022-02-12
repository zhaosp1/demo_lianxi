package com.example.springboot.repository.dao;



import com.example.springboot.component.pojo.Account;

import java.math.BigDecimal;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/5 19:43
 */
public interface AccountDAO {
  BigDecimal getBalance(Account account);
  boolean addMoney(Account account,String money);
  boolean subMoney(Account account,String money);
}
