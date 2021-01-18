package com.example.alarms;

public class CalendarNumConverter {

    static String getDayName(int i)
    {
        switch (i)
        {
            case 0  :
                return "Monday";
            case 1  :
                return  "Tuesday";

            case 2  :
                return "Wednesday";
            case 3  :
                return "Thursday";
            case 4  :
                return "Friday";
            case 5  :
                return "Saturday";

            case 6  :
                return "Sunday";

            default:  return "Day Error";

        }
    }

    static String getMonthName(int i)
    {
        switch (i)
        {
            case 0  :
                return "January";
            case 1  :
                return  "February";

            case 2  :
                return "March";
            case 3  :
                return "April";
            case 4  :
                return "May";
            case 5  :
                return "June";

            case 6  :
                return "July";
            case 7  :
                return "August";
            case  8 :
                return "September";
            case  9 :
                return "October";
            case 10  :
                return "November";
            case 11  :
                return "December";

            default:  return "Month Error";

        }


    }
}
