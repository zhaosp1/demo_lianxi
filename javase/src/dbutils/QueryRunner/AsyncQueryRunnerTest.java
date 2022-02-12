package dbutils.QueryRunner;

import org.apache.commons.dbutils.AsyncQueryRunner;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

//AsyncQueryRunner类借助线程池实现数据的异步操作
public class AsyncQueryRunnerTest {
  // 驱动程序
  static final String JDBC_DRIVER = "com.mysql.cj.util.jdbc.Driver";
  // URL连接
  static final String DB_URL = "util.jdbc:mysql://localhost:3306/util.test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";

  //数据库信息
  static final String USER = "root";
  static final String PASS = "20133073";

  public static void main(String[] args) throws SQLException {
    Connection conn = null;

    AsyncQueryRunner asyncQueryRunner = new AsyncQueryRunner( Executors.newCachedThreadPool());

    DbUtils.loadDriver(JDBC_DRIVER);

    conn = DriverManager.getConnection(DB_URL, USER, PASS);

    Future<Integer> future = null;
    try {

      future = asyncQueryRunner.update(conn,
              "UPDATE customer SET name=? WHERE id=?", "rose",4);

      Integer updatedRecords = future.get(10, TimeUnit.SECONDS);
      System.out.println("更新了 "+updatedRecords + " 条记录！");

    } catch(Exception e){
      System.out.println(e);
    }finally {
      DbUtils.close(conn);
    }
  }
}
