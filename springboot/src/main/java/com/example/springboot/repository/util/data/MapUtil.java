package com.example.springboot.repository.util.data;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName MapUtil
 * @Description: TODO Map转换工具类
 * @Author xudan
 * @Date 2019/11/30
 * @Version V1.0
 **/
public class MapUtil {

    /**
     * 将Object对象里面的属性和值转化成Map对象
     *
     * @param obj
     * @return
     * @throws IllegalAccessException
     */
    public static Map<String, Object> objectToMap(Object obj) {
        Class<?> clazz = obj.getClass();
        List<Field> fields = new ArrayList<>();
        //把父类包含的字段遍历出来
        while (clazz!=null){
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();

        }

        HashMap<String, Object> collect = fields.stream().collect(HashMap::new, (m, v) -> {
            try {
                ReflectionUtils.makeAccessible(v);
                m.put(v.getName(), v.get(obj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }, HashMap::putAll);
        return collect;
    }

    /**
     * 将JavaBean转换成Map
     * @param t
     * @return Map
     */
    public static <T> Map beanToMap(T t) {
        // 创建map集合
        Map map = new HashMap(16);
        // 获取JavaBean中所有属性
        Field[] fields = t.getClass().getDeclaredFields();
        try {
            for (Field fie : fields) {
                if (fie.getName().equals("serialVersionUID")){
                    continue;
                }
                // 将属性第一个字母转换成大写
                String frist = fie.getName().substring(0, 1).toUpperCase();
                // 获取属性的类型
                Class<?> type = fie.getType();
                // 封装属性的get
                String getter = "";
                if ("boolean".equals(type.getName())) {
                    getter = "is" + frist + fie.getName().substring(1);
                } else {
                    getter = "get" + frist + fie.getName().substring(1);
                }
                // 获取JavaBean的方法
                Method method = t.getClass().getMethod(getter, new Class[] {});
                // 调用方法,并接收返回值
                Object objec = method.invoke(t, new Object[] {});
                // 判断返回值不为空
                if (objec != null) {
                    map.put(fie.getName(), objec);
                } else {
                    map.put(fie.getName(), "");
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 将Map转换为JavaBean
     * @param map
     * @param beanClass
     * @return T
     */
    public static <T> T mapToBean(Map<String, Object> map, Class<T> beanClass){
        // 获取JavaBean中的所有属性
        Field[] field = beanClass.getDeclaredFields();
        T t = null;
        try {
            t = beanClass.newInstance();
            for (Field fi : field) {
                // 判断key值是否存在
                if (map.containsKey(fi.getName())) {
                    // 获取key的value值
                    Object value = map.get(fi.getName());
                    // 将属性的第一个字母转换为大写
                    String frist = fi.getName().substring(0, 1).toUpperCase();
                    // 属性封装set方法
                    String setter = "set" + frist + fi.getName().substring(1);
                    // 获取当前属性类型
                    Class<?> type = fi.getType();
                    // 获取JavaBean的方法,并设置类型
                    Method method = t.getClass().getMethod(setter, type);
                    if(BigDecimal.class.equals(type)){
                        value = new BigDecimal(value.toString());
                    }
                    if(Integer.class.equals(type)){
                        value=Integer.parseInt(value.toString());
                    }
                    if(Date.class.equals(type)){
                        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        value=df.parse(value.toString());
                    }
                    method.invoke(t, value);
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }catch (NoSuchMethodException e) {
            e.printStackTrace();
        }catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 将List<Map<String,Object>>转换成List<javaBean>
     * @param listm
     * @param beanClass
     * @return List<T>
     */
    public static <T> List<T> listMapToListBean(List<Map<String, Object>> listm, Class<T> beanClass) {
        List<T> list = new ArrayList<T>();
        // 循环遍历出map对象
        for (Map<String, Object> m : listm) {
            // 调用将map转换为JavaBean的方法
            T objs = mapToBean(m, beanClass);
            // 添加进list集合
            list.add(objs);
        }
        return list;
    }

    /**
     * 将list<javabean>转换为List<Map>
     * @param list
     * @return T
     */
    public static <T> List<Map<String, Object>> listBeanToListMap(List<T> list){
        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
        for (T t : list) {
            listmap.add(beanToMap(t));
        }
        return listmap;
    }

//    /**
//     * 将map key 下划线转换为驼峰
//     * @param listm
//     * @return List<Map<String,Object>>
//     */
//    public static List<Map> underLineToCamelMap(List<Map> listm){
//        List<Map> camelMapList=new ArrayList<>(20);
//        Map mapCamel;
//        for (Map map:listm) {
//            Iterator<Map.Entry> iterator=map.entrySet().iterator();
//            mapCamel=new HashMap(64);
//            while (iterator.hasNext()){
//                Map.Entry entry=iterator.next();
//
//                mapCamel.put(StringUtil.underlineToCamel(entry.getKey().toString().toLowerCase()),entry.getValue());
//            }
//            camelMapList.add(mapCamel);
//        }
//        return camelMapList;
//    }

//    /**
//     * @Description map将key 转为下划线大写
//     * @Param [map]
//     * @return java.util.Map<java.lang.String,java.lang.Object>
//     * @author peizongyuan
//     * @Date 2021/4/22
//     */
//    public static Map<String,Object> underCamelToLineMap(Map<String,Object> map){
//        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
//        Map<String,Object> mapLine = new HashMap(64);
//        while (iterator.hasNext()){
//            Map.Entry entry=iterator.next();
//            mapLine.put(StringUtil.convertHumpToLine(entry.getKey().toString()),entry.getValue());
//        }
//        return mapLine;
//    }
//
//
//    public static <T> List<T> listUnderLineMapToListBean(List<Map> maps,Class<T> tClass){
//        List<Map> mapList = underLineToCamelMap(maps);
//        return mapList.stream().map(m -> JSONObject.parseObject(new JSONObject(m).toJSONString(),tClass)).collect(Collectors.toList());
//    }

//    /**
//     * 从第一个参数对象中取值，使用key，返回String 类型值
//     * 先使用key的大写取值，为空时使用小写
//     *
//     * @param obj Map JSONObject
//     * @param key
//     * @return
//     * @author luxuedong
//     */
//    public static String fetchStringValue(Object obj, String key) {
//        return fetchObjectValue(obj, key, String.class);
//    }

//    /**
//     * 从第一个参数对象中取值，使用key，返回Object 类型值，例如 List<E>
//     * 先使用key的大写取值，为空时使用小写
//     *
//     * @param obj Map JSONObject
//     * @param key
//     * @return
//     * @author luxuedong
//     */
//    public static <T> T fetchObjectValue(Object obj, String key, Class<T> returnClass) {
//
//        Object objVal = null;
//        if (null == obj || StringUtil.isEmpty(key)) {
//            return (T) objVal;
//        }
//        if (obj instanceof Map) {
//            Map map = (Map) obj;
//            objVal = map.get(key.toUpperCase());
//            if (null == objVal) {
//                objVal = map.get(key.toLowerCase());
//            }
//        }
//        if (obj instanceof JSONObject) {
//            JSONObject jsonObject = (JSONObject) obj;
//            objVal = jsonObject.get(key.toUpperCase());
//            if (null == objVal) {
//                objVal = jsonObject.get(key.toLowerCase());
//            }
//        }
//
//        return (T) objVal;
//
//    }

    /**
     * map val 转字符串
     * @param map
     * @return
     */
    public static <K,V> String getMapValToString(Map<K,V> map){
        if(map==null||map.size()<1){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        map.forEach( (k,v) -> {stringBuilder.append(v==null?"":v);});
        return stringBuilder.toString();
    }
}
