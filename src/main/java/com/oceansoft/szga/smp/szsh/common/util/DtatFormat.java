package com.oceansoft.szga.smp.szsh.common.util;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author wx
 * 数据格式处理
 * @version 2018/10/18
 */
public class DtatFormat {

    /**
     * 获取百分比
     * */
    public static String GetPercent(Integer num1, Integer num2){

        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(2);
        return numberFormat.format((float) num1 / (float) num2 * 100);
    }

    /**
     * 格式化日期
     * */
    public static String GetDateToString(Date date, String formatString){
        SimpleDateFormat sdf = new SimpleDateFormat(formatString);
        return sdf.format(date);
    }

    /**
     * 日期计算
     * @param date 指定日期
     * @param amount 天数
     * */
    public static Date ComputeDate(Date date, Integer amount){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE,amount);
        return calendar.getTime();
    }

}
