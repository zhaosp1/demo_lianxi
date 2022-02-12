package jsp.yidian.dao;

import java.util.List;

public interface StudentDAO {
	
	List query(String sql)  throws Exception;

	void add(String sql)  throws Exception;

	void delete(String sql)  throws Exception;

	void update(String sql)  throws Exception;
}
