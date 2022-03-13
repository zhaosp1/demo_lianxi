package com.example.springboot.repository.util.file;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Arrays;

public class NIOUtil {
  /**
   * nio实现文件复制
   *
   * @param from
   * @param to
   * @throws IOException
   */
  public static final void nioCopyFile(File from, File to) throws IOException {
    FileInputStream fin = null;
    FileOutputStream fout = null;
    FileChannel fic = null;
    FileChannel foc = null;
    try {
      fin = new FileInputStream(from);
      fout = new FileOutputStream(to);
      fic = fin.getChannel();
      foc = fout.getChannel();
      ByteBuffer bb = ByteBuffer.allocate(1024 << 4);
      while (fic.read(bb) > 0) {
        bb.flip();
        foc.write(bb);
        bb.clear();
      }
    } finally {
      if (null != fic)
        fic.close();
      if (null != foc)
        foc.close();
      if (null != fin)
        fin.close();
      if (null != fout)
        fout.close();
    }
  }


  public static void main(String[] args) {
    //nio编码
    ByteBuffer byteBuffer = ByteBuffer.allocate(128);
    byteBuffer.put(new byte[]{-26, -120, -111, -25, -120, -79, -28, -67, -96});
    byteBuffer.flip();

    /*对获取utf8的编解码器*/
    Charset utf8 = Charset.forName("UTF-8");
    CharBuffer charBuffer = utf8.decode(byteBuffer);/*对bytebuffer中的内容解码*/

    /*array()返回的就是内部的数组引用，编码以后的有效长度是0~limit*/
    char[] charArr = Arrays.copyOf(charBuffer.array(), charBuffer.limit());
    System.out.println(charArr); /*运行结果：我爱你*/


    //nio解码
    CharBuffer charBuffer1 = CharBuffer.allocate(128);
    charBuffer.append("我爱你");
    charBuffer.flip();

    /*对获取utf8的编解码器*/
    Charset utf81 = Charset.forName("UTF-8");
    ByteBuffer byteBuffer1 = utf81.encode(charBuffer1); /*对charbuffer中的内容解码*/

    /*array()返回的就是内部的数组引用，编码以后的有效长度是0~limit*/
    byte[] bytes = Arrays.copyOf(byteBuffer.array(), byteBuffer.limit());
    System.out.println(Arrays.toString(bytes));
    /*运行结果：[-26, -120, -111, -25, -120, -79, -28, -67, -96] */
  }
}
