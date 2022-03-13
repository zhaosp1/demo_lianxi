package com.example.springboot.repository.util.sql;

import java.sql.SQLException;

/**
 * @ClassName SQLUtil
 * @Description sql工具类（根据平台改造）
 * @Author huangwei
 * @Date 2020/10/31 10:23
 * @Version 1.0
 */
public class SQLUtil {

    public static String replaceLinkChar(String s) {
        if (TypeOfDB.isMySQL()) {
            s = "concat(" + s.replaceAll("\\|\\|", ",") + ")";
        }

        return s;
    }

    public static String getSysdateToCharSql() {
        if (TypeOfDB.isMySQL()) {
            return "date_format(sysdate(),'%Y-%m-%d %H:%i:%s')";
        } else {
            return TypeOfDB.isPostgreSQL() ? "to_char(timestamp 'now','YYYY-MM-DD HH24:MI:SS')" : "to_char(sysdate,'yyyy-mm-dd hh24:mi:ss')";
        }
    }

    public static String replaceKeyChar(String s) {
        return TypeOfDB.isMySQL() ? "`" + s + "`" : s;
    }

    public static String replaceNvl(String s) {
        if (TypeOfDB.isMySQL()) {
            if (s != null) {
                return s.replaceAll("nvl", "ifnull");
            }
        } else if (TypeOfDB.isPostgreSQL() && s != null) {
            return s.replaceAll("nvl", "coalesce");
        }

        return s;
    }

    public static String replaceRowNum(String s) {
        return TypeOfDB.isMySQL() ? "@rowno:=@rowno+1 as " + s : "rownum " + s;
    }

    public static String rownum() {
        return TypeOfDB.isPostgreSQL() ? "(ROW_NUMBER() OVER())" : "rownum";
    }

    public static String getSeqExpr(String s) {
        if (TypeOfDB.isMySQL()) {
            return "NEXTVAL('" + s.toUpperCase() + "')";
        } else {
            return TypeOfDB.isPostgreSQL() ? "NEXTVAL('" + s.toLowerCase() + "')" : s + ".NEXTVAL";
        }
    }

    public static String getMySQLPageRow(String sSQL, int currPageIndex, int pageRowsCount, String sRowNum) throws SQLException {
        return "select datasecondfloor.* from ( select datafirstfloor.*,@rowno:=@rowno+1 as " + sRowNum + " from  (" + sSQL + " limit " + currPageIndex * pageRowsCount + " ) datafirstfloor,(select @rowno:=0) rowfirstfloor) datasecondfloor limit " + (currPageIndex - 1) * pageRowsCount + ", " + pageRowsCount;
    }

    public static String getDBSQL(String oracle) {
        return oracle;
    }

    public static String getDBSQL(String oracle, String mysql) {
        if (TypeOfDB.isOracle()) {
            return oracle;
        } else {
            return TypeOfDB.isMySQL() ? mysql : oracle;
        }
    }

    public static String getDBSQL(String oracle, String mysql, String postgresql) {
        if (TypeOfDB.isOracle()) {
            return oracle;
        } else if (TypeOfDB.isMySQL()) {
            return mysql;
        } else {
            return TypeOfDB.isPostgreSQL() ? postgresql : oracle;
        }
    }

    public static int parseInt(String s) {
        int i = 0;

        try {
            i = Integer.parseInt(s);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return i;
    }
}
