package com.example.springboot.repository.util.json;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.file.FileReader;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.springboot.repository.util.time.DateHandler;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

public class AliJson {
    /**
     * json转换为map
     *
     * @param jsonMap   源json对象
     * @param result    指定解析映射字段,返回指定的数据对象
     * @param resultMap 容器map存放叶子节点返回值
     * @throws Exception 对数组，如果在映射集合内，则进行映射，如果没在则按照字符串进行处理，将解析后的键值对加载全局map中
     */
    public static void jsonToMap(JSONObject jsonMap, Map<String, String> result, Map resultMap) throws Exception {
        Iterator iter = jsonMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            String key = String.valueOf(entry.getKey());
            Object obj = jsonMap.get(key);
            if (obj instanceof String || obj instanceof Number) {
                if (CollectionUtil.isEmpty(result)) {
                    resultMap.put(key, String.valueOf(obj));
                } else if (result.containsKey(key)) {
                    String[] temp = result.get(key).split("#");
                    for (String t : temp) {
                        if (t.contains("@")) {
                            String[] ts = t.split("@");
                            resultMap.put(ts[0], getConfigForString(obj, ts[1]));
                        } else {
                            if (obj instanceof Double) {
                                resultMap.put(t, new DecimalFormat("0.00").format(obj));
                            } else if (obj instanceof BigDecimal) {
                                resultMap.put(t, obj);
                            } else {
                                resultMap.put(t, obj);
                            }
                        }
                    }
                }
//                else {
//                    resultMap.put(key.toLowerCase(Locale.ROOT),String.valueOf(obj));
//                }
            } else if (obj instanceof JSONArray) {
                if (CollectionUtil.isEmpty(result)) {
                    resultMap.put(key, obj);
                } else if (result.containsKey(key)) {
                    String[] value = result.get(key).split("@");
                    List list = new ArrayList();
                    for (int i = 0; i < ((JSONArray) obj).size(); i++) {
                        Map temp = new HashMap();
                        jsonToMap((JSONObject) ((JSONArray) obj).get(i), result, temp);
                        if (value.length > 1) {
                            temp.putAll(getConfigForMap(value[1]));
                        }
                        list.add(temp);
                    }
                    resultMap.put(value[0], list);
                }
//                else {
//                    for (int i = 0; i < ((JSONArray) obj).size(); i++) {
//                        jsonToMap((JSONObject) ((JSONArray) obj).get(i), result, resultMap);
//                    }
//                }
            } else {
                if (CollectionUtil.isEmpty(result)) {
                    Map temp = new HashMap();
                    jsonToMap((JSONObject) obj, result, temp);
                    resultMap.put(key, temp);
                } else if (result.containsKey(key)) {
                    Map temp = new HashMap();
                    String[] value = result.get(key).split("@");
                    jsonToMap((JSONObject) obj, result, temp);
                    if (value.length > 1) {
                        temp.putAll(getConfigForMap(value[1]));
                    }
                    resultMap.put(value[0], temp);
                } else {
                    jsonToMap((JSONObject) obj, result, resultMap);
                }
            }
        }
    }

    public static String getConfigForString(Object obj, String content) {
        String value = String.valueOf(obj);
        Map map = getConfigForMap(content);
        if (map.containsKey(value)) {
            return map.get(value).toString();
        }
        return value;
    }

    public static Map getConfigForMap(String content) {
        String[] array = content.split("&");
        Map map = new HashMap();
        for (String t : array) {
            String[] temp = t.split("=");
            map.put(temp[0], getValue(temp[1]));
        }
        return map;
    }

    public static String getValue(String s) {
        if (s.startsWith("$")) {
            return DateHandler.getDateFromNow(0, s.substring(1));
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        String s = new FileReader("C:\\Users\\alice\\Desktop\\1400.txt").readString();
        Map map=new HashMap();
        Map returnMsgMap = new HashMap();
        Map result = new HashMap();
        result.put("RET", "RET_CODE");
        result.put("CLIENT_NO", "client_no");
//        result.put("BODY","BODY");
//        result.put("RET_CODE","RET_CODE");
//        result.put("TRAN_HIST_ARRAY","TRAN_HIST_ARRAY");
        result.put("BODY", "BODY@client_no=123456");
        result.put("TOTAL_AMT_DR", "TOTAL_AMT_DR");
        result.put("TOTAL_AMT_CR", "TOTAL_AMT_CR");
        jsonToMap(JSONObject.parseObject(s),result,map);
    }
}
