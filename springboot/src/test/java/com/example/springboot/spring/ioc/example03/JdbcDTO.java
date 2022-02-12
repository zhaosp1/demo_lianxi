package com.example.springboot.spring.ioc.example03;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author http://www.yiidian.com
 */
@Component(value = "jdbcDTO")
@Data
public class JdbcDTO {
    //2Value注入普通数据
    @Value("${url}")
    private String url;
    @Value("${driver}")
    private String driver;
    @Value("${username}")
    private String user;
    @Value("${password}")
    private String password;

    @Override
    public String toString() {
        return "CustomerDaoImpl [\njdbcUrl=" + url + "\ndriverClass="
                + driver + "\nuser=" + user + "\npassword=" + password
                + "\n]";
    }
}