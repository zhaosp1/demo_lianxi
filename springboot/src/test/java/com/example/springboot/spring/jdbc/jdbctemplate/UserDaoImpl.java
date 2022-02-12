package com.example.springboot.spring.jdbc.jdbctemplate;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * @author: zhaosp1
 * @description: 测试
 * @version: 1.0
 * @createDate: 2021/09/13 20:15
 */
public class UserDaoImpl extends JdbcDaoSupport implements UserDao{
    @Override
    public void update(int id) {
        this.getJdbcTemplate().execute("update user set name='ceshihaha' where id=2");
    }

    @Override
    public List<User> findAll() {
        return this.getJdbcTemplate().query("select * from user",new UserRowMapper());
    }

    @Override
    public void addUser() {
        this.getJdbcTemplate().update("insert into user(name) values('haha123')");
    }

    @Override
    public void deleteUser(int id) {
        this.getJdbcTemplate().update("delete from user where id="+id);
    }
}
