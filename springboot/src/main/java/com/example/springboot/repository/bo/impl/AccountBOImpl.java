package com.example.springboot.repository.bo.impl;


import com.example.springboot.repository.bo.AccountBO;
import com.example.springboot.repository.dao.AccountDAO;
import com.example.springboot.repository.dao.TradeDAO;
import com.example.springboot.component.pojo.Account;

import java.math.BigDecimal;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/5 19:59
 */
public class AccountBOImpl implements AccountBO {

  public BigDecimal getBalance(Account account) {
    return new BigDecimal(account.getBalance());
  }


  public boolean addMoney(Account account, String money) {
    try{
      BigDecimal bal=getBalance(account).add(new BigDecimal(money));
      account.setBalance(bal.toString());
    }catch (Exception e){
      return false;
    }
    return true;
  }


  public boolean subMoney(Account account, String money) {
    try{
      BigDecimal bal=getBalance(account).subtract(new BigDecimal(money));
      if (bal.compareTo(new BigDecimal(0))>0){
        account.setBalance(bal.toString());
        return true;
      }
    }catch (Exception e){
      return false;
    }
    return false;
  }


  public void trade(Account pay, Account payee, String money) {
    try{
      if(subMoney(pay,money)){
        addMoney(payee,money);
      }else {
        throw new Exception("扣额失败");
      }
    }catch (Exception e){
      System.out.println("交易失败");
    }
  }
}
