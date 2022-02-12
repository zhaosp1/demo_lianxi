package dbutils.ResultHandler;

import dbutils.Customer;
import org.apache.commons.dbutils.AsyncQueryRunner;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
public class BeanListHandlerTest {
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

    ResultSetHandler<List<Customer>> resultHandler = new BeanListHandler<Customer>(Customer.class);

    try {
      List<Customer> custList = queryRunner.query(conn, "SELECT * FROM customer", resultHandler);
      for(Customer customer: custList ) {

        System.out.print("编号: " + customer.getId());
        System.out.print(", 用户名: " + customer.getName());
        System.out.print(", 性别: " + customer.getGender());
        System.out.print(", 联系电话: " + customer.getTelephone());
        System.out.println(", 住址: " + customer.getAddress());
      }
    } finally {
      DbUtils.close(conn);
    }
  }
}
