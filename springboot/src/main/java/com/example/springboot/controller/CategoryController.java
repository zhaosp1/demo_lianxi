package com.example.springboot.controller;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/8 0:13
 */

import com.example.springboot.repository.dao.CategoryDAO;
import com.example.springboot.component.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/category")
public class CategoryController {
  @Autowired
  CategoryDAO categoryDAO;

  @RequestMapping("/list")
  public String listCategory(Model m) throws Exception {
    List<Category> cs=categoryDAO.findAll();
    m.addAttribute("cs", cs);
    return "listCategory";
  }

}