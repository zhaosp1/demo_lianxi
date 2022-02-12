package jsp.yidian.dao.impl;


import jsp.yidian.bean.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 一点教程网 - http://www.yiidian.com
 */
public class UserDao {

  public static Connection getConnection(){
    Connection con=null;
    try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      con= DriverManager.getConnection("util.jdbc:mysql://127.0.0.1:3306/util.test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8","root","20133073");
    }catch(Exception e){System.out.println(e);}
    return con;
  }

  public static boolean login(User user){
    boolean status=false;
    try{
      Connection con=getConnection();

      PreparedStatement ps=con.prepareStatement(
              "select * from t_user where username=? and password=?");
      ps.setString(1,user.getUsername());
      ps.setString(2,user.getPassword());

      ResultSet rs=ps.executeQuery();
      status=rs.next();

    }catch(Exception e){

    }
    return status;

  }

  public static int register(User user){
    int status=0;
    try{
      Connection con=getConnection();
      PreparedStatement ps=con.prepareStatement(
              "insert into t_user(username,password) values(?,?)");
      ps.setString(1,user.getUsername());
      ps.setString(2,user.getPassword());
      status=ps.executeUpdate();
    }catch(Exception e){
      System.out.println(e);
    }
    return status;
  }
}