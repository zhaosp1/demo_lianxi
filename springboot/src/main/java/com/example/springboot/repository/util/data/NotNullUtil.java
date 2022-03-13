package com.example.springboot.repository.util.data;

import java.util.*;
import java.util.logging.Logger;

/**
 * null是一种特殊的值，它既不属于对象，也不属于数值。
 * null不能使用equals函数（null不继承Object类，所以不能调用该函数），null只能通过==来进行判断比对。
 * 如：String、Integer等类对equals都进行了重写，所以再比较时比较的是取值内容的值，其它自定义类需要对此方法进行重写才能进行对应比较。
 */
public class NotNullUtil {
  private static Logger log= Logger.getLogger(NotNullUtil.class.getName());

  //空字符串的处理
  private static String notNullString(Object object) {
    try{
      if (null == object || "null".equals(object)) {
        return "";
      } else {
        return (String) object;
      }
    }catch (ClassCastException e){
      log.info("类型转换异常"+e.getMessage());
      return null;
    }
  }

  //空map的处理,可以不用返回值
  public static Map<String, Object> nullToEmptyMap(Map<String, Object> map) {
    try{
      Set<String> set = map.keySet();
      if (set != null && !set.isEmpty()) {
        for (String key : set) {
          if (map.get(key) == null) {
            map.put(key, "");
          }
        }
      }
      return map;
    }catch (ClassCastException e){
      log.info("类型转换异常"+e.getMessage());
      return null;
    }
  }

  //list底层是数组，如果执行add方法不会进行覆盖操作，只会再原有的基础上进行添加元素
  public static List nullToEmptyList(List list) {
    try{
      List t=new ArrayList();
      for (int i = 0; i < list.size(); i++) {
        Object object = list.get(i);
        if (null == object || "null".equals(object)) {
          t.add(i, "");
        }else {
          t.add(object);
        }
      }
      return t;
    }catch (ClassCastException e){
      log.info("类型转换异常"+e.getMessage());
      return null;
    }
  }

  public static void outputnull(List list) {
    Iterator iterator=list.iterator();
    while (iterator.hasNext()){
      System.out.println((String)iterator.next());
    }
  }

  public static void main(String[] args) {
    List l = new ArrayList();
    l.add("1");
    l.add("2");
    l.add(null);
    l.add(null);
    l.add("5");

    outputnull(nullToEmptyList(l));

  }

  //测试null调用方法
  public void test() {
    String s = null;
    String s1 = (String) s;
    System.out.println(null == "demo");
    System.out.println(s1.equals(""));//报错，null没有equals方法，null不属于对象
  }
}
