package com.example.springboot.repository.util.zip;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtils {
  private int k = 1; // 定义递归次数变量

  private void zip(File inputFile,String zipFileName) throws Exception {
    System.out.println("压缩中...");
    ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
    BufferedOutputStream bo = new BufferedOutputStream(out);
    zip(out, inputFile, inputFile.getName(), bo);
    bo.close();
    out.close(); // 输出流关闭
    System.out.println("压缩完成");
  }

  private void zip(ZipOutputStream out, File f, String base,
    BufferedOutputStream bo) throws Exception { // 方法重载
    if (f.isDirectory()) {
      File[] fl = f.listFiles();
      if (fl.length == 0) {
        out.putNextEntry(new ZipEntry(base + "/")); // 创建zip压缩进入点base
        System.out.println(base + "/");
      }
      for (int i = 0; i < fl.length; i++) {
        zip(out, fl[i], base + "/" + fl[i].getName(), bo); // 递归遍历子文件夹
      }
      System.out.println("第" + k + "次递归");
      k++;
    } else {
      out.putNextEntry(new ZipEntry(base)); // 创建zip压缩进入点base
      System.out.println(base);
      FileInputStream in = new FileInputStream(f);
      BufferedInputStream bi = new BufferedInputStream(in);
      int b;
      while ((b = bi.read()) != -1) {
        bo.write(b); // 将字节流写入当前zip目录
      }
      bi.close();
      in.close(); // 输入流关闭
    }
  }

  public static void unzip() {
    // TODO Auto-generated method stub
    long startTime = System.currentTimeMillis();
    try {
      ZipInputStream Zin = new ZipInputStream(new FileInputStream(
        "F:\\ziptest.zip"));//输入源zip路径
      BufferedInputStream Bin = new BufferedInputStream(Zin);
      String Parent = "F:\\ziptest\\"; //输出路径（文件夹目录）
      File Fout = null;
      ZipEntry entry;
      try {
        while ((entry = Zin.getNextEntry()) != null && !entry.isDirectory()) {
          Fout = new File(Parent, entry.getName());
          if (!Fout.exists()) {
            (new File(Fout.getParent())).mkdirs();
          }
          FileOutputStream out = new FileOutputStream(Fout);
          BufferedOutputStream Bout = new BufferedOutputStream(out);
          int b;
          while ((b = Bin.read()) != -1) {
            Bout.write(b);
          }
          Bout.close();
          out.close();
          System.out.println(Fout + "解压成功");
        }
        Bin.close();
        Zin.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    long endTime = System.currentTimeMillis();
    System.out.println("耗费时间： " + (endTime - startTime) + " ms");
  }
}
