package com.example.springboot.repository.util.office;

import org.apache.commons.io.output.FileWriterWithEncoding;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author xucy
 * @Date 2019-03-15 15:48
 * @Description 文件处理类
 **/

public class TxtUtil {

    /**
     * 追加文件内容
     * @param file
     * @param content
     * @param charset
     * @return
     */
    public synchronized static boolean appendFileLine(File file, String content, String charset) {
        return appendFile(file, content + "\r\n", charset);
    }


    /**
     * 追加文件内容
     *
     * @param file
     * @param content
     * @return
     */
    public synchronized static boolean appendFile(File file, String content, String charset) {
        // 如果文件存在，则追加内容；如果文件不存在，则创建文件
        boolean flag;
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new  RuntimeException("创建txt文件失败", e);
            }
        }
        FileWriterWithEncoding fw = null;
        try {
            fw = new FileWriterWithEncoding(file, charset, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.print(content);
        pw.flush();
        flag = true;
        try {
            fw.flush();
            if(pw != null){
                pw.close();
            }
            if(fw != null){
                fw.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }


    /**
     * @Author huangwei
     * @Description  覆盖文件内容
     * @Date 10:44 2020/4/1
     * @Param [file, content, charset]
     * @return boolean
     **/
    public static boolean coverFile(File file, String content, String charset) {
        boolean flag;
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("创建txt文件失败", e);
            }
        }
        FileWriterWithEncoding fw = null;
        try {
            fw = new FileWriterWithEncoding(file, charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.print(content);
        pw.flush();
        flag = true;
        try {
            fw.flush();
            if(pw != null){
                pw.close();
            }
            if(fw != null){
                fw.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
