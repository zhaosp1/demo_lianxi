package util.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {

	public static Connection getConnection(String jdbcDriver,String username,String password){
		Connection conn=null;
		try {
			Class.forName(jdbcDriver);
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&characterEncoding=utf-8", username, password);
		} catch (Exception e) {
			System.out.println("jdbc连接异常！");
			if(conn!=null) {
				conn=null;
			}
		}
		return conn;
	}

	public static Connection getConnection(String jdbcDriver) throws ClassNotFoundException, SQLException {
		Class.forName(jdbcDriver);
		Connection conn=DriverManager.getConnection("util.jdbc:sqlite:demo1.db");
		return conn;
	}
}
