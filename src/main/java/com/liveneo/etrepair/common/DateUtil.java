package com.liveneo.etrepair.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    /**
     * Sting转换成日期
     * @param dateStr
     * @param format
     * @return
     */
    public static Date getDateForString(String dateStr, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * @Desc: 格式化日期
     * @Author: zhaoyy 2016年10月24日 下午3:46:15
     * @param date
     * @param format
     * @return
     */
    public static String formatDateToString(Date date, String format) {
        SimpleDateFormat datetimeFormat = new SimpleDateFormat(format);
        return datetimeFormat.format(date);
    }

    /**
     * 格式化日期时间
     * <p>
     * 日期时间格式yyyy-MM-dd HH:mm:ss
     * 
     * @return
     */
    public static String formatDatetime(Date date) {
        SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return datetimeFormat.format(date);
    }

    /**
     * 获取14位日期
     * @return
     */
    public static String getCurrentFullDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return dateFormat.format(now());
    }

    /**
     * 格式化日期
     * <p>
     * 日期格式yyyy-MM-dd
     * 
     * @return
     */
    public static String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
    
    /**
     * 格式化日期
     * <p>
     * 日期格式yyyy-MM-dd
     * 
     * @return
     */
    public static String formatDateNew(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        return dateFormat.format(date);
    }

    /**
     * 获得当前时间的<code>java.util.Date</code>对象
     * 
     * @return
     */
    public static Date now() {
        return new Date();
    }

    /**
     * 将字符串日期转换成java.util.Date类型
     * <p>
     * 日期时间格式yyyy-MM-dd
     * 
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date parseDate(String date) throws ParseException {
        if (date == null) {
            return null;
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(date);
        }
    }

    /**
     * 获取零点零分零秒date
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date getDateForNowDay(Date date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String dateStr = null;
            dateStr = sdf.format(date);
            Date today = sdf.parse(dateStr);
            return today;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
