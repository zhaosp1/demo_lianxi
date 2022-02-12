package util.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcTools {
	public static Connection getConnection() throws Exception {
		return JdbcConnection.getConnection("com.mysql.cj.jdbc.Driver", "root", "20133073");
	}

	public static Map execute(String sql) throws Exception {
		Connection conn=getConnection();
		if(conn==null) {
			throw new Exception("连接失败");
		}
		Map map=executeSql(conn, sql);
		if(conn!=null) {
			conn.close();
		}
		return map;
	}

	public static Map executeSql(Connection connection, String sql) throws Exception {
		Map map = new HashMap();
		if (sql.trim().lastIndexOf("select") == 0) {
			List list = executeQuery(connection, sql);
			map.put("flag", "1");
			map.put("result", list);
			return map;
		} else {
			executeUpdate(connection, sql);
			map.put("flag", "0");
			return map;
		}
	}

	//sql修改
	public static void executeUpdate(Connection connection, String sql) {
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			System.out.println("操作完成");
		} catch (Exception e) {
			System.out.println("操作失败！");
		}
	}

	//sql查询
	public static List executeQuery(Connection connection, String sql) {
		List<Map> list = new ArrayList<Map>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rSet = statement.executeQuery(sql);
			ResultSetMetaData rsMeta=(ResultSetMetaData) rSet.getMetaData();
			int columnCount=rsMeta.getColumnCount();
			while (rSet.next()) { // 遍历这个数据集
				Map<String, String> map = new HashMap<String, String>();
				for(int index=1;index<=columnCount;index++) {
					map.put(rsMeta.getColumnName(index), rSet.getString(index));
				}
				list.add(map);
			}
			System.out.println("操作完成");
		} catch (Exception e) {
			System.out.println("操作失败！");
			return null;
		}
		return list;
	}

	public static void main(String[] args) throws Exception {
//		Connection conn = JdbcConnection.getConnection("org.sqlite.JDBC");
//		executeSql(conn, "create table student(id int,name varchar(20),age varchar(20))");
//		executeSql(conn, "insert into student values(1,'Gareen','452'),(2,'Yase','12')");
//		List list = (List)executeSql(conn, "select * from student").get("result");
//		for (int i = 0; i < list.size(); i++) {
//			Map<String, String> map = (Map<String, String>) list.get(i);
//			System.out.println(map);
//		}
//		executeSql(conn, "drop table if exists student");
//		if (conn == null) {
//			conn.close();
//		}
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("util.jdbc:mysql://192.168.0.102:3306/demo?useUnicode=true&characterEncoding=utf-8", "root", "123456");
			Statement s=conn.createStatement();
			ResultSet rSet = s.executeQuery("select * from student");
			while (rSet.next()) { // 遍历这个数据集
				Map<String, String> map = new HashMap<String, String>();
				map.put("id", Integer.toString(rSet.getInt(1)));
				map.put("姓名", rSet.getString(2));
				map.put("密码", rSet.getString(3));
				System.out.println(map);
			}
			if(conn==null) {
				System.out.println("连接为空");
			}
		} catch (Exception e) {
			System.out.println("jdbc连接异常！");
		}finally {
			if(conn!=null) {
				conn=null;
			}
		}

	}
}
