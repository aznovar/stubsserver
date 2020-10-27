package com.stubserver.helpers;

import lombok.experimental.UtilityClass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@UtilityClass
public class DateGenerator {

    public static String getDate(String format){
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getDateWithMills(String format, int mills){
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();

        // convert date to calendar
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MILLISECOND, mills);

        //convert calendar to date
        date = c.getTime();
        return dateFormat.format(date);
    }
}
