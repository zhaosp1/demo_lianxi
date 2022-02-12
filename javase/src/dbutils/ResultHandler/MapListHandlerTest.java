package dbutils.ResultHandler;

import org.apache.commons.dbutils.AsyncQueryRunner;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.*;
import java.util.List;
import java.util.Map;
public class MapListHandlerTest {
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
      List<Map<String, Object>> result
              = queryRunner.query(conn, "SELECT * FROM customer", new MapListHandler());
      System.out.println(result);
    } finally {
      DbUtils.close(conn);
    }
  }
}