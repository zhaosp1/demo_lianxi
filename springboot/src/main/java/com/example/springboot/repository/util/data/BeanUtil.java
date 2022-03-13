//package com.example.springboot.repository.util;
//
//import org.apache.commons.beanutils.BeanUtils;
//import org.apache.commons.beanutils.ConvertUtils;
//import org.apache.commons.beanutils.PropertyUtils;
//import org.apache.commons.beanutils.PropertyUtilsBean;
//import org.apache.commons.beanutils.converters.BigDecimalConverter;
//import org.springframework.util.ReflectionUtils;
//
//import java.beans.PropertyDescriptor;
//import java.lang.reflect.Field;
//import java.sql.Date;
//import java.sql.Timestamp;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Locale;
//
///**
// * 对org.apache.commons.beanutils进行了封装
// *
// * @ClassName BeanUtil
// * @Description: bean工具类
// * @Author xudan
// * @Date 2019/11/27
// * @Version V1.0
// **/
//public class BeanUtil {
//    private static final PropertyUtilsBean PROPERTY_UTILS_BEAN = new PropertyUtilsBean();
//    private static final DateFormat DATE_DF = new SimpleDateFormat("yyyy-MM-dd");
//    private static final DateFormat DATETIME_DF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//    public void init() {
//        BigDecimalConverter bd = new BigDecimalConverter(null);
//        ConvertUtils.register(bd, java.math.BigDecimal.class);
//    }
//
//    /**
//     * 利用反射原理取得JAVABEAN的属性值,转换成STRING返回
//     *
//     * @param bean     Object
//     * @param property String
//     * @return String
//     */
//    public static String getProperty(Object bean, String property) {
//        String result = null;
//        try {
//            result = BeanUtils.getSimpleProperty(bean, property);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return result;
//    }
//
//    public static void copyProperties(Object orig, Object dest, String[] ignalString) {
//        copyProperties(orig, dest, true, ignalString);
//    }
//
//    public static void copyProperties(Object orig, Object dest) {
//        copyProperties(orig, dest, true);
//    }
//
//    public static void copyProperties(Object orig, Object dest, boolean ignalNull) {
//        try {
//            if (orig != null && dest != null) {
//                PropertyDescriptor[] origDescriptors = PROPERTY_UTILS_BEAN
//                        .getPropertyDescriptors(dest);
//                for (PropertyDescriptor origDescriptor : origDescriptors) {
//                    String name = origDescriptor.getName();
//                    if ("class".equals(name)) {
//                        continue;
//                    }
//                    if (PROPERTY_UTILS_BEAN.isReadable(orig, name) && PROPERTY_UTILS_BEAN.isWriteable(dest, name)) {
//                        Object origValue = PROPERTY_UTILS_BEAN.getProperty(orig, name);
//                        Class<?> destType = PROPERTY_UTILS_BEAN.getPropertyType(dest, name);
//                        if (origValue == null && ignalNull) {
//                            continue;
//                        } else if ((destType == Timestamp.class || destType == Date.class || destType == java.math.BigDecimal.class) && "".equals(origValue)) {
//                            PROPERTY_UTILS_BEAN.setProperty(dest, name, null);
//                        } else if (destType == Timestamp.class) {
//                            java.util.Date time;
//                            assert origValue != null;
//                            String value = origValue.toString();
//                            if (value.contains("-")) {
//                                if (value.length() > 10) {
//                                    time = DATETIME_DF.parse(origValue.toString());
//                                } else {
//                                    time = DATE_DF.parse(origValue.toString());
//                                }
//                                BeanUtils.copyProperty(dest, name, new Timestamp(time.getTime()));
//                            } else {
//                                BeanUtils.copyProperty(dest, name, new Timestamp(Long.parseLong(value)));
//                            }
//                        } else if (destType == Date.class) {
//                            java.util.Date time;
//                            assert origValue != null;
//                            String value = origValue.toString();
//                            if (value.contains("-")) {
//                                if (origValue.toString().length() > 10) {
//                                    time = DATETIME_DF.parse(origValue.toString());
//                                } else {
//                                    time = DATE_DF.parse(origValue.toString());
//                                }
//                                BeanUtils.copyProperty(dest, name, new Date(time.getTime()));
//                            } else if (value.contains("0800")) {
//                                String str = origValue.toString();
//                                SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss 'GMT'Z' (中国标准时间)'", Locale.ENGLISH);
//                                java.util.Date date = sdf.parse(str);
//                                BeanUtils.copyProperty(dest, name, new Date(date.getTime()));
//                            } else {
//                                BeanUtils.copyProperty(dest, name, new Date(Long.parseLong(value)));
//                            }
//                        } else {
//                            try {
//                                BeanUtils.copyProperty(dest, name, origValue);
//                            } catch (Exception ex) {
//                                ex.printStackTrace();
//                            }
//                        }
//                    }
//                }
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public static void copyProperties(Object orig, Object dest, boolean ignalNull, String[] ignalString) {
//        try {
//            if (orig != null && dest != null) {
//                final PropertyDescriptor[] origDescriptors = PROPERTY_UTILS_BEAN
//                        .getPropertyDescriptors(dest);
//                for (final PropertyDescriptor descriptor : origDescriptors) {
//                    List<String> ignalList = Arrays.asList(ignalString);
//                    String name = descriptor.getName();
//                    if (PROPERTY_UTILS_BEAN.isReadable(orig, descriptor.getName()) && PROPERTY_UTILS_BEAN.isWriteable(dest, descriptor.getName())
//                            && !ignalList.contains(descriptor.getName())) {
//                        final Object origValue = PROPERTY_UTILS_BEAN.getProperty(orig, descriptor.getName());
//                        final Class<?> destType = PROPERTY_UTILS_BEAN.getPropertyType(dest, descriptor.getName());
//                        if (origValue == null && ignalNull) {
//                            continue;
//                        } else if ((destType == Timestamp.class
//                                || destType == Date.class || destType == java.math.BigDecimal.class)
//                                && "".equals(origValue)) {
//                            PROPERTY_UTILS_BEAN.setProperty(dest, name, null);
//                        } else if (destType == Timestamp.class) {
//                            java.util.Date time = null;
//                            assert origValue != null;
//                            String value = origValue.toString();
//                            if (value.contains("-")) {
//                                if (value.length() > 10) {
//                                    time = DATETIME_DF.parse(origValue.toString());
//                                } else {
//                                    time = DATE_DF.parse(origValue.toString());
//                                }
//                                BeanUtils.copyProperty(dest, name, new Timestamp(time.getTime()));
//                            } else {
//                                BeanUtils.copyProperty(dest, name, new Timestamp(Long.parseLong(value)));
//                            }
//                        } else if (destType == Date.class) {
//                            java.util.Date time = null;
//                            assert origValue != null;
//                            String value = origValue.toString();
//                            if (value.contains("-")) {
//                                if (origValue.toString().length() > 10) {
//                                    time = DATETIME_DF.parse(origValue.toString());
//                                } else {
//                                    time = DATE_DF.parse(origValue.toString());
//                                }
//                                BeanUtils.copyProperty(dest, name, new Date(time.getTime()));
//                            } else {
//                                BeanUtils.copyProperty(dest, name, new Date(Long.parseLong(value)));
//                            }
//                        } else {
//                            try {
//                                BeanUtils.copyProperty(dest, name, origValue);
//                            } catch (Exception ex) {
//                                ex.printStackTrace();
//                            }
//                        }
//                    }
//                }
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public static void copyPropertiesToString(Object orig, Object dest, boolean ignalNull) {
//        try {
//            if (orig != null && dest != null) {
//                PropertyDescriptor[] origDescriptors = PROPERTY_UTILS_BEAN.getPropertyDescriptors(dest);
//                for (PropertyDescriptor origDescriptor : origDescriptors) {
//                    String name = origDescriptor.getName();
//                    if ("class".equals(name)) {
//                        continue;
//                    }
//                    if (PROPERTY_UTILS_BEAN.isReadable(orig, name)
//                            && PROPERTY_UTILS_BEAN.isWriteable(dest, name)) {
//                        Object origValue = PROPERTY_UTILS_BEAN.getProperty(orig, name);
//                        String origType = PROPERTY_UTILS_BEAN.getPropertyType(orig, name).getName();
//                        if (origValue == null && ignalNull) {
//                            continue;
//                        } else if ("java.sql.Timestamp".equals(origType) && origValue != null) {
//                            BeanUtils.copyProperty(dest, name, DATETIME_DF.format((Timestamp) origValue));
//                        } else if ("java.sql.Date".equals(origType) && origValue != null) {
//                            BeanUtils.copyProperty(dest, name, DATE_DF.format((Date) origValue));
//                        } else {
//                            try {
//                                BeanUtils.copyProperty(dest, name, origValue);
//                            } catch (Exception ex) {
//                                ex.printStackTrace();
//                            }
//                        }
//                    }
//                }
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    /**
//     * 将属性的值装配到JAVABEAN中
//     *
//     * @param bean     Object
//     * @param property String
//     * @param value    Object
//     */
//    public static void populateProperty(Object bean, String property, Object value) {
//        try {
//            String fieldtype = PROPERTY_UTILS_BEAN.getPropertyType(bean, property).getName();
//            if (("java.sql.Timestamp".equals(fieldtype) || "java.sql.Date".equals(fieldtype) || "java.math.BigDecimal".equals(fieldtype)) && (value == null || "".equals(value))) {
//                if (PROPERTY_UTILS_BEAN.isReadable(bean, "modifyStrs") && PROPERTY_UTILS_BEAN.isWriteable(bean, "modifyStrs")) {
//                    Object obj = PROPERTY_UTILS_BEAN.getProperty(bean, "modifyStrs");
//                    if (obj instanceof List) {
//                        @SuppressWarnings("unchecked")
//                        List<String> list = (List<String>) obj;
//                        list.add(property);
//                        value = null;
//                    }
//                }
//            }
//            BeanUtils.setProperty(bean, property, value);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    /**
//     * 把fieldNames里指定的字段从from copy到to
//     *
//     * @param orig       Object
//     * @param dest       Object
//     * @param fieldNames String[]
//     */
//    public static void copySpecifyPropertys(Object orig, Object dest,
//                                            String[] fieldNames) {
//        try {
//            if (dest == null || orig == null) {
//                return;
//            }
//            for (String name : fieldNames) {
//                final Object origValue = PROPERTY_UTILS_BEAN.getProperty(orig, name);
//                final Class<?> destType = PROPERTY_UTILS_BEAN.getPropertyType(dest, name);
//                if (origValue == null) {
//                    continue;
//                } else if ((destType == Timestamp.class || destType == Date.class || destType == java.math.BigDecimal.class) && "".equals(origValue)) {
//                    PROPERTY_UTILS_BEAN.setProperty(dest, name, null);
//                } else if (destType == Timestamp.class) {
//                    java.util.Date time;
//                    String value = origValue.toString();
//                    if (value.contains("-")) {
//                        if (value.length() > 10) {
//                            time = DATETIME_DF.parse(origValue.toString());
//                        } else {
//                            time = DATE_DF.parse(origValue.toString());
//                        }
//                        BeanUtils.copyProperty(dest, name, new Timestamp(time.getTime()));
//                    } else {
//                        BeanUtils.copyProperty(dest, name, new Timestamp(Long.parseLong(value)));
//                    }
//                } else if (destType == Date.class) {
//                    java.util.Date time = null;
//                    String value = origValue.toString();
//                    if (value.contains("-")) {
//                        if (origValue.toString().length() > 10) {
//                            time = DATETIME_DF.parse(origValue.toString());
//                        } else {
//                            time = DATE_DF.parse(origValue.toString());
//                        }
//                        BeanUtils.copyProperty(dest, name, new Date(time.getTime()));
//                    } else {
//                        BeanUtils.copyProperty(dest, name, new Date(Long.parseLong(value)));
//                    }
//                } else {
//                    try {
//                        BeanUtils.copyProperty(dest, name, origValue);
//                    } catch (Exception ex) {
//                        ex.printStackTrace();
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void resetDTO(Object dto) {
//        if (dto == null) {
//            return;
//        }
//        PropertyDescriptor[] origDescriptors = PROPERTY_UTILS_BEAN.getPropertyDescriptors(dto);
//        for (PropertyDescriptor origDescriptor : origDescriptors) {
//            String name = origDescriptor.getName();
//            if (PROPERTY_UTILS_BEAN.isWriteable(dto, name) && !"class".equals(name)) {
//                try {
//                    PropertyUtils.setSimpleProperty(dto, name, null);
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        }
//    }
//
//
//    /**
//     * 拷贝List<Entity>到List<Dto>
//     *
//     * @param origList 源对象集合
//     * @param clazz    类
//     * @param <T>      泛型
//     * @return 拷贝集合
//     */
//    public static <T> List<T> copyList(List<?> origList,
//                                       Class<T> clazz) {
//        List<T> list = new ArrayList<T>();
//        if (null == origList || origList.isEmpty()) {
//            return list;
//        }
//        for (Object o : origList) {
//            try {
//                T d = clazz.newInstance();
//                copyProperties(o, d);
//                list.add(d);
//            } catch (InstantiationException | IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }
//        return list;
//    }
//
//    /**
//     * 把除了ignalString里指定的字段之外的字段从from copy到to
//     *
//     * @param orig        Object
//     * @param dest        Object
//     * @param ignalString String[]
//     */
//    public static void copyPropertysIgnoreSpecify(Object orig, Object dest, String[] ignalString) {
//        if (dest == null || orig == null) {
//            return;
//        }
//        try {
//            PropertyDescriptor[] origDescriptors = PROPERTY_UTILS_BEAN.getPropertyDescriptors(dest);
//            List<String> list = new ArrayList<>();
//            for (PropertyDescriptor origDescriptor : origDescriptors) {
//                String name = origDescriptor.getName();
//                if ("class".equals(name)) {
//                    continue;
//                }
//                if (!stringArrayContain(ignalString, name) && PROPERTY_UTILS_BEAN.isReadable(orig, name) && PROPERTY_UTILS_BEAN.isWriteable(dest, name)) {
//                    Object origValue = PROPERTY_UTILS_BEAN.getProperty(orig, name);
//                    String destType = PROPERTY_UTILS_BEAN.getPropertyType(dest, name).getName();
//                    if (("java.sql.Date".equals(destType) || "java.math.BigDecimal".equals(destType)) && "".equals(origValue)) {
//                        BeanUtils.copyProperty(dest, name, null);
//                        list.add(name);
//                    } else {
//                        try {
//                            BeanUtils.copyProperty(dest, name, origValue);
//                        } catch (Exception ex) {
//                            ex.printStackTrace();
//                        }
//                    }
//                }
//            }
//            if (PROPERTY_UTILS_BEAN.isReadable(dest, "modifyStrs")
//                    && PROPERTY_UTILS_BEAN.isWriteable(dest, "modifyStrs")) {
//                BeanUtils.copyProperty(dest, "modifyStrs", list);
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public static boolean stringArrayContain(String[] array, String isContain) {
//        for (String str : array) {
//            if (str != null && str.equals(isContain)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    //判断属性是否均为空
//    public static boolean checkObjFieldIsNotNull(Object obj) {
//        boolean flag = false;
//        try {
//            for (Field f : obj.getClass().getDeclaredFields()) {
//                ReflectionUtils.makeAccessible(f);
//                if (f.get(obj) == null || f.get(obj) == "") {
//                } else {
//                    flag = true;
//                }
//            }
//        } catch (Exception e) {
//            return false;
//        }
//        return flag;
//    }
//}
