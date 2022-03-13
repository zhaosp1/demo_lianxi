package com.example.springboot.repository.util.sql;

import cn.hutool.core.io.file.FileReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqlGenerate {

  /**
   * 生成select语句
   * @param tableName
   * @param colnums
   * @return
   */
  public static String generateSelect(String tableName, String... colnums) {
    StringBuilder sb = new StringBuilder();
    sb.append("select ");
    for (int i = 0; i < colnums.length; i++) {
      sb.append(colnums[i]);
      if (i < colnums.length - 1) {
        sb.append(",");
      }
    }
    sb.append(" from ").append(tableName).append(";");
    return sb.toString();
  }


  /**
   * 生成alter语句
   * @param tableName
   * @param colnums
   * @return
   */
  public static String generateAlter(String tableName, String... colnums) {
    StringBuilder sb = new StringBuilder();
    sb.append("alter table ").append(tableName).append(" add (");
    for (int i = 0; i < colnums.length; i++) {
      sb.append(colnums[i]).append(" varchar(20)");
      if (i < colnums.length - 1) {
        sb.append(",");
      }
    }
    sb.append(");");
    return sb.toString();
  }

  /**
   * 生成select语句，默认做别名转换
   * @param tableName
   * @param colnums
   * @return
   */
  public static String generateSelectForDefaultAlias(String tableName, String... colnums) {
    StringBuilder sb = new StringBuilder();
    sb.append("select ");
    for (int i = 0; i < colnums.length; i+=2) {
      sb.append("b."+colnums[i]).append(" as ").append(colnums[i+1].toLowerCase());
      if (i < colnums.length - 1) {
        sb.append(",\n\t");
      }
    }
    sb.append(" from ").append(tableName).append(";");
    return sb.toString();
  }



  /**
   * 生成alter语句
   * @param tableName
   * @param list
   * @return
   */
  public static String generateAlter(String tableName, List<Map> list) {
    StringBuilder sb = new StringBuilder();
    StringBuilder commont=new StringBuilder();
    sb.append("alter table ").append(tableName).append(" add (\n");
    for (int i = 0; i < list.size(); i++) {
      Map<String,String> map=list.get(i);
      sb.append("\t"+map.get("name")).append(" varchar("+map.get("length")+")");
      if (i < list.size() - 1) {
        sb.append(",\n");
      }
      commont.append("comment on column "+tableName+"."+map.get("name")+" is \'"+map.get("comment")+"\';\n");
    }
    sb.append(");\n");
    return sb.toString()+commont.toString();
  }

  /**
   * 生成create语句
   * @param tableName
   * @param list
   * @return
   */
  public static String generateCreate(String tableName, List<Map> list) {
    StringBuilder sb = new StringBuilder();
    sb.append("create table ").append(tableName).append("(\n");
    StringBuilder comment=new StringBuilder();
    for (int i = 0; i < list.size(); i++) {
      Map<String,String> map=list.get(i);
      sb.append("  "+map.get("name")).append(" varchar("+map.get("length")+")");
      comment.append("comment on column "+tableName+"."+map.get("name")+" is \'"+map.get("comment")+"\';\n");
      if (i < list.size() - 1) {
        sb.append(",\n");
      }
    }
    sb.append("\n);\n");
    return sb.toString()+comment.toString();
  }

  /**
   * 生成insert语句
   * @param sql
   * @return
   */
  public static String generateInsert(String sql) {
    StringBuilder sb = new StringBuilder();
    return sb.toString();
  }

  public static void main(String[] args) {
//    String[] temp = new String[] {
//      "smrts_pay_plan","p25","p26","p27","p28","p29","p30"
//    };
    String[] temp=new FileReader("C:\\Users\\alice\\Desktop\\5702.txt").readString().split("\\s+");
    List<Map> list=new ArrayList<>();
    for(int i=0;i<temp.length;i+=5){
      Map map=new HashMap();
      map.put("name",temp[i+2]);
      map.put("length",temp[i+4]);
      map.put("comment",temp[i]);
      list.add(map);
    }
    System.out.println(generateAlter( "ebank_core_tra_flow_2022",list));
//    List list=new LinkedList();
//    list.addAll(null);
//    for(Object s:list){
//      System.out.println(s.toString());
//    }
  }
}
