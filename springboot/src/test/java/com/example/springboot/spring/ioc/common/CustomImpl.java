package com.example.springboot.spring.ioc.common;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/23 23:18
 */
public class CustomImpl implements Custom {
    public void temp() {
        System.out.println("临时方法");
    }

    @Override
    public void save() {
        System.out.println("测试方法！");
    }

    //初始化方法
    public void init() {
        System.out.println("初始化");
    }
    //销毁方法
    public void destroy() {
        System.out.println("结束");
    }
}
