package com.zheng.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-22.
 */
public class DateFromatUtil {
   public    static  String  YYYYMMDD="yyyymmdd";
    public   static  String  YYYYMMDDHHMMSS="yyyyMMddhhmmss";
    public  static  String  YYYY_MM_DD="yyyy-MM-dd";

    public static  String   fromatDate(Date date, String fromat){
        SimpleDateFormat  format = new SimpleDateFormat(fromat);
        return  format.format(date).toString();
    }
}
