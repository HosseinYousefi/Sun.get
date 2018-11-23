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
    String date;
    String day;
    String high;
    String low;
    String text;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
