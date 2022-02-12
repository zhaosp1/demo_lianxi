package com.example.springboot.repository.dao;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/8 0:12
 */
import com.example.springboot.component.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryDAO extends JpaRepository<Category,Integer>{

}