package servlet.yidian.dao;


import servlet.yidian.bean.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 一点教程网 - http://www.yiidian.com
 */
public class CustomerDao {
  public static Connection getConnection(){
    Connection con=null;
    try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      con= DriverManager.getConnection("util.jdbc:mysql://127.0.0.1:3306/demo?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8","root","20133073");
    }catch(Exception e){System.out.println(e);}
    return con;
  }


  public static int save(Customer customer){
    int status=0;
    try{
      Connection con=CustomerDao.getConnection();
      PreparedStatement ps=con.prepareStatement(
              "insert into customer(name,gender,telephone,address) values (?,?,?,?)");
      ps.setString(1,customer.getName());
      ps.setString(2,customer.getGender());
      ps.setString(3,customer.getTelephone());
      ps.setString(4,customer.getAddress());

      status=ps.executeUpdate();

      con.close();
    }catch(Exception ex){ex.printStackTrace();}

    return status;
  }
  public static int update(Customer customer){
    int status=0;
    try{
      Connection con=CustomerDao.getConnection();
      PreparedStatement ps=con.prepareStatement(
              "update customer set name=?,gender=?,telephone=?,address=? where id=?");
      ps.setString(1,customer.getName());
      ps.setString(2,customer.getGender());
      ps.setString(3,customer.getTelephone());
      ps.setString(4,customer.getAddress());
      ps.setInt(5,customer.getId());

      status=ps.executeUpdate();

      con.close();
    }catch(Exception ex){ex.printStackTrace();}

    return status;
  }
  public static int delete(int id){
    int status=0;
    try{
      Connection con=CustomerDao.getConnection();
      PreparedStatement ps=con.prepareStatement("delete from customer where id=?");
      ps.setInt(1,id);
      status=ps.executeUpdate();

      con.close();
    }catch(Exception e){e.printStackTrace();}

    return status;
  }
  public static Customer getEmployeeById(int id){
    Customer e=new Customer();

    try{
      Connection con=CustomerDao.getConnection();
      PreparedStatement ps=con.prepareStatement("select * from customer where id=?");
      ps.setInt(1,id);
      ResultSet rs=ps.executeQuery();
      if(rs.next()){
        e.setId(rs.getInt(1));
        e.setName(rs.getString(2));
        e.setGender(rs.getString(3));
        e.setTelephone(rs.getString(4));
        e.setAddress(rs.getString(5));
      }
      con.close();
    }catch(Exception ex){ex.printStackTrace();}

    return e;
  }
  public static List<Customer> getAllEmployees(){
    List<Customer> list=new ArrayList<Customer>();

    try{
      Connection con=CustomerDao.getConnection();
      PreparedStatement ps=con.prepareStatement("select * from customer");
      ResultSet rs=ps.executeQuery();
      while(rs.next()){
        Customer e=new Customer();
        e.setId(rs.getInt(1));
        e.setName(rs.getString(2));
        e.setGender(rs.getString(3));
        e.setTelephone(rs.getString(4));
        e.setAddress(rs.getString(5));
        list.add(e);
      }
      con.close();
    }catch(Exception e){e.printStackTrace();}

    return list;
  }

  public static void main(String[] args) throws SQLException {
    List<Customer> list=getAllEmployees();
//    Connection conn=getConnection();
//    if(conn!=null){
//      System.out.println("连接成功！");
//      conn.close();
//    }
  }
}