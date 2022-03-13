package com.example.springboot.repository.util.other;

import java.util.UUID;

/**
 * 逐渐生成器
 */
public class UUIDUtil {
  /**
   * 通过日期获取
   * @param type
   * @return
   */
  public static String getUUIDByTime(String... type){
    if(type.length==0||"mill".equals(type[0])){
      long uuid=System.currentTimeMillis();
      return String.valueOf(uuid);
    }
    if("nano".equals(type[0])){
      long uuid=System.nanoTime();
      return String.valueOf(uuid);
    }

    return "";
  }

  /**
   * 默认主键获取
   * @return
   */
  public static String getUUIDByDefault(){
    UUID uuid = UUID.randomUUID();
    return "{"+uuid.toString()+"}";
  }

  /**
   * 随机数获取
   * @return
   */
  public static String getUUIDByRandom(){
    UUID uuid = UUID.randomUUID();
    return String.valueOf(uuid);
  }

  public static String generate() {
    UUID uuid = UUID.randomUUID();
    String id = uuid.toString();
    id = "{" + id + "}";
    return id.toUpperCase();
  }

  public static void main(String[] args) {
    System.out.println(getUUIDByTime("mill"));
    System.out.println(getUUIDByTime("nano"));
    System.out.println(getUUIDByTime());
    System.out.println(getUUIDByRandom());
    System.out.println(getUUIDByDefault());
  }
}
