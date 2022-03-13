package com.example.springboot.repository.util.sql;

import org.springframework.stereotype.Component;

/**
 * @ClassName TypeOfDB
 * @Description 数据库类型判断（根据平台改造）
 * @Author huangwei
 * @Date 2020/10/31 10:16
 * @Version 1.0
 */
@Component
public class TypeOfDB {

    public static boolean isOracle() {
        return "oracle".equalsIgnoreCase(com.example.alice.yibao.util.ServiceFactory.getPropertiesValue("dbType"));
    }

    public static boolean isMySQL() {
        return "mysql".equalsIgnoreCase(com.example.alice.yibao.util.ServiceFactory.getPropertiesValue("dbType"));
    }

    public static boolean isPostgreSQL() {
        return "postgresql".equalsIgnoreCase(com.example.alice.yibao.util.ServiceFactory.getPropertiesValue("dbType"));
    }

}
