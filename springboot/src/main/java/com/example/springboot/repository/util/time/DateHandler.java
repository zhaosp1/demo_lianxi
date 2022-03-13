package com.example.springboot.repository.util.time;

import com.example.springboot.repository.util.data.StringUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateHandler {
    public static int openDay = 5;
    private String iDate = "";
    private int iYear;
    private int iMonth;
    private int iDay;
    private int iHour;
    private int iMiunte;
    private static DateFormat ddFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static DateFormat ddChFormat = new SimpleDateFormat("yyyy年M月d日");
    private static DateFormat ddShortFormat = new SimpleDateFormat("yyyyMMdd");
    private static DateFormat ssFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static DateFormat df2 = new SimpleDateFormat("yyyyMMddHHmmssSSSS");

    public static String dateToDdString(Date date) {
        return date == null ? "" : ddFormat.format(date);
    }

    public static String dateToDdChString(Date date) {
        return date == null ? null : ddChFormat.format(date);
    }

    public static String dateToShortDdString(Date date) {
        return ddShortFormat.format(date);
    }

    public static synchronized String getCurrentDateNo() {
        try {
            Thread.sleep(1L);
        } catch (Exception var1) {
        }

        Date date = new Date();
        date.setTime(System.currentTimeMillis());
        return df2.format(date);
    }

    public static Date getCurDate() {
        return ddStringToDate(dateToDdString(new Date()));
    }

    public static String dateToSsString(Date date) {
        return date != null ? ssFormat.format(date) : "";
    }

    public static Date ddStringToDate(String dateStr) {
        Date date = null;

        try {
            date = ddFormat.parse(dateStr);
            return date;
        } catch (ParseException var3) {
            return null;
        }
    }

    public DateHandler() {
    }

    public void setDate(String iDateTime) {
        this.iDate = iDateTime.substring(0, 10);
    }

    public String getDate() {
        return this.iDate;
    }

    public int getYear() {
        this.iYear = Integer.parseInt(this.iDate.substring(0, 4));
        return this.iYear;
    }

    public int getMonth() {
        this.iMonth = Integer.parseInt(this.iDate.substring(5, 7));
        return this.iMonth;
    }

    public int getDay() {
        this.iDay = Integer.parseInt(this.iDate.substring(8, 10));
        return this.iDay;
    }

    public int getHour() {
        if (this.iDate.length() == 16) {
            this.iHour = Integer.parseInt(this.iDate.substring(11, 13));
        } else {
            this.iHour = 0;
        }

        return this.iHour;
    }

    public int getMinute() {
        if (this.iDate.length() == 16) {
            this.iMiunte = Integer.parseInt(this.iDate.substring(14, 16));
        } else {
            this.iMiunte = 0;
        }

        return this.iMiunte;
    }

    public static String subDate(String date) {
        return date.substring(0, 10);
    }

    public static boolean isSeason(String date) {
        int getMonth = Integer.parseInt(date.substring(5, 7));
        boolean sign = false;
        if (getMonth == 3) {
            sign = true;
        }

        if (getMonth == 6) {
            sign = true;
        }

        if (getMonth == 9) {
            sign = true;
        }

        if (getMonth == 12) {
            sign = true;
        }

        return sign;
    }

    public static String getDateFromNow(int afterDay) {
        GregorianCalendar calendar = new GregorianCalendar();
        Date date = calendar.getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        calendar.set(5, calendar.get(5) + afterDay);
        date = calendar.getTime();
        return df.format(date);
    }

    public static String getDateFromNow(int afterDay, String format_string) {
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        DateFormat df = new SimpleDateFormat(format_string);
        calendar.set(5, calendar.get(5) + afterDay);
        date = calendar.getTime();
        return df.format(date);
    }

    public static String getNowForFileName(int afterDay) {
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        calendar.set(5, calendar.get(5) + afterDay);
        Date date = calendar.getTime();
        return df.format(date);
    }

    public int getDateCompare(String limitDate, int afterDay) {
        GregorianCalendar calendar = new GregorianCalendar();
        Date date = calendar.getTime();
        calendar.set(5, calendar.get(5) + afterDay);
        date = calendar.getTime();
        this.iDate = limitDate;
        calendar.set(this.getYear(), this.getMonth() - 1, this.getDay());
        Date dateLimit = calendar.getTime();
        return dateLimit.compareTo(date);
    }

    public int getDateCompare(String limitDate) {
        this.iDate = limitDate;
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(this.getYear(), this.getMonth() - 1, this.getDay());
        Date date = calendar.getTime();
        Date nowDate = new Date();
        return date.compareTo(nowDate);
    }

    public int getDateTimeCompare(String limitDateTime) {
        this.iDate = limitDateTime;
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(this.getYear(), this.getMonth() - 1, this.getDay(), this.getHour(), this.getMinute());
        Date date = calendar.getTime();
        Date nowDate = new Date();
        return date.compareTo(nowDate);
    }

    public long getLongCompare(String limitDate) {
        this.iDate = limitDate;
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(this.getYear(), this.getMonth() - 1, this.getDay());
        Date date = calendar.getTime();
        long datePP = date.getTime();
        Date nowDate = new Date();
        long dateNow = nowDate.getTime();
        return (dateNow - datePP) / 86400000L;
    }

    public long getLongCompare(String limitDate1, String limitDate2) {
        this.iDate = limitDate1;
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(this.getYear(), this.getMonth() - 1, this.getDay());
        Date date = calendar.getTime();
        long datePP = date.getTime();
        this.iDate = limitDate2;
        if (limitDate2 == null || limitDate2.trim().equals("")) {
            this.iDate = getToday();
        }

        calendar.set(this.getYear(), this.getMonth() - 1, this.getDay());
        Date date2 = calendar.getTime();
        long dateNow = date2.getTime();
        return (dateNow - datePP) / 86400000L;
    }

    public static String getToday() {
        Calendar cld = Calendar.getInstance();
        Date date = new Date();
        cld.setTime(date);
        int intMon = cld.get(2) + 1;
        int intDay = cld.get(5);
        String mons = String.valueOf(intMon);
        String days = String.valueOf(intDay);
        if (intMon < 10) {
            mons = "0" + String.valueOf(intMon);
        }

        if (intDay < 10) {
            days = "0" + String.valueOf(intDay);
        }

        return cld.get(1) + "-" + mons + "-" + days;
    }

    public static int getCurrentYear() {
        Calendar cld = Calendar.getInstance();
        Date date = new Date();
        cld.setTime(date);
        return cld.get(1);
    }

    public static String getYestoday() {
        Calendar cld = Calendar.getInstance();
        Date date = new Date();
        cld.setTime(date);
        cld.add(5, -1);
        int intMon = cld.get(2) + 1;
        int intDay = cld.get(5);
        String mons = String.valueOf(intMon);
        String days = String.valueOf(intDay);
        if (intMon < 10) {
            mons = "0" + String.valueOf(intMon);
        }

        if (intDay < 10) {
            days = "0" + String.valueOf(intDay);
        }

        return cld.get(1) + "-" + mons + "-" + days;
    }

//    public static int getWorkDay(String date, int sign) {
//        int month = false;
//        int week = false;
//        int workDay = 0;
//        Calendar rightNow = Calendar.getInstance();
//        DateHandler dateOver = new DateHandler();
//        dateOver.setDate(date);
//        rightNow.set(1, dateOver.getYear());
//        rightNow.set(2, dateOver.getMonth() - 1);
//        rightNow.set(5, dateOver.getDay());
//
//        for(int month = rightNow.get(2); rightNow.get(2) == month; rightNow.add(5, sign)) {
//            int week = rightNow.get(7);
//            if (week != 1 && week != 7) {
//                ++workDay;
//            }
//        }
//
//        return workDay;
//    }

    public static int getCurrentMonth() {
        GregorianCalendar dt = new GregorianCalendar();
        return dt.get(2) + 1;
    }

    public int getWorkDay(String limitDate) {
        int lday = (int)this.getLongCompare(limitDate);
        Calendar rightNow = Calendar.getInstance();
        DateHandler dateOver = new DateHandler();
        dateOver.setDate(getToday());
        rightNow.set(1, dateOver.getYear());
        rightNow.set(2, dateOver.getMonth() - 1);
        rightNow.set(5, dateOver.getDay());
        int week = rightNow.get(3);
        Calendar limDate = Calendar.getInstance();
        dateOver.setDate(limitDate);
        limDate.set(1, dateOver.getYear());
        limDate.set(2, dateOver.getMonth() - 1);
        limDate.set(5, dateOver.getDay());
        int limit_week = limDate.get(3);
        int iday = 0;
        int iweek = rightNow.get(7);
        if (iweek == 7) {
            ++iday;
        }

        if (iweek == 1) {
            iday = 2;
        }

        int limitday = 0;
        int limitweek = limDate.get(7);
        if (limitweek == 7) {
            ++limitday;
        }

        if (limitweek == 1) {
            limitday = 2;
        }

        int irestDay = (week - limit_week) * 2 + iday - limitday;
        return lday - irestDay;
    }

    public int getWorkDay(String limitDate1, String limitDate2) {
        if (limitDate2 == null || limitDate2.trim().equals("")) {
            limitDate2 = getToday();
        }

        int lday = (int)this.getLongCompare(limitDate1, limitDate2);
        DateHandler dateOver = new DateHandler();
        Calendar limDate2 = Calendar.getInstance();
        dateOver.setDate(limitDate2);
        limDate2.set(1, dateOver.getYear());
        limDate2.set(2, dateOver.getMonth() - 1);
        limDate2.set(5, dateOver.getDay());
        int week = limDate2.get(3);
        Calendar limDate1 = Calendar.getInstance();
        dateOver.setDate(limitDate1);
        limDate1.set(1, dateOver.getYear());
        limDate1.set(2, dateOver.getMonth() - 1);
        limDate1.set(5, dateOver.getDay());
        int limit_week = limDate1.get(3);
        int iday = 0;
        int iweek = limDate2.get(7);
        if (iweek == 7) {
            ++iday;
        }

        if (iweek == 1) {
            iday = 2;
        }

        int limitday = 0;
        int limitweek = limDate1.get(7);
        if (limitweek == 7) {
            ++limitday;
        }

        if (limitweek == 1) {
            limitday = 2;
        }

        int irestDay = (week - limit_week) * 2 + iday - limitday;
        return lday - irestDay;
    }

    public static String getLastVerTime() {
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(calendar.getTime());
    }



    /**
     * 对日期字段格式化
     *
     * @param date
     * @param format
     * @return
     */
    public static String formatDate(String date, String format) throws Exception{
        if (StringUtil.isNull(format)){
            return date;
        }
        String temp=date.replaceAll("\\D","");
        SimpleDateFormat ori=new SimpleDateFormat("yyyyMMddHHmmssSSS".substring(0,temp.length()));
        SimpleDateFormat dest = new SimpleDateFormat(format);
        Date d = ori.parse(temp);
        return dest.format(d);
    }

    /**
     * 根据 年、月 获取对应的月份 的 天数
     */
    public static int getDaysByYearMonth(int year, int month) {

        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }
    //获取指定日期之间的所有年月
    private static List<String> getMonthBetween(String minDate, String maxDate) throws ParseException {
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月

        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        min.setTime(sdf.parse(minDate));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

        max.setTime(sdf.parse(maxDate));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            result.add(sdf.format(curr.getTime()).replace("-",""));
            curr.add(Calendar.MONTH, 1);
        }

        return result;
    }
    public static void main(String[] args) {

        System.out.println(System.nanoTime());
        System.out.println(System.nanoTime());
    }
}
