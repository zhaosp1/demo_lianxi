package com.example.springboot.repository.util.sql;

import javax.sql.RowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class RowSetUtil {
  public static RowSet getRowSet() throws Exception{
    JdbcDTO jdbcDTO=JdbcDTO.getDefaultConfig("mysql5");
    jdbcDTO.setUrl("jdbc:mysql://127.0.0.1:3306/battle?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&charset=utf-8");
    Class.forName(jdbcDTO.getDriverName());
    JdbcRowSet rowSet= RowSetProvider.newFactory().createJdbcRowSet();
    rowSet.setUrl(jdbcDTO.getUrl());
    rowSet.setUsername(jdbcDTO.getUserName());
    rowSet.setPassword(jdbcDTO.getPassWord());
    return rowSet;
  }

  public static void main(String[] args) throws Exception {
    JdbcDTO jdbcDTO = JdbcDTO.getDefaultConfig("mysql5");
    jdbcDTO.setUrl(
      "jdbc:mysql://127.0.0.1:3306/battle?useUnicode=true&characterEncoding=utf8");
    try(RowSet rowSet=getRowSet()) {
      rowSet.setCommand("select * from user");
      rowSet.execute();

      //移动光标，获取记录
      while (rowSet.next()) {
        System.out.print("编号: " + rowSet.getInt(1)+"\t");
        System.out.print("名称: " + rowSet.getString(2)+"\t");
//        System.out.print("密码: " + rowSet.getString(3));
        System.out.println();
      }

    }catch (Exception e){
      e.printStackTrace();
    }

        Connection conn = JdbcUtil.getConnection(jdbcDTO.getDriverName(), jdbcDTO.getUrl(), jdbcDTO.getUserName(),
      jdbcDTO.getPassWord());
//    JdbcUtil.excute(conn,"insert into user(id,name,desc) values(2,\"tom\")");
    PreparedStatement pst=conn.prepareStatement("insert into user(name,msg) values(?,?)");
    pst.setString(1, "测试呀管理萨夫卡是");
    pst.setString(2, "测试呀管理萨夫卡是");
    pst.execute();


  }
}
