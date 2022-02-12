package com.example.springboot.repository.util;

import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/6 20:32
 */
public class MysqlConn {
  private static Logger log=Logger.getLogger(MysqlConn.class.getName());
  private static String driver="com.mysql.cj.util.jdbc.Driver";
  private static String url="util.jdbc:mysql://localhost:3306/temp?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
  private static String user="root";
  private static String pass="20133073";
  public static Connection getConnection() throws Exception{
    Class.forName(driver);
    Connection conn=DriverManager.getConnection(url,user,pass);
    log.info("建立sql连接");
    return conn;
  }

  public static List excuteSql(Connection conn,String sql) throws Exception{
    Statement st=conn.createStatement();
    ResultSet rs=st.executeQuery(sql);

    List ll=new ArrayList();
    ResultSetMetaData meta=rs.getMetaData();
    List list=new ArrayList();
    for(int i=0;i<meta.getColumnCount();i++)list.add(meta.getColumnName(i+1));
    ll.add(list);
    while(rs.next()){
      List temp=new ArrayList();
      for(int i=0;i<meta.getColumnCount();i++)temp.add(rs.getString(i+1));
      ll.add(temp);

    }
    return ll;
  }

  public static boolean excute(Connection conn,String sql) throws Exception{
    Statement st=conn.createStatement();
    return st.execute(sql);
  }
  public static void output(List list) throws Exception{
    System.out.println();
    for(int i=0;i<list.size();i++){
      List<String> temp=(List<String>)list.get(i);
      for(String s:temp){
        System.out.print(s+"\t");
      }
      System.out.println();
    }
  }
  public static void main(String[] args) throws Exception{
    Connection conn=getConnection();
    List list=excuteSql(conn,"select * from student");
//    excute(conn,"insert into student(username) values(\"haha\")");
//    excute(conn,"update student set username=\"temp\" where id=3");
//    System.out.println("插入成功");
    output(list);
    if (conn!=null)conn=null;


  }

  //多线程测试死锁
  public static void test2() throws Exception{
    new Thread(new Runnable() {
      @SneakyThrows
      @Override
      public void run() {
        Connection conn=getConnection();
        conn.setAutoCommit(false);
        excute(conn,"update student set username=\"test52\" where id=5");
        Thread.sleep(1000);
        excute(conn,"update student set username=\"test62\" where id=6");
        conn.commit();
        if (conn!=null)conn=null;
      }
    }).start();
    new Thread(new Runnable() {
      @SneakyThrows
      @Override
      public void run() {
        Connection conn=getConnection();
        conn.setAutoCommit(false);
        excute(conn,"update student set username=\"test62\" where id=6");
        Thread.sleep(1000);
        excute(conn,"update student set username=\"test52\" where id=5");
        conn.commit();
        if (conn!=null)conn=null;
      }
    }).start();
  }

  //多线程修改测试
  public static void test1() throws Exception{
    new Thread(new Runnable() {
      @SneakyThrows
      @Override
      public void run() {
        Connection conn=getConnection();
        conn.setAutoCommit(false);
        excute(conn,"update student set username=\"test52\" where id=5");
        Thread.sleep(1000);
        conn.commit();
        if (conn!=null)conn=null;
      }
    }).start();
    new Thread(new Runnable() {
      @SneakyThrows
      @Override
      public void run() {
        Connection conn=getConnection();
        conn.setAutoCommit(false);
        excute(conn,"update student set username=\"test62\" where id=6");
        Thread.sleep(1000);
        conn.commit();
        if (conn!=null)conn=null;
      }
    }).start();
    new Thread(new Runnable() {
      @SneakyThrows
      @Override
      public void run() {
        Connection conn=getConnection();
        conn.setAutoCommit(false);
        excute(conn,"update student set username=\"test72\" where id=7");
        Thread.sleep(1000);
        conn.commit();
        if (conn!=null)conn=null;
      }
    }).start();
    new Thread(new Runnable() {
      @SneakyThrows
      @Override
      public void run() {
        Connection conn=getConnection();
        conn.setAutoCommit(false);
        excute(conn,"update student set username=\"test82\" where id=8");
        Thread.sleep(1000);
        conn.commit();
        if (conn!=null)conn=null;
      }
    }).start();
  }
}
