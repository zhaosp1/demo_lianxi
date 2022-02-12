package java8.test;

import java8.api.API1;
import java8.api.API2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/31 18:06
 */
public class Test1 {
  public static void showGUI(){
    JTextField tf=new JTextField();
    tf.setBounds(50, 50,150,20);
    JButton b=new JButton("click");
    b.setBounds(80,100,70,30);

    // lambda expression implementing here.
    b.addActionListener(e-> {tf.setText("hello swing");});

    JFrame f=new JFrame();
    f.add(tf);f.add(b);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLayout(null);
    f.setSize(300, 200);
    f.setVisible(true);
  }
  public static void main(String[] args) {
    //函数式接口——无参
    API1 api1=()-> System.out.println("hello,java8!");
    api1.say();

    //函数式接口——泛型、有参、返回值(如果匿名方法体只有一个语句，默认返回该条语句的返回值，否则需要return进行返回）
    API2<Integer> api2=(Integer a,Integer b)->a+b;
    System.out.println(api2.add(1221,13231));

    //函数式编程，利用foreach方法实现list的遍历
    List<String> list=new ArrayList<String>();
    list.add("ankit");
    list.add("mayank");
    list.add("irfan");
    list.add("jai");
    list.forEach(ele-> System.out.println(ele));

    //函数式编程，创建线程
    Runnable runnable=()->{for(int i=0;i<5;i++) System.out.println("hello world!");};
    new Thread(runnable).start();

    //函数式编程，实现compareTo进行排序
    Collections.sort(list,(a1,a2)->a1.compareTo(a2));
    list.stream().forEach(e-> System.out.println(e));

    //函数式编程，过滤器收集数据
    List<Integer> list1=new ArrayList<>();
    list1.add(1);
    list1.add(2);
    list1.add(3);
    list1.add(4);
    list1.add(5);
    Stream<Integer> filtered_data=list1.stream().filter(a->a>3);
    List<Integer> temp=filtered_data.collect(Collectors.toList());
    temp.forEach(ele-> System.out.println(ele));

    //java8实现事件监听器
    showGUI();
  }
}
