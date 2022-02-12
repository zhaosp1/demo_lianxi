package jsp.yidian.dao.impl;

import util.jdbc.*;
import jsp.yidian.dao.StudentDAO;

import java.util.List;
import java.util.Map;

//实现了业务逻辑与数据操作分离
//将数据操作封装在JdbcTools（封装并不完全，在读取的时候需要注意一下）中，将类信息操作封装在StudentDAO中，StudentDAO关联JdbcTools来实现基本的业务功能
public class StudentImpl implements StudentDAO {
	private JdbcTools JdbcTools;

	@Override
	public List query(String sql) throws Exception {
		List list = (List) JdbcTools.execute(sql).get("result");
		return list;
	}

	@Override
	public void add(String sql) throws Exception {
		JdbcTools.execute(sql);
	}

	@Override
	public void delete(String sql) throws Exception {
		JdbcTools.execute(sql);
	}

	@Override
	public void update(String sql) throws Exception {
		JdbcTools.execute(sql);
	}

	public static void main(String[] args) throws Exception {
		StudentDAO st = new StudentImpl();
//		st.add("insert into student(name,password) values(\"aaaa\",\"333333\")");
		st.delete("delete from student where id>2");
//		st.add("insert into student(name,password) values(\"bbbbb\",\"333333\")");
		List list = st.query("select * from student");
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				Map<String, String> map = (Map<String, String>) list.get(i);
				System.out.println(map);
			}
		}
	}

}
