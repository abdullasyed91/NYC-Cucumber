package utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    //Print month and year
    public static String returnNextMonth() {
        //Create Date object
        Date dNow = new Date( );
        //Create calendar object for Gregorian Calendar
        Calendar calendar = new GregorianCalendar();
        //Set calendar date to current date
        calendar.setTime(dNow);

        //Create object for simpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");
        //Incrementing the current month
        calendar.add(Calendar.MONTH,1);
        //Generating the date based on the specified format
        String date = sdf.format(calendar.getTime());

        return date;
    }
}
