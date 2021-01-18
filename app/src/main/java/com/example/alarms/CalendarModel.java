package com.example.alarms;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarModel {

    private Calendar calendar;

    public CalendarModel()
    {
        Date date = new Date();
        calendar = new GregorianCalendar();
        calendar.setTime(date);
    }

    int getMonth()
    {
        return calendar.get(Calendar.MONTH);
    }
    int getdayNum()
    {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }
    int getDay()
    {
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

}
