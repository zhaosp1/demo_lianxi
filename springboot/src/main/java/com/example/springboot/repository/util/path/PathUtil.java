package com.example.springboot.repository.util.path;

import java.io.File;

/**
 * @author: zhaosp1
 * @description:
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2021/12/16 22:19
 */
public class PathUtil {
    public static String getAbsoluteClassPath(Class clazz){
        return clazz.getClassLoader().getResource("").toString().replace("file:/","");
    }

    public static String getPackagePath(Class clazz){
        return clazz.getPackage().getName().replace(".", File.separator);
    }

    public static void main(String[] args) {
        System.out.println(getAbsoluteClassPath(PathUtil.class));
        System.out.println(getPackagePath(PathUtil.class));
    }
}
