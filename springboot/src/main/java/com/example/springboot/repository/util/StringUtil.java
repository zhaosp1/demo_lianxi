package com.example.springboot.repository.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 对字符串操作的一些工具方法
 *
 * @Author zhaosp1
 * @Date 2021-12-28
 **/

public class StringUtil {

    public static final String INTEGER_REGEX = "^-?[\\d]+$";

    public static final String DOUBLE_REGEX = "^[-\\+]?[\\d]*.?[\\d]+$";

    public static final String CHINESE_REGEX = "[\u0391-\uFFE5]+$";

    public static final String EMAIL_REGEX = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    public static final String HTTP_URL_REGEX = "((https?://)?([a-z]+[.])|(www.))\\w+[.]([a-z]{2,4})?[[.]([a-z]{2,4})]+((/[\\S&&[^,;\u4E00-\u9FA5]]+)+)?([.][a-z]{2,4}+|/?)";

    public static final char[] ILLEGAL_FILE_CHARS = {'\\', '/', ':', '*', '?', '"', '<', '>', '|'};

    public static final char[] REGEX_CHARS = {'.', '$', '^', '{', '[', '(', '|', ')', '*', '+', '?', '\\'};

    private static Pattern p = Pattern.compile("\\s*|\t|\r|\n");

    public static final String IDNUMBER_REGEX = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" + "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";

