package com.example.springboot.repository.util.office.apache;


import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class PoiWordToHtml {

  public static boolean writeWordFile(String url) {
    boolean w = false;
    String path = "C:\\Users\\demo\\Desktop\\";
    try {
      if (!"".equals(path)) {
        // 检查目录是否存在
        File fileDir = new File(path);
        if (fileDir.exists()) {
          // 生成临时文件名称
          String fileName = "a.doc";
          String content = gethtmlcode(url);
          byte b[] = content.getBytes();
          ByteArrayInputStream bais = new ByteArrayInputStream(b);
          POIFSFileSystem poifs = new POIFSFileSystem();
          DirectoryEntry directory = poifs.getRoot();
          DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);
          FileOutputStream ostream = new FileOutputStream(path+ fileName);
          poifs.writeFilesystem(ostream);
          bais.close();
          ostream.close();
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return w;
  }

  public static String gethtmlcode(String url){
    String str = "";
    try {
      URL u = new URL(url);
      URLConnection uc = u.openConnection();
      InputStream raw = uc.getInputStream();
      InputStream buffer = new BufferedInputStream(raw);
      //
      Reader r = new InputStreamReader(buffer);
      int c;

      while ((c = r.read()) != -1) {
        str += (char)c;
        //System.out.print((char)c);
      } // end while
    }// end try
    // catch (MalformedURLConnection e){
    // System.err.println("cannot connect");
    // }
    catch (IOException e) {
      System.err.println(e);
    }// end catch

    //System.out.print(str);
    return str;
  }

  public static void main(String[] args) {
    writeWordFile("https://www.doc88.com/p-00616010953810.html");
  }
}
