package space.harbour.sunget;

import java.time.DayOfWeek;
import java.util.Date;

import io.realm.RealmObject;

/**
 * Public class specifying the weather conditions
 * of a forecast value
 * code (Integer) defines the conditions
 * date (Object Date) defines the date of the forecast
 * day (Object DayOfWeek) defines a weekday
 * high (Object Temperature) is maximum of temperature that day
 * low (Object Temperature) is minimum of temperature that day
 */
public class Forecast extends RealmObject {
    int code;
    Date date;
    DayOfWeek day;
    Temperature high;
    Temperature low;
    String text; // text in API

    public Forecast(int code, Date date, DayOfWeek day, Temperature high, Temperature low, String status) {
        this.code = code;
        this.date = date;
        this.day = day;
        this.high = high;
        this.low = low;
        this.text = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public Temperature getHigh() {
        return high;
    }

    public void setHigh(Temperature high) {
        this.high = high;
    }

    public Temperature getLow() {
        return low;
    }

    public void setLow(Temperature low) {
        this.low = low;
    }

    public String getText() {
        return text;
    }

    public void setStatus(String status) {
        this.text = status;
    }
}
