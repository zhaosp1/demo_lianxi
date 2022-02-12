package dbutils.ResultHandler;


import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class ArrayListHandlerTest {
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

    try {
      List<Object[]> result = queryRunner.query(conn, "SELECT * FROM customer"
              , new ArrayListHandler());
      for (Object[] objects : result) {
        System.out.println(Arrays.toString(objects));
      }
    } finally {
      DbUtils.close(conn);
    }
  }
}