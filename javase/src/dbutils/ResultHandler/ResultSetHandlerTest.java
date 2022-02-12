package dbutils.ResultHandler;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.*;
import java.util.Arrays;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/27 22:27
 */
public class ResultSetHandlerTest {
  // 驱动程序
  static final String JDBC_DRIVER = "com.mysql.cj.util.jdbc.Driver";
  // URL连接
  static final String DB_URL = "util.jdbc:mysql://localhost:3306/util.test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";

  //数据库信息
  static final String USER = "root";
  static final String PASS = "20133073";

  public static void main(String[] args) throws Exception{
    Connection conn = null;

    QueryRunner queryRunner = new QueryRunner();

    DbUtils.loadDriver(JDBC_DRIVER);

    conn = DriverManager.getConnection(DB_URL, USER, PASS);

    ResultSetHandler<Object[]> handler = new ResultSetHandler<Object[]>() {
      public Object[] handle(ResultSet rs) throws SQLException {
        if (!rs.next()) {
          return null;
        }
        ResultSetMetaData meta = rs.getMetaData();
        int cols = meta.getColumnCount();
        Object[] result = new Object[cols];

        for (int i = 0; i < cols; i++) {
          result[i] = rs.getObject(i + 1);
        }
        return result;
      }
    };

    try {
      Object[] result  = queryRunner.query(conn, "SELECT * FROM customer WHERE name=?",
              handler, "张三");
      System.out.print("结果是: " + Arrays.toString(result));
    } finally {
      DbUtils.close(conn);
    }
  }
}
