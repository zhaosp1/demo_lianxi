package com.example.springboot.repository.util.sql;

import cn.hutool.core.io.file.FileReader;

import java.util.*;

public class MapMapping {
    public static Map getMap(String s){
        Map map=new HashMap();
        String[] array=s.split("\\s+");
        for(int i=0;i<array.length;i+=2){
            map.put(array[i],array[i+1]);
        }
        return map;
    }

    public static String generateString(String template,Map<String,String> map){
        StringJoiner sj=new StringJoiner("\n");
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String,String> me=(Map.Entry)iter.next();

        }
        return null;
    }

    public static void test(String s){
        Map map=new LinkedHashMap();
        String[] array=s.split("\\s+");
        for(int i=0;i<array.length;i+=3){
//            map.put(array[i+1],array[i]);
            System.out.println("detailMap.put(\""+array[i+1]+"\", StringUtil.getAsString(detail.get(\""+array[i+2]+"\")));   //"+array[i]);
        }
//        System.out.println(JSONObject.fromObject(map));
    }
    public static void main(String[] args) {
        String content=new FileReader("C:\\Users\\alice\\Desktop\\5702.txt").readString();
        List<String> list=new ArrayList<>();
        String[] array=content.split("\\s+");
        for(int i=0;i<array.length;i+=5){
            list.add(array[i+1]);
            list.add(array[i+2]);
        }
        String[] temp=new String[list.size()];
        System.out.println(SqlGenerate.generateSelectForDefaultAlias("ebank_core_tra_flow",list.toArray(temp)));;
    }
}
