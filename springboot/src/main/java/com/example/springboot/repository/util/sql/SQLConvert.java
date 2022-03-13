package com.example.springboot.repository.util.sql;

/**
 * 平台转换SQL语句类
 *
 * @author luxuedong
 * @version V8.20
 * @date 2020/06/04
 **/
public class SQLConvert extends SQLUtil {
    public SQLConvert() {
    }

    public static String formatNum(String s, int place) {
        if (TypeOfDB.isMySQL()) {
            s = String.format("TRUNCATE(%s,%d)", s, place);
        }
        if (TypeOfDB.isOracle()) {
            s = String.format("ROUND(%s,%d)", s, place);
        }
        return s;
    }

    /**
     * 日期类型格式化
     *
     * @param places 日期格式长度：10位/19位
     * @return
     */
    public static String getDateFormat(int places) {
        if (TypeOfDB.isMySQL()) {
            return places == 10 ? "%Y-%m-%d" : places == 7 ? "%Y-%m" : "%Y-%m-%d %H:%i:%s";
        }
        if (TypeOfDB.isOracle()) {
            return places == 10 ? "yyyy-MM-dd" : places == 7 ? "yyyy-MM" : "yyyy-MM-dd hh24:mi:ss";
        }
        return "%Y-%m-%d";
    }

    /**
     * 日期转字符串
     *
     * @param field  字段
     * @param format 格式
     * @return SQL
     */
    public static String dateToString(String field, String format) {
        if (TypeOfDB.isOracle()) {
            return String.format("TO_CHAR(%s,'%s')", field, format);
        }
        if (TypeOfDB.isMySQL()) {
            return String.format("DATE_FORMAT(%s,'%s')", field, format);
        }
        return field;
    }

    public static String stringToDate(String field, String format) {
        if (TypeOfDB.isOracle()) {
            return String.format("TO_DATE(%s,'%s')", field, format);
        }
        if (TypeOfDB.isMySQL()) {
            return String.format("STR_TO_DATE(%s,'%s')", field, format);
        }
        return field;
    }

    public static String stringToDate(String field, String format, int dateLength) {
        if (TypeOfDB.isOracle()) {
            if (dateLength == 7) {
                return String.format("case length(%s) when 6 then TO_DATE(%s,'%s') else TO_DATE(%s,'%s') end", field, field, format.replace("-", ""), field, format);
            }
            return String.format("TO_DATE(%s,'%s')", field, format);
        }
        if (TypeOfDB.isMySQL()) {
            if (dateLength == 7) {
                // mysql str_to_date 转化年月会有问题，所以加"01"处理
                return String.format("case length(%s) when 6 then STR_TO_DATE(concat(%s, '01'),'%s') else STR_TO_DATE(concat(%s,'-01'),'%s') end", field, field, format.replace("-", "")+"%d", field, format + "-%d");
            }
            return String.format("STR_TO_DATE(%s,'%s')", field, format);
        }
        return field;
    }

    public static String substr(String field, int length) {
        if (TypeOfDB.isOracle()) {
            return String.format("SUBSTR(%s,1,%d)", field, length);
        }
        if (TypeOfDB.isMySQL()) {
            return String.format("LEFT(%s,%d)", field, length);
        }
        return field;
    }

    /**
     * 日期字符串格式化为数据库DML语言
     *
     * @param dateStr    日期字符串
     * @param dateFormat 日期格式
     * @return sql语句
     */
    public static String stringDateForDml(String dateStr, String dateFormat) {
        if (TypeOfDB.isOracle()) {
            return String.format("TO_TIMESTAMP('%s','%s')", dateStr, dateFormat);
        } else {
            return String.format("'%s'", dateStr);
        }
    }
}
