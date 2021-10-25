package com.deal.demo.utils.trapeze;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author   创建人：luyibing
 * @version  版本号：1.0.0
 * @package  包名：com.jxp.utils.other
 * @fileName 类名：DateUtils
 * @date	 创建时间：2019/11/25 10:46
 * @Description	创建内容：日期工具类
 */
public class DateUtils {




    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String pattern_default = "yyyy-MM-dd HH:mm:ss";
    /**
     * yyyy-MM-dd
     */
    public static final String pattern_date = "yyyy-MM-dd";
    /**
     * yyyy/MM/dd
     */
    public static final String pattern_date2 = "yyyy/MM/dd";
    /**
     * HH:mm:ss
     */
    public static final String pattern_time = "HH:mm:ss";

    /**
     * yyyy-MM
     */
    public static final String pattern_month = "yyyy-MM";

    /**
     * 1秒钟的毫秒数
     */
    public static final int second = 1000;
    /**
     * 1分钟的毫秒数
     */
    public static final int minute = 60000;
    /**
     * 1小时的毫秒数
     */
    public static final int hour = 3600000;
    /**
     * 1天的毫秒数
     */
    public static final int day = 86400000;

    /** 对象格式化yyyy-MM-dd HH:mm:ss */
    public  final SimpleDateFormat longSdf = new SimpleDateFormat(
            pattern_default);

    /** 对象格式化yyyy-MM-dd */
    public  final SimpleDateFormat shortSdf = new SimpleDateFormat(
            pattern_default);

    /**
     * @return   返回值：String
     * @author   创建人：luyibing
     * @date	 创建时间：2019/11/25 11:22
     * @Description	创建内容： 返回使用默认格式yyyy-MM-dd HH:mm:ss格式化当前时间后的日期字符串
     * @modify   修改人：
     * @date	 修改时间：
     * @Description 修改内容：
     * @tittle   方法名：formatNow
     * @return_description  返回值说明： 返回格式化后的字符串
     * @version  版本号：1.0.0
     */
    public static String formatNow(){
        return DateFormatUtils.format(new Date(), pattern_default);
    }

    /**
     * @param    pattern：日期格式
     * @return   返回值：String
     * @author   创建人：luyibing
     * @date	 创建时间：2019/11/25 11:22
     * @Description	创建内容： 返回使用指定格式格式化当前时间后的日期字符串
     * @modify   修改人：
     * @date	 修改时间：
     * @Description 修改内容：
     * @tittle   方法名：formatNow
     * @return_description  返回值说明： 返回格式化后的字符串
     * @version  版本号：1.0.0
     */
    public static String formatNow(String pattern){
        return DateFormatUtils.format(new Date(), pattern);
    }


    /**
     * @param    date：日期
     * @param    pattern：格式
     * @return   返回值：String
     * @author   创建人：luyibing
     * @date	 创建时间：2019/11/25 11:22
     * @Description	创建内容： 返回使用指定格式格式化指定日期后的日期字符串
     * @modify   修改人：
     * @date	 修改时间：
     * @Description 修改内容：
     * @tittle   方法名：format
     * @return_description  返回值说明： 返回格式化后的字符串
     * @version  版本号：1.0.0
     */
    public static String format(Date date, String pattern){
        return DateFormatUtils.format(date, pattern);
    }

}


