package com.example.springboot.spring.jdbc.jdbctemplate;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: zhaosp1
 * @description: ce
 * @version: 1.0
 * @createDate: 2021/09/13 20:48
 */
public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User User = new User();
        User.setId(rs.getInt("id"));
        User.setName(rs.getString("name"));
        User.setBirth(rs.getString("birth"));
        return User;
    }

}