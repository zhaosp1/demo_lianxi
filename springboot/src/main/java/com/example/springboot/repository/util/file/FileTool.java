package com.example.springboot.repository.util.file;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class FileTool {
  /**
   * 根据文件名获取父级文件
   *
   * @param fileName
   * @return
   */
  public static String getParent(String fileName) {
    File file = FileUtil.file(fileName);
    return getParent(file);
  }

  /**
   * 根据文件对象获取文件
   *
   * @param file
   * @return
   */
  public static String getParent(File file) {
    if (file.getParent() != null) {
      return file.getParent();
    } else {
      return null;
    }
  }

  /**
   * 根据文件名获取子文件数组
   *
   * @param fileName
   * @return
   */
  public static String[] getChild(String fileName) {
    File file = FileUtil.file(fileName);
    return getChild(file);
  }

  /**
   * 根据文件对象获取子文件数组
   *
   * @param file
   * @return
   */
  public static String[] getChild(File file) {
    if (file.isDirectory()) {
      return file.list();
    } else {
      return null;
    }
  }

  /**
   * 根据文件对象获取子文件数组
   *
   * @param file
   * @return
   */
  public static File[] getChildFile(File file) {
    if (file.isDirectory()) {
      return file.listFiles();
    } else {
      return null;
    }
  }

  public static void main(String[] args) throws Exception {
    String temp = "C:\\Users\\alice\\Desktop";
    File file = FileUtil.file(temp);
    System.out.println("文件名为：" + file.getName() + "的父级菜单为" + getParent(file));
    System.out.printf("文件名为：%s的同级别文件有%d个:%n", file.getName(), getChild(getParent(file)).length);
    Arrays.stream(getChildFile(FileUtil.file(file.getParent()))).forEach(e -> System.out
      .println(
        e.getName() + "\t\t" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(e.lastModified()) + "\t\t" +
          (e.isDirectory() == true ?
            "文件夹" :
            e.getName().substring(e.getName().lastIndexOf('.') + 1) + "文件")));
  }
}
