package com.example.springboot.repository.util.file;

import java.io.*;

public class SerialTest{
  //对象序列化
  public static void write(Student s,String file) throws IOException {
    FileOutputStream fout=new FileOutputStream(file);
    ObjectOutputStream out=new ObjectOutputStream(fout);

    out.writeObject(s);
    out.flush();
    out.close();
    System.out.println("序列化完成");
  }

  //对象反序列化
  public static Student read(String file) throws IOException, ClassNotFoundException {
    FileInputStream fin=new FileInputStream(file);
    ObjectInputStream in=new ObjectInputStream(fin);

    Student s=(Student)in.readObject();
    System.out.println("反序列化完成");
    in.close();

    return s;
  }
  public static void main(String[] args) throws Exception{
    Student s=new Student(123,"alice");
    String file="C:\\Users\\demo\\Desktop\\object.txt";
    write(s,file);

    Student o=read(file);
    System.out.println(o.getId()+"\t"+o.getName());
  }
}

class Student implements Serializable {
  private int id;
  private String name;

  public Student(int id,String name){
    this.id=id;
    this.name=name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
