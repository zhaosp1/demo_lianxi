package com.example.springboot.spring.ioc.example03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

/**
 * @author http://www.yiidian.com
 *
 */
@Configuration
@ComponentScan(basePackages={"com.example.springboot.spring.ioc.example03"}) //basePackages：可以放置一个或多个包扫描范围
@PropertySource(value= "classpath:com/example/springboot/spring/ioc/example03/jdbc.properties")
@Import(TestConfig.class)
public class SpringConfig {
  @Value("${test}")
  private String test;
  @Bean(name="jdbcDTO")
  public JdbcDTO getJdbcDTO(){
    return new JdbcDTO();
  }
  @Bean
  public CustomerDao getCustom(){
    System.out.println(test);
    return new CustomerDaoImpl();
  }
}