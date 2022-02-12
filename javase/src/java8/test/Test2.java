package java8.test;

import java8.api.API3;


import java.util.function.BiFunction;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/31 22:49
 */
public class Test2 {
  public static void show1() {
    System.out.println("静态方法引用输出");
  }

  //实例方法
  public void show2() {
    System.out.println("实例方法输出");
  }


  public int add(int a, int b) {
    return a + b;
  }

  public static void main(String[] args) {
    //静态方法引用
    API3 api3 = Test2::show1;
    api3.show();

    //实例方法引用
    API3 api31 = new Test2()::show2;
    api31.show();

    //BiFunction预定义接口的使用
    BiFunction<Integer, Integer, Integer> adder = new Test2()::add;
    int result = adder.apply(10, 20);
    System.out.println(result);


    //构造方法的引用
    Messageable messageable= Message::new;
    messageable.getMessage("hello");
  }

  /**
   * TODO
   *
   * @author zhaosp1
   * @version 1.0
   * @date 2021/8/1 0:08
   */
  static class Message{
    Message(String msg){
      System.out.print(msg);
    }
  }

  /**
   * TODO
   *
   * @author zhaosp1
   * @version 1.0
   * @date 2021/8/1 0:08
   */
  static interface Messageable{
    Message getMessage(String msg);
  }
}

