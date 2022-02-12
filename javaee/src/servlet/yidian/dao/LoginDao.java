package servlet.yidian.dao;

import util.jdbc.JdbcTools;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/15 0:10
 */
public class LoginDao {
  public static boolean validate(String name,String pass){
    try{
      Connection connection=JdbcTools.getConnection();
      ResultSet rs=connection.createStatement().executeQuery("select password from user where username='"+name+"'");
      String password=null;
      if (rs.next()){
        password=rs.getString(1);
      }
      if(pass.equals(password)||pass==password){
        return true;
      }
    }catch (Exception e){
      System.out.println(e.getMessage());
    }
    return false;
  }
}
