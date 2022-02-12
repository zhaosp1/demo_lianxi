package com.example.springboot.mybatis;

import com.example.springboot.component.pojo.Customer;
import com.example.springboot.repository.dao.CustomerDAO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * mybatis框架调用模式
 * 注：直接调用mybatis类
 */
public class Test {
    public static void main(String[] args)  throws Exception {
        //1.加载mybatis配置
        InputStream in = Resources.getResourceAsStream("com/example/springboot/mybatis/mybatis-config.xml");

        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        //3.创建SqlSession
        SqlSession sqlSession = factory.openSession();

        //4.生成Dao接口代理对象
        CustomerDAO userDao = sqlSession.getMapper(CustomerDAO.class);

        //5.执行Dao接口方法
        List<Customer> list = userDao.findAll();
        for(Customer c:list){
            System.out.println(c);
        }

        //6.释放资源
        sqlSession.close();
        in.close();
    }
}
