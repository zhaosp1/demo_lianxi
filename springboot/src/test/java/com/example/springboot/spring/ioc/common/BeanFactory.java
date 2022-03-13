package com.example.springboot.spring.ioc.common;

import org.junit.Test;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Properties;

/**
 * TODO
 * 自定义BeanFactory——通过反向代理来实例化指定类
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/23 23:37
 */
@Component("beanFactory")
public class BeanFactory<T> {
  private static Properties properties=new Properties();

  //初始化加载配置文件
  static {
    //以/开头为绝对路径，否则为当前调用类的相对路径
    try(InputStream in=BeanFactory.class.getResourceAsStream("beans.properties");){
      properties.load(in);
    }catch (Exception e){
      e.printStackTrace();
      System.out.println("加载beans.properties配置文件失败");
    }
  }

  /**
   * 通过反向代理获取配置文件中的对象
   * @param name
   * @return
   */
  public static <T> T getBean(String name){
    String className=properties.getProperty(name);
    try{
      return (T)Class.forName(className).newInstance();
    }catch (Exception e){
      e.printStackTrace();
    }
    return null;
  }

  public void show(){
    System.out.println("测试方法！");
  }

  @Test
  public void test(){
    Custom custom=BeanFactory.getBean("custom");
    custom.save();
  }
}
