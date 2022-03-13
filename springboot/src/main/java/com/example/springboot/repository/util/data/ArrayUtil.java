package com.example.springboot.repository.util.data;

import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Description:
 * @Author zhaosp1
 * @Date 2021/12/24
 */
public class ArrayUtil {
    /**
     * 判断集合是否为空
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }
    /**
     * 判断Map是否为空
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    /**
     * 判断数组是否为空
     */
    public static boolean isEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断List是否为空
     */
    public static boolean isEmpty(List<Object> list) {
        return list == null || list.size() == 0;
    }

    /**
     * 判断对象是否为空
     * @param obj 对象
     * @return true or false
     */
    public static boolean isNotEmpty(Object obj){
        return !isEmpty(obj);
    }

    /**
     * 判断对象是否为空
     * @param obj 对象
     * @return true or false
     */
    public static boolean isEmpty(Object obj){
        if (obj == null){
            return true;
        }
        if ((obj instanceof List)){
            return ((List<?>) obj).size() == 0;
        }
        if (obj instanceof Map){
            return ((Map<?, ?>) obj).isEmpty();
        }
        if ((obj instanceof String)){
            return "".equals(((String) obj).trim());
        }
        return false;
    }


    /**
     * List转字符串
     * @param list
     */
    public static String listToStr(List<?> list) {
        if(isEmpty(list)){
            return "";
        }
        StringBuilder strb = new StringBuilder();
        list.stream().filter(Objects::nonNull).forEach(strb::append);
        return strb.toString();
    }

}
