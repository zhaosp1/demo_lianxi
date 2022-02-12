package com.example.springboot.spring.aop;

import org.junit.Test;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/24 21:55
 */

public class AOPTest {
    @Test
    public void testJdk() {
        CustomerService customerService = new CustomerServiceImpl();
        CustomerService proxy = (CustomerService) JdkProxy.getProxy(customerService);
        proxy.save();
        proxy.update();
    }

    @Test
    public void testCglib() {
        CustomerService customerService = new CustomerServiceImpl();
        CustomerService proxy = (CustomerService) CglibProxy.getProxy(customerService);
        proxy.save();
        proxy.update();
    }

    public static void main(String[] args) {
        new AOPTest().testJdk();
        new AOPTest().testCglib();
    }
}
