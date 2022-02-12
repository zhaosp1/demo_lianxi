package dbutils;

import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 一点教程网 - http://www.yiidian.com
 */
public class CustomerHandler extends BeanHandler<Customer>{

  public CustomerHandler() {
    super(Customer.class);
  }

  //该方法可用对Customer对象的内容进行修改
  @Override
  public Customer handle(ResultSet rs) throws SQLException {
    Customer customer = super.handle(rs);
    customer.setName("一点教程网用户："+customer.getName());

    return customer;
  }
}