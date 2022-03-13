package com.example.springboot.repository.util.other;

import cn.hutool.core.io.file.FileReader;
import com.example.springboot.repository.util.sql.SqlGenerate;


import java.util.*;

public class VoucherUtil {
    public static List readMetaMsgFromFile(String path,Map<Integer,String> col){
        List list=new ArrayList();
        FileReader fin=new FileReader(path);
        List<String> temp= fin.readLines();
        for(String t:temp){
            list.add(getColumn(t.split("\\s+"),col));
        }
        return list;
    }

    public static Map getColumn(String[] array,Map<Integer,String> col){
        Map map=new HashMap();
        int lenth=array.length;
        Set<Map.Entry<Integer,String>> entrySet=col.entrySet();
        for(Map.Entry<Integer,String> e:entrySet){
            if(lenth>e.getKey()){
                map.put(e.getValue(),array[e.getKey()]);
            }
        }
        return map;
    }


    public static void main(String[] args) {
        Map<Integer,String> map=new HashMap<>();
        map.put(0,"name");
        map.put(1,"comment");
        map.put(2,"length");
        map.put(3,"lenth");
        map.put(4,"temp");
        map.put(5,"is_must");
        List list=readMetaMsgFromFile("C:\\Users\\alice\\Desktop\\2001.txt",map);

        System.out.println(SqlGenerate.generateCreate("EBANK_ACCOUNT_DEPOSIT_BILL",list));
    }
}
