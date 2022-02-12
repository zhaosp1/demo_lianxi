package jsp.yidian.dao.impl;


import jsp.yidian.bean.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 一点教程网 - http://www.yiidian.com
 */
public class CustomerDao {

  public static Connection getConnection(){
    Connection con=null;
    try{
      Class.forName("com.mysql.jdbc.Driver");
      con= DriverManager.getConnection("util.jdbc:mysql://127.0.0.1:3306/util.test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8","root","20133073");
    }catch(Exception e){System.out.println(e);}
    return con;
  }
  public static int save(Customer customer){
    int status=0;
    try{
      Connection con=getConnection();
      PreparedStatement ps=con.prepareStatement(
              "insert into customer(name,gender,telephone,address) values(?,?,?,?)");
      ps.setString(1,customer.getName());
      ps.setString(2,customer.getGender());
      ps.setString(3,customer.getTelephone());
      ps.setString(4,customer.getAddress());
      status=ps.executeUpdate();
    }catch(Exception e){System.out.println(e);}
    return status;
  }

  public static int update(Customer customer){
    int status=0;
    try{
      Connection con=getConnection();
      PreparedStatement ps=con.prepareStatement(
              "update customer set name=?,gender=?,telephone=?,address=? where id=?");
      ps.setString(1,customer.getName());
      ps.setString(2,customer.getGender());
      ps.setString(3,customer.getTelephone());
      ps.setString(4,customer.getAddress());
      ps.setInt(5,customer.getId());
      status=ps.executeUpdate();
    }catch(Exception e){System.out.println(e);}
    return status;
  }

  public static int delete(Customer customer){
    int status=0;
    try{
      Connection con=getConnection();
      PreparedStatement ps=con.prepareStatement("delete from customer where id=?");
      ps.setInt(1,customer.getId());
      status=ps.executeUpdate();
    }catch(Exception e){System.out.println(e);}

    return status;
  }
  public static List<Customer> getAllRecords(){
    List<Customer> list=new ArrayList<Customer>();

    try{
      Connection con=getConnection();
      PreparedStatement ps=con.prepareStatement("select * from customer");
      ResultSet rs=ps.executeQuery();
      while(rs.next()){
        Customer customer=new Customer();
        customer.setId(rs.getInt("id"));
        customer.setName(rs.getString("name"));
        customer.setGender(rs.getString("gender"));
        customer.setTelephone(rs.getString("telephone"));
        customer.setAddress(rs.getString("address"));
        list.add(customer);
      }
    }catch(Exception e){
      System.out.println(e);
    }
    return list;
  }
  public static Customer getRecordById(int id){
    Customer customer=null;
    try{
      Connection con=getConnection();
      PreparedStatement ps=con.prepareStatement("select * from customer where id=?");
      ps.setInt(1,id);
      ResultSet rs=ps.executeQuery();
      while(rs.next()){
        customer=new Customer();
        customer.setId(rs.getInt("id"));
        customer.setName(rs.getString("name"));
        customer.setGender(rs.getString("gender"));
        customer.setTelephone(rs.getString("telephone"));
        customer.setAddress(rs.getString("address"));
      }
    }catch(Exception e){
      System.out.println(e);
    }
    return customer;
  }
}