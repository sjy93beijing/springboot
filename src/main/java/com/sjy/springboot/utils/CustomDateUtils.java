package com.sjy.springboot.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by zhaoyangyang on 2018/9/7
 */
public class CustomDateUtils {
    static final Logger logger = LoggerFactory.getLogger(CustomDateUtils.class);


    /**
     * 格式化日期
     * @param date
     * @return
     */
    public static Date parse(String date,String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(date);
        } catch (Exception e) {
            logger.warn("parse date error:",e);
            return null;
        }
    }

    /**
     * 格式化日期
     * @param date
     * @return
     */
    public static String format(Date date,String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.format(date);
        } catch (Exception e) {
            logger.warn("parse date error:",e);
            return null;
        }
    }

    /**
     * 获取日期所在年和季度
     * @param d
     * @return
     */
    public static int[] calculateQuarter(Date d){
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        int month = c.get(Calendar.MONTH) + 1;
        int quarter = 0;
        if (month >= 1 && month <= 3) {
            quarter = 1;
        } else if (month >= 4 && month <= 6) {
            quarter = 2;
        } else if (month >= 7 && month <= 9) {
            quarter = 3;
        } else if (month >= 10 && month <= 12) {
            quarter = 4;
        }
        int[] qs=new int[2];
        int year=c.get(Calendar.YEAR);
        qs[0]=year;
        qs[1]=quarter;
        return qs;
    }


    public static void main(String[] args) { System.out.println(CustomDateUtils.format(new Date(),"yyyy-MM-dd HH"));
        System.out.println(CustomDateUtils.parse("2018-09-14 17:23:22", "yyyy-MM-dd HH").getTime());
        System.out.println(CustomDateUtils.parse(CustomDateUtils.format(new Date(), "yyyyMMddHH"), "yyyyMMddHH").getTime());
    }
}
