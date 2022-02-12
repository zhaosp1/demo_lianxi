package dbutils.ResultHandler;

import dbutils.Customer;
import dbutils.CustomerHandler;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.*;
public class DIYBeanHandler {
  // 驱动程序
  static final String JDBC_DRIVER = "com.mysql.cj.util.jdbc.Driver";
  // URL连接
  static final String DB_URL = "util.jdbc:mysql://localhost:3306/util.test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";

  //数据库信息
  static final String USER = "root";
  static final String PASS = "20133073";
  public static void main(String[] args) throws SQLException {
    Connection conn = null;

    QueryRunner queryRunner = new QueryRunner();

    DbUtils.loadDriver(JDBC_DRIVER);

    conn = DriverManager.getConnection(DB_URL, USER, PASS);

    CustomerHandler customerHandler = new CustomerHandler();

    try {
      Customer customer = queryRunner.query(conn, "SELECT * FROM customer WHERE name=?",
              customerHandler, "张三");

      System.out.print("编号: " + customer.getId());
      System.out.print(", 用户名: " + customer.getName());
      System.out.print(", 性别: " + customer.getGender());
      System.out.print(", 联系电话: " + customer.getTelephone());
      System.out.println(", 住址: " + customer.getAddress());
    } finally {
      DbUtils.close(conn);
    }
  }
}
