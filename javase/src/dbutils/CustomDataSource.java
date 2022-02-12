package dbutils;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.sql.DataSource;
import java.sql.SQLException;

public class CustomDataSource {
  // 驱动程序
  static final String JDBC_DRIVER = "com.mysql.cj.util.jdbc.Driver";
  // URL连接
  static final String DB_URL = "util.jdbc:mysql://localhost:3306/util.test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";

  //数据库信息
  static final String USER = "root";
  static final String PASS = "20133073";

  private static DataSource datasource;
  private static final BasicDataSource basicDataSource;

  static {
    basicDataSource = new BasicDataSource();
    basicDataSource.setDriverClassName(JDBC_DRIVER);
    basicDataSource.setUsername(USER);
    basicDataSource.setPassword(PASS);
    basicDataSource.setUrl(DB_URL);
  }

  public static DataSource getInstance() {
    return basicDataSource;
  }

  public static void main(String[] args) throws SQLException {
    DbUtils.loadDriver(CustomDataSource.JDBC_DRIVER);

    QueryRunner queryRunner = new QueryRunner(CustomDataSource.getInstance());

    ResultSetHandler<Customer> resultHandler = new BeanHandler<Customer>(Customer.class);

    Customer customer = queryRunner.query("SELECT * FROM customer WHERE name = ?",
            resultHandler, "张三");

    System.out.print("编号: " + customer.getId());
    System.out.print(", 用户名: " + customer.getName());
    System.out.print(", 性别: " + customer.getGender());
    System.out.print(", 联系电话: " + customer.getTelephone());
    System.out.println(", 住址: " + customer.getAddress());
  }
}