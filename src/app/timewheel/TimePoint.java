package app.timewheel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dimmy
 */
public class TimePoint {
    public int year;
    public int month;
    public int day;
    public int hour;
    public int minute;
    public int second;

    public TimePoint(int year, int month, int day, int hour, int minute, int second) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public long format() {
        return dateToTimeStamp(year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second);
    }

    private long dateToTimeStamp(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }

        return date.getTime();
    }
}
