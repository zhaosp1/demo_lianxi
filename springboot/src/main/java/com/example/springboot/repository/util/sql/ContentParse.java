package com.example.springboot.repository.util.sql;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContentParse {
  //通过hutool工具包来获取
  public static String getContent(String fileName) throws Exception{
    FileReader fin=new FileReader(fileName);
    return fin.readString();
  }


  //通过hutool工具包来获取
  public static void writeContent(String fileName,String content) throws Exception{
    FileWriter fout=new FileWriter(fileName);
    fout.write(content);
  }
  //自定义读取文件内容
  public static String  getTemplateContent(String view) throws Exception{
    File file = new File(view);
    if(!file.exists()){
      return null;
    }
    FileInputStream inputStream = new FileInputStream(file);
    int length = inputStream.available();
    byte bytes[] = new byte[length];
    inputStream.read(bytes);
    inputStream.close();
    String str =new String(bytes, StandardCharsets.UTF_8);
    return str ;
  }

  public static List<Map<String,String>> getMap(String fileName) throws Exception{
    File file = new File(fileName);
    //如果文件存在，则解析文件，并入库
    FileInputStream fis = null;
    InputStreamReader isr = null;
    BufferedReader br = null;
      fis = new FileInputStream(file);
      isr = new InputStreamReader(fis, "UTF-8");
      br = new BufferedReader(isr);
      String line = br.readLine();
      List traFlows = new ArrayList();
      List list=new ArrayList();
      while (!line.equals("end")) {
        String[] detail = line.split("---");
        Map<String,String> map=null;
        if (detail.length>=2){
          map=new HashMap();
          map.put(detail[0],detail[1]);
          System.out.println(detail[0]+"\t\t\t"+detail[1]);
        }else if(detail.length==1&&detail[0]!=null&&!detail[0].equals("")){
          map=new HashMap();
          map.put("标题",detail[0]);
        }
        if(map!=null)list.add(map);
        line = br.readLine();
      }
   return list;
  }

  public static Map fileter(List list){
    Map map=new HashMap();
    Map temp=new HashMap();
    String t=null;
    for(int i=0;i<list.size();i++){
      Map<String,String> o=(Map<String,String>)list.get(i);
      for(String s:o.keySet()){
        if(s.trim().equals("标题")){
          map.put(t,temp);
          t=o.get(s);
          temp=new HashMap();
        }else {
          temp.put(s,o.get(s));
        }
      }
    }

    return map;
  }

  public static List<String> getBatchSql(Map<String,Map<String,String>> map) throws Exception{
    String t="";
    List list=new ArrayList();
    for(String s:map.keySet()){
      if (s!=null) {
        t = s.replaceAll("[-+^:,、#0-9]", "");
      }
      else {
        t = "";
      }
      String sql="";
      Map<String,String> o=map.get(s);
      for(String s1:o.keySet()){
        sql="insert into link(alias,url,label) values(\""+s1+"\",\""+o.get(s1)+"\",\""+t+"\");";
        list.add(sql);
      }
    }
    return list;
  }

  public static void dealBathSql(List<String> list) throws Exception{
//    Connection conn= MysqlConn.getConnection("jdbc:mysql://localhost:3306/bankups?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC","root","20133073");
//    MysqlConn.output((List)MysqlConn.excute(conn,"select * from link"));
////    MysqlConn.batchSql(conn,list);
//    if(conn!=null)conn=null;
//    System.out.println("执行完成");
  }
  public static void main(String[] args) throws Exception{
//    System.out.println(getContent("C:\\Users\\demo\\Desktop\\#常用网址.txt"));
    List list=getMap("C:\\Users\\demo\\Desktop\\常用网址.txt");

    Map map=fileter(list);
    List l=getBatchSql(map);

    StringBuilder sb=new StringBuilder("");
    l.stream().forEach(a-> {
      try {
        sb.append(a+"\n");
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
    dealBathSql(l);
    FileWriter fileWriter=new FileWriter("C:\\Users\\demo\\Desktop\\常用网址555.txt");
    fileWriter.write(sb.toString());

//    l.stream().forEach(a-> {
//      try {
//        fileWriter.write(a+"\n");
//        fileWriter.flush();
//      } catch (IOException e) {
//        e.printStackTrace();
//      }
//    });

//    String t="1、.#hello";
//      String s=t.
//    System.out.println(s);
//    list.stream().forEach(a-> {
//      Map<String,String> t=(Map<String,String>)a;
//      for(String s:t.keySet()){
//        System.out.println(s+"\t"+t.get(s));
//      }
//    });
  }
}
