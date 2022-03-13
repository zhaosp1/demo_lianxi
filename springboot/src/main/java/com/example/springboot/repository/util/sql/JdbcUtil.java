package com.example.springboot.repository.util.sql;

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
public class JdbcUtil {
  private static Logger log=Logger.getLogger(JdbcUtil.class.getName());


  public static Connection getConnection() throws Exception{
    com.example.spirit.function.jdbc.JdbcDTO jdbcDTO= com.example.spirit.function.jdbc.JdbcDTO.getDefaultConfig("mysql5");
    Class.forName(jdbcDTO.getDriverName());
    Connection conn=DriverManager.getConnection(jdbcDTO.getUrl(),jdbcDTO.getUserName(),jdbcDTO.getPassWord());
    log.info("建立sql连接");
    return conn;
  }

  public static Connection getConnection(String driver,String url,String user,String pass) throws Exception{
    Class.forName(driver);
    Connection conn=DriverManager.getConnection(url,user,pass);
    log.info("建立sql连接");
    return conn;
  }

  public static Object excute(Connection conn,String sql) throws Exception{
    Object o=null;
    if(sql.toLowerCase().trim().indexOf("select")==0){
      o=excuteSql(conn,sql );
    }else{
      o=excuteUpdate(conn,sql);
    }
    return o;
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

  public static boolean excuteUpdate(Connection conn,String sql) throws Exception{
    Statement st=conn.createStatement();
    return st.execute(sql);
  }

  public static void batchSql(Connection conn,List<String> list) throws Exception{
    final Statement pst=conn.createStatement();
    list.stream().forEach(a-> {
      try {
        pst.addBatch(a);
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    });
    pst.executeBatch();
  }

  public static void output(List list) throws Exception{
    System.out.println();
    for(int i=0;i<list.size();i++){
      List<String> temp=(List<String>)list.get(i);
      for(String s:temp){
          System.out.printf("%-32s\t",s);
      }
      System.out.println();
    }
  }

  public static void main(String[] args) throws Exception{
    Connection conn=getConnection();
    List list=null;
    try{
      list=(List)excute(conn,"select * from user");
    }catch (Exception e){
      System.out.println(e.getMessage());
    }

    output(list);
    if (conn!=null)conn=null;
  }
}
