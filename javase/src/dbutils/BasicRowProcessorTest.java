package dbutils;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BasicRowProcessorTest extends BeanHandler<Customer>{
  public BasicRowProcessorTest() {
    super(Customer.class, new BasicRowProcessor(new BeanProcessor(mapColumnsToFields())));
  }

  @Override
  public Customer handle(ResultSet rs) throws SQLException {
    Customer customer = super.handle(rs);
    customer.setName("一点教程网："+customer.getName());
    return customer;
  }

  public static Map<String, String> mapColumnsToFields() {
    Map<String, String> columnsToFieldsMap = new HashMap<>();
    /**
     * key：表的列名称
     * value：JavaBean的属性名
     */
    columnsToFieldsMap.put("ID", "id");
    columnsToFieldsMap.put("NAME", "name");
    return columnsToFieldsMap;
  }
}