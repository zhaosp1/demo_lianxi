package com.example.springboot.repository.util.money;

import java.text.DecimalFormat;

/**
 * 人民币格式化输出
 */
public class MoneyUtil {


  public void test(){
    DecimalFormat df = new DecimalFormat("0.00");
    System.out.println(df.format("0.123"));
  }
  public static void main(String[] args) {
//    Scanner scan = new Scanner(System.in);// 创建标注输入流扫描器
//    System.out.println("请输入一个数字：");
//    double number = scan.nextDouble();// 获取用户输入数字
//    System.out.println("该数字用Locale类的以下常量作为格式化对象的构造参数，将获得不同的货币格式：");
//    // 创建格式化对象
//    NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CHINA);
//    // 输出格式化货币格式
//    System.out.println("Locale.CHINA：" + format.format(number));
    DecimalFormat df = new DecimalFormat("0.00");
    System.out.println(df.format(Double.valueOf("20.")));
  }
}