    public static final char NUM_ZERO='0';
    /**
     * @param IDNumber
     * @return
     * @Description:身份证号码校验 包括18位和15位
     */
    public static boolean validateIDNumber(String IDNumber) {
        if (!IDNumber.matches(IDNUMBER_REGEX)) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否为整数
     *
     * @param str 参数
     * @return 是整数返回true, 否则返回false
     */
    public static boolean isInteger(String str) {
        return str.matches(INTEGER_REGEX);
    }

    /**
     * 判断是否为浮点数，包括double和float
     *
     * @param str 参数
     * @return 是浮点数返回true, 否则返回false
     */
    public static boolean isDouble(String str) {
        return str.matches(DOUBLE_REGEX);
    }

    /**
     * 判断输入的字符串是否为纯汉字
     *
     * @param str 参数
     * @return 如果是纯汉字返回true, 否则返回false
     */
    public static boolean isChinese(String str) {
        return str.matches(CHINESE_REGEX);
    }

    /**
     * 判断输入的字符串是否符合Email样式.
     *
     * @param str 参数
     * @return 是Email样式返回true, 否则返回false
     */
    public static boolean isEmail(String str) {
        return str.matches(EMAIL_REGEX);
    }

    /**
     * 判断输入的字符串是否是合法的网址
     *
     * @param str 参数
     * @return 是网址返回true, 否则返回false
     */
    public static boolean isHttpUrl(String str) {
        return str.matches(HTTP_URL_REGEX);
    }

    /**
     * 判断字符串是否不在目标字符串strs中
     *
     * @param str
     * @param strs
     * @return
     */
    public static boolean notInStr(String str, String... strs) {
        for (int i = 0; i < strs.length; i++) {
            if (str.equals(strs[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符串是否在目标字符串中，默认以逗号分隔
     * a in a,b,c 返回true
     *
     * @param str
     * @param instr
     * @return boolean
     */
    public static boolean containsInStr(String str, String instr) {
        return containsInStr(str, instr, ",");
    }

    /**
     * 判断字符串是否在目标字符串中，以分隔符分割
     * a in a,b,c 返回true
     *
     * @param str
     * @param instr
     * @param compliex
     * @return boolean
     */

    public static boolean containsInStr(String str, String instr, String compliex) {
        String[] strArry = instr.split(compliex);
        for (int i = 0; i < strArry.length; i++) {
            if (str.equals(strArry[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否有文本内容
     *
     * @param str 参数
     * @return true or false
     */
    public static boolean hasText(String str) {
        if (StringUtils.isBlank(str)) {
            return false;
        }
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断字符是否是非法的文件字符
     *
     * @param c 参数
     * @return true or false
     */
    public static boolean isIllegalFileChar(char c) {
        for (int i = 0; i < ILLEGAL_FILE_CHARS.length; i++) {
            char fileChar = ILLEGAL_FILE_CHARS[i];
            if (c == fileChar) {
                return true;
            }
        }
        return false;
    }

    /**
     * 替换字符串中的非法文件字符
     *
     * @param str         参数
     * @param replacement 替换使用的字符串
     * @return 替换后的字符串
     */
    public static String replaceIllegalFileChars(String str, String replacement) {
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (isIllegalFileChar(c)) {
                sb.append(replacement);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 判断字符是否是正则表达式关键字符
     *
     * @param c 字符
     * @return true or false
     */
    public static boolean isRegexChar(char c) {
        for (char regexChar : REGEX_CHARS) {
            if (c == regexChar) {
                return true;
            }
        }
        return false;
    }

    /**
     * 将字符串中的正则表达式关键字符用\转义
     *
     * @param str 参数
     * @return 转义后的字符串
     */
    public static String escapeRegex(String str) {
        int len = str.length();
        // 查找字符串里是否含有正则表达式字符
        int i = -1;
        while (++i < len) {
            if (isRegexChar(str.charAt(i))) {
                break;
            }
        }
        // 字符串含有正则表达式字符
        if (i < len) {
            char[] buf = new char[len * 2];
            // 复制前面的字符
            for (int j = 0; j < i; j++) {
                buf[j] = str.charAt(j);
            }
            int count = 0;
            while (i < len) {
                char c = str.charAt(i);
                if (isRegexChar(c)) {
                    buf[i + count] = '\\';
                    count++;
                }
                buf[i + count] = c;
                i++;
            }
            return new String(buf, 0, len + count);
        }
        return str;
    }

    /**
     * display text correctly in xml
     *
     * @param str 参数
     * @return 处理后的字符串
     */
    public static String xmlEncode(String str) {
        if (StringUtils.isBlank(str)) {
            return str;
        }

        str = str.replaceAll("&", "&amp;");
        str = str.replaceAll("<", "&lt;");
        str = str.replaceAll(">", "&gt;");
        str = str.replaceAll("'", "&apos;");
        str = str.replaceAll("\"", "&quot;");
        return str;
    }

    /**
     * restore text from xmlEncode()
     *
     * @param str 参数
     * @return 处理后的字符串
     */
    public static String xmlDecode(String str) {
        if (StringUtils.isBlank(str)) {
            return str;
        }

        str = str.replaceAll("&lt;", "<");
        str = str.replaceAll("&gt;", ">");
        str = str.replaceAll("&apos;", "'");
        str = str.replaceAll("&quot;", "\"");
        str = str.replaceAll("&amp;", "&");
        return str;
    }

    /**
     * display text correctly in html
     *
     * @param str 参数
     * @return 处理后的字符串
     */
    public static String htmlEncode(String str) {
        if (StringUtils.isBlank(str)) {
            return str;
        }

        str = str.replaceAll("&", "&amp;");
        str = str.replaceAll("<", "&lt;");
        str = str.replaceAll(">", "&gt;");
        str = str.replaceAll("\"", "&quot;");
        return str;
    }

    /**
     * restore text from htmlEncode()
     *
     * @param str 参数
     * @return 处理后的字符串
     */
    public static String htmlDecode(String str) {
        if (StringUtils.isBlank(str)) {
            return str;
        }

        str = str.replaceAll("&lt;", "<");
        str = str.replaceAll("&gt;", ">");
        str = str.replaceAll("&quot;", "\"");
        str = str.replaceAll("&amp;", "&");
        return str;
    }

    /**
     * show text int html
     *
     * @param str 参数
     * @return 处理后的字符串
     */
    public static String toHtmlText(String str) {
        if (StringUtils.isBlank(str)) {
            return str;
        }

        str = str.replaceAll("<", "&lt;");
        str = str.replaceAll(">", "&gt;");
        str = str.replaceAll("\"", "&quot;");
        // 空格
        str = str.replaceAll(" ", "&nbsp;");
        // TAB
        str = str.replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
        // 回车
        str = str.replaceAll("\r\n", "<br/>");
        str = str.replaceAll("\n", "<br/>");
        return str;
    }

    /**
     * For example: INITIAL_RSRC_CONSUMER_GROUP -> initialRsrcConsumerGroup
     *
     * @param columnName column name in database table
     * @return property name in javabean/pojo
     */
    public static String columnToProperty(String columnName) {
        int length = columnName.length();
        char[] buff = new char[length];
        int count = 0;
        for (int i = 0; i < length; i++) {
            char c = columnName.charAt(i);
            if (c == '_') {
                buff[count++] = columnName.charAt(++i);
            } else {
                buff[count++] = Character.toLowerCase(c);
            }
        }
        return new String(buff, 0, count);
    }

    /**
     * For example: initialRsrcConsumerGroup -> INITIAL_RSRC_CONSUMER_GROUP
     *
     * @param propertyName property name in javabean/pojo
     * @return column name in database table
     */
    public static String propertyToColumn(String propertyName) {
        int length = propertyName.length();
        char[] buff = new char[length * 2];
        int count = 0;
        for (int i = 0; i < length; i++) {
            char c = propertyName.charAt(i);
            if (Character.isUpperCase(c)) {
                buff[count++] = '_';
                buff[count++] = c;
            } else {
                buff[count++] = Character.toUpperCase(c);
            }
        }
        return new String(buff, 0, count);
    }

    /**
     * 首字母大写
     *
     * @param str 参数
     * @return 处理后的字符串
     */
    public static String toFirstUpperCase(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String toEllipsis(String str, int length) {
        return toEllipsis(str, length, "...");
    }

    public static String toEllipsis(String str, int length, String ellipsis) {
        if (str.length() <= length) {
            return str;
        } else {
            return str.substring(0, length - ellipsis.length()) + ellipsis;
        }
    }

    public static String toFixedLength(String str, int length, char fillChar) {
        return toFixedLength(str, length, -1, fillChar);
    }

    /**
     * get fixed length string
     *
     * @param str       参数
     * @param length    长度
     * @param direction <0: from front; >0: from behind;
     * @param fillChar  fill the char in the lack of bit
     * @return 截取后的字符串
     */
    public static String toFixedLength(String str, int length, int direction, char fillChar) {
        if (str.length() >= length) {
            if (direction < 0) {
                return str.substring(0, length);
            } else {
                return str.substring(str.length() - length);
            }
        } else {
            StringBuilder fillStr = new StringBuilder();
            for (int i = 0; i < length - str.length(); i++) {
                fillStr.append(fillChar);
            }
            if (direction < 0) {
                return fillStr + str;
            } else {
                return str + fillStr;
            }
        }
    }

    /**
     * 字符串格式化长度不足补0
     * @param str
     * @param length
     * @param direction
     * @return
     */
    public static String addZeroForString(String str, int length,int direction) {
        if (str.length()>=length){
            return str.substring(0,length);
        }else {
            StringBuilder fillStr = new StringBuilder();
            for (int i = 0; i < length - str.length(); i++) {
                fillStr.append(NUM_ZERO);
            }
            if (direction < 0) {
                return fillStr + str;
            } else {
                return str + fillStr;
            }
        }
    }

    public static String getCode(String codeName) {
        return getCode(codeName, " ");
    }

    public static String getCode(String codeName, String splitStr) {
        if (codeName == null) {
            return null;
        }
        int index = codeName.indexOf(splitStr);
        return index == -1 ? codeName : codeName.substring(0, index);
    }

    public static String nullToEmpty(String str) {
        if (null == str) {
            return "";
        } else {
            return str;
        }
    }

    public static boolean isEmpty(Object obj) {
        if (null == obj) {
            return true;
        } else {
            return obj.toString().trim().length() == 0;
        }
    }

    public static String getNumStringWithNULL(String src, int num) {
        if (src == null) {
            src = "";
        }
        if (src.length() >= num) {
            return src.substring(0, num);
        } else {
            src = src.trim();
            StringBuffer sb = new StringBuffer(src);
            for (int i = src.length(); i < num; i++) {
                sb.append(" ");
            }
            return sb.toString();
        }
    }

    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }


    public static String getNumStringWithZero(String src, int num) {
        if (src.length() >= num) {
            return src;
        } else {
            StringBuilder sb = new StringBuilder(src);
            for (int i = src.length(); i < num; i++) {
                sb.insert(0, "0");
            }
            return sb.toString();
        }
    }

    /**
     * obj to String
     *
     * @param obj 对象参数
     * @return 字符串
     */
    public static String getAsString(Object obj) {
        if (obj == null) {
            return "";
        } else {
            return obj.toString();
        }
    }

    public static String getString0(Object obj) {
        if (obj == null) {
            return "0";
        } else {
            return obj.toString();
        }
    }

    public static String getStringNull(Object obj) {
        if (obj == null) {
            return null;
        } else {
            return obj.toString();
        }
    }

    /**
     * 判断字符串是否是金额
     *
     * @param str 参数
     * @return true or false
     */
    public static boolean isAmount(String str) {
        // 判断小数点后2位的数字的正则表达式
        Pattern pattern = Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$");
        Matcher match = pattern.matcher(str);
        return match.matches();
    }

    /**
     * 判断字符串是否是纯数字
     *
     * @param str 参数
     * @return true or false
     */
    public static boolean isNumeric(String str) {
        if (str != null && !"".equals(str.trim())) {
            return str.matches("^[0-9]*$");
        } else {
            return false;
        }
    }

    /**
     * 获取UUID字符串
     *
     * @return java.lang.String
     * @author lixbe
     * @date 2019/12/31
     **/
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 下划线转驼峰
     * user_name  ---->  userName
     * house.user_name  ---->  userName
     * userName   --->  userName
     *
     * @param underlineName 带有下划线的名字
     * @return 驼峰字符串
     */
    public static String underlineToCamel(String underlineName) {
        //截取下划线分成数组
        char[] charArray = underlineName.toCharArray();
        //判断上次循环的字符是否是"_"
        boolean underlineBefore = false;
        StringBuilder buffer = new StringBuilder();
        for (int i = 0, l = charArray.length; i < l; i++) {
            //判断当前字符是否是"_",如果跳出本次循环
            if (charArray[i] == 95) {
                underlineBefore = true;
            } else if (underlineBefore) {
                //如果为true，代表上次的字符是"_",当前字符需要转成大写
                buffer.append(charArray[i] -= 32);
                underlineBefore = false;
            } else { //不是"_"后的字符就直接追加
                buffer.append(charArray[i]);
            }
        }
        return buffer.toString();
    }

    /**
     * 驼峰转 下划线
     * userName  ---->  user_name
     * user_name  ---->  user_name
     *
     * @param humpName 驼峰命名
     * @return 带下滑线的String
     */
    public static String camelToUnderline(String humpName) {
        //截取下划线分成数组，
        char[] charArray = humpName.toCharArray();
        StringBuilder buffer = new StringBuilder();
        //处理字符串
        for (int i = 0, l = charArray.length; i < l; i++) {
            if (charArray[i] >= 65 && charArray[i] <= 90) {
                buffer.append("_").append(charArray[i] += 32);
            } else {
                buffer.append(charArray[i]);
            }
        }
        return buffer.toString();
    }

    /**
     * @Author huangwei
     * @Description 根据长度获取新字符串
     * @Date 2021/4/14 13:23
     * @Param [src, length]
     * @return java.lang.String
     **/
    public static String getStringByLength(String src,int length)throws Exception{
        byte[] newString;
        if(StringUtil.isEmpty(src)){
            newString = new byte[length];
        }else{
            newString = Arrays.copyOf(src.getBytes("GBK"),length);
        }
        return new String(newString,"GBK");
    }

    /**
     * @Author huangwei
     * @Description 根据字节范围截取字符串
     * @Date 2021/4/14 14:18
     * @Param [src, from, to]
     * @return java.lang.String
     **/
    public static String cutStringByRange(String src,int from,int to) throws Exception{
        String result = "";
        if(!StringUtil.isEmpty(src)){
            byte[] gbks = Arrays.copyOfRange(src.getBytes("GBK"), from, to);
            result = new String(gbks,"GBK");
        }
        return result;
    }
}
