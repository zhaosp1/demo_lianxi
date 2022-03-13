package com.example.springboot.repository.util.time;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
* @Description:    数据格式工具类
* @Author:         xuyou
* @CreateDate:     2020/2/13 16:40
* @UpdateUser:     xuyou
* @UpdateDate:     2020/2/13 16:40
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class DataFormatUtil {

    public static String toDecimal(double number) {
        DecimalFormat dft = new DecimalFormat("##,##0.00");
        String str1 = dft.format(number);
        return str1;
    }

    /**
     * @Description 分割字符串，每隔三个字符放一个逗号
     * @Param str
     * @return java.lang.String
     * @author Luohc
     * @Date 2021/12/1
     */
    public static String formatStringWithComma(String str) {
        // 需要转换的整数
        String intStr = "";
        // 小数
        String decStr = "";
        if (str.contains(".")) {
            intStr = str.substring(0,str.indexOf("."));
            decStr = str.substring(str.indexOf("."));
        }else{
            intStr = str;
        }
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(new BigDecimal(intStr)) + decStr;
    }
}