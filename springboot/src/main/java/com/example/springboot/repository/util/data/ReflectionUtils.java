package com.example.springboot.repository.util.data;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
//import com.yonyougov.smifc.smc.annotation.Display;
import org.apache.commons.lang.StringUtils;

import javax.persistence.Table;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName ReflectionUtils
 * @Description 反射工具类
 * @Author lixbe
 * @Date 2019/6/24 15:38
 **/
public class ReflectionUtils {

    public static String getFileds(String clsNam) {
        JSONObject mainJson = new JSONObject();
        // 数据列表 李晓北 2019年04月09日
        JSONArray jsonArray = new JSONArray();
        JSONObject childJson;
//        Display annotation;
        try {
            Class cls = Class.forName(clsNam.trim());
            Field[] fields = cls.getDeclaredFields();
            if (fields.length > 0) {
                for (int i = 0, j = fields.length; i < j; i++) {
                    if (!fields[i].isAccessible()) {
                        fields[i].setAccessible(true);
                    }
//                    annotation = fields[i].getAnnotation(Display.class);
//                    if (annotation != null) {
//                        childJson = new JSONObject();
//                        childJson.put("id", i);
//                        childJson.put("field", fields[i].getName());
//                        childJson.put("name", annotation.value());
//                        childJson.put("type", (fields[i].getType() + "").substring(StringUtils.lastIndexOf(fields[i].getType() + "", ".") + 1));
//                        jsonArray.add(childJson);
//                    }
                }
                mainJson.put("status", "success");
                mainJson.put("msg", "成功");
                mainJson.put("data", jsonArray);
            } else {
                mainJson.put("status", "fail");
                mainJson.put("msg", "失败，未查询到表单类型");
                mainJson.put("data", jsonArray);
            }
        } catch (Exception e) {
            mainJson.put("status", "fail");
            mainJson.put("msg", "失败，未查询到表单类型");
            mainJson.put("data", jsonArray);
            e.printStackTrace();
        }
        return mainJson.toJSONString();
    }

    /**
     * 根据字段名获取值
     * @param fieldName 字段名
     * @param o 对象
     * @return java.lang.Object
     * @author songlx
     * @date 2020/3/16
     */
    public static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[]{});
            Object value = method.invoke(o, new Object[]{});
            return value;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 通过实体获取表名
     * @param clazz 实体类
     * @return 表名
     */
    public static <T> String getTableName(Class<T> clazz){
        Table ann = clazz.getAnnotation(Table.class);
        return ann.name();
    }
    public static Field getFieldByFieldName(Object obj, String fieldName)
    {
        for (Class superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass())
        {
            try
            {
                return superClass.getDeclaredField(fieldName);
            }
            catch (NoSuchFieldException e)
            {
            }
        }
        return null;
    }

    public static Object getValueByFieldName(Object obj, String fieldName)
            throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
    {
        Field field = getFieldByFieldName(obj, fieldName);
        Object value = null;
        if (field != null)
        {
            if (field.isAccessible())
            {
                value = field.get(obj);
            }
            else
            {
                field.setAccessible(true);
                value = field.get(obj);
                field.setAccessible(false);
            }
        }
        return value;
    }

    public static void setValueByFieldName(Object obj, String fieldName, Object value)
            throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
    {
        Field field = obj.getClass().getDeclaredField(fieldName);
        if (field.isAccessible())
        {
            field.set(obj, value);
        }
        else
        {
            field.setAccessible(true);
            field.set(obj, value);
            field.setAccessible(false);
        }
    }
}
