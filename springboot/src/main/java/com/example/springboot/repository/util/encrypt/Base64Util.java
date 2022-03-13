package com.example.springboot.repository.util.encrypt;

import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Base64Util {

  public static void main(String[] args) {
    try {
      String temp=Base64FileToBase64("C:\\Users\\demo\\Desktop\\jhon777.pdf","utf-8");
      System.out.println(temp);
      decoderBase64File(temp,"C:\\Users\\demo\\Desktop\\jhon888.pdf");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //将文件字节流编码为base64字符串
  public static String Base64FileToBase64(String path,String charsetName) throws Exception {
    return new String(encodeBase64File(path),charsetName);
  }
  /**
   * <p>将文件转成base64 字符串</p>
   * @param path 文件路径
   * @return
   * @throws Exception
   */
  public static byte[] encodeBase64File(String path) throws Exception {
    File  file = new File(path);
    FileInputStream inputFile = new FileInputStream(file);
    byte[] buffer = new byte[(int)file.length()];
    inputFile.read(buffer);
    inputFile.close();
    return new Base64().encode(buffer);
  }
  /**
   * <p>将base64字符解码保存文件</p>
   * @param base64Code
   * @param targetPath
   * @throws Exception
   */
  public static void decoderBase64File(String base64Code,String targetPath) throws Exception {
    byte[] buffer = new Base64().decodeBase64(base64Code);
    FileOutputStream out = new FileOutputStream(targetPath);
    out.write(buffer);
    out.close();
  }
  /**
   * <p>将base64字符保存文本文件</p>
   * @param base64Code
   * @param targetPath
   * @throws Exception
   */
  public static void base64toFile(String base64Code,String targetPath) throws Exception {
    byte[] buffer = base64Code.getBytes();
    FileOutputStream out = new FileOutputStream(targetPath);
    out.write(buffer);
    out.close();
  }

}
