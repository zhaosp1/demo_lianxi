package dbutils.QueryRunner;

import dbutils.Customer;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DbUtils类是对传统jdbc的进一层封装
 * 个人认为，DbUtils步骤与jdbc不同的是对结果集的处理，DbUtils通过queryHandler、resulthandler两种类对连接以及结果集与java对象进行转化
 */
public class QueryRunnerTest {
  // 驱动程序
  static final String JDBC_DRIVER = "com.mysql.cj.util.jdbc.Driver";
  // URL连接
  static final String DB_URL = "util.jdbc:mysql://localhost:3306/util.test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";

  //数据库信息
  static final String USER = "root";
  static final String PASS = "20133073";

  //DbUtils实现查询操作
  public static void queryTest() throws Exception {
    Connection conn = null;
    QueryRunner queryRunner = new QueryRunner();

    //注册驱动
    DbUtils.loadDriver(JDBC_DRIVER);
    //创建连接
    conn = DriverManager.getConnection(DB_URL, USER, PASS);
    //创建ResultSetHandler对象
    ResultSetHandler<Customer> resultSetHandler = new BeanHandler<Customer>(Customer.class);

    try {
      Customer customer = queryRunner.query(conn, "select * from customer where name=?", resultSetHandler, "张三");
      System.out.print("编号: " + customer.getId());
      System.out.print(", 用户名: " + customer.getName());
      System.out.print(", 性别: " + customer.getGender());
      System.out.print(", 联系电话: " + customer.getTelephone());
      System.out.println(", 住址: " + customer.getAddress());
    } finally {
      DbUtils.close(conn);
    }
  }

  //DbUtils实现数据修改
  public static void updateTest() throws Exception{
    Connection conn = null;
    QueryRunner queryRunner = new QueryRunner();

    //注册驱动
    DbUtils.loadDriver(JDBC_DRIVER);
    //创建连接
    conn = DriverManager.getConnection(DB_URL, USER, PASS);

    try {
      int insertRecords = queryRunner.update(conn, "INSERT INTO customer(name,gender,telephone,address)  VALUES (?,?,?,?)",
              "eric", "男", "020-33335555", "广州白云区");
      System.out.println("插入了 " + insertRecords + " 条记录");

      int deleteRecords = queryRunner.update(conn,"delete from customer where name=?", "eric");
      System.out.println("删除了" + deleteRecords + " 条记录");

      int updatedRecords = queryRunner.update(conn,
              "UPDATE customer SET name=? WHERE id=?", "jack", 14);
      System.out.println("更新了 " + updatedRecords + " 条记录");
    } finally {
      DbUtils.close(conn);
    }
  }
  public static void main(String[] args) throws SQLException {

  }
}