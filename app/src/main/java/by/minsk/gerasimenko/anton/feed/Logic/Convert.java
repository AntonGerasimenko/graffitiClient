package by.minsk.gerasimenko.anton.feed.Logic;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by gerasimenko on 01.10.2015.
 */
public class Convert {

    private static Calendar calendar = Calendar.getInstance();

    public static String date(long date) {

        calendar.setTime(new Date(date));

        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH)+1;
        int year = calendar.get(Calendar.YEAR);

        return day +"."+month+"."+ year  ;
    }

}
