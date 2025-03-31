package com.olympic.util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {
    public static Date convertUtiltoSQLDate(java.util.Date date){
        return new Date(date.getTime());
    }

    public static java.util.Date convertStringtoDate(String dateString){
        DateFormat formatter = new SimpleDateFormat("ddMMyyyy");
        java.util.Date date= null;
        try{
            date = formatter.parse(dateString);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return date;
    }
}
