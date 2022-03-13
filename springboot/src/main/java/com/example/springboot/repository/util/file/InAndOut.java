package com.example.springboot.repository.util.file;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;

public class InAndOut {

  //从文件中读取内容
  public static void readFromFile(String file){
    FileReader fin=new FileReader(file,"utf-8");
    String content=fin.readString();
    System.out.println("文件内容为：\n"+content);
  }

  //向文件中写入数据——append是否追加
  public static void writeToFile(String file,String content,boolean append){
    FileWriter fout=new FileWriter(file,"utf-8");
    fout.write(content,append);
  }

  public static void main(String[] args) {
    String file="C:\\Users\\demo\\Desktop\\zh.dat";
    readFromFile(file);
    writeToFile(file,"测试",  true);
  }
}
