package nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * java nio实现文件内容的读取以及写入
 */
public class ChannelTest {
  //java nio实现文件的字节流读取
  public static void test1() throws Exception{
    RandomAccessFile file=new RandomAccessFile("C:\\Users\\lucky\\Desktop\\1.txt","rw");
    FileChannel fileChannel=file.getChannel();

    ByteBuffer buffer=ByteBuffer.allocate(48);
    int byteRead=fileChannel.read(buffer);
    while(byteRead!=-1){
      System.out.print(byteRead);
      buffer.flip();

      System.out.println();
      while(buffer.hasRemaining()){
        System.out.print((char)buffer.get());
      }

      buffer.clear();
      byteRead=fileChannel.read(buffer);
    }
  }

  //java nio通过通道transferFrom方法实现文件内容的读取
  public static void test2() throws Exception{
    RandomAccessFile file=new RandomAccessFile("C:\\Users\\lucky\\Desktop\\1.txt","rw");
    FileChannel fileChannel=file.getChannel();
    RandomAccessFile file1=new RandomAccessFile("C:\\Users\\lucky\\Desktop\\2.txt","rw");
    FileChannel fileChannel1=file1.getChannel();

    long position=0;
    long count=fileChannel.size();

    fileChannel1.transferFrom(fileChannel,position,count);
  }

  //java nio通过通道transferTo方法实现文件内容的写入
  public static void test3() throws Exception{
    RandomAccessFile file=new RandomAccessFile("C:\\Users\\lucky\\Desktop\\1.txt","rw");
    FileChannel fileChannel=file.getChannel();
    RandomAccessFile file1=new RandomAccessFile("C:\\Users\\lucky\\Desktop\\2.txt","rw");
    FileChannel fileChannel1=file1.getChannel();

    long position=0;
    long count=fileChannel.size();

    fileChannel.transferTo(position,count,fileChannel1);
  }
  public static void main(String[] args) throws Exception {
    test3();
  }
}
