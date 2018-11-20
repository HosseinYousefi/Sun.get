package space.harbour.sunget.Model;

import java.time.DayOfWeek;
import java.util.Date;

public class Forecast {
    int code;
    Date date;
    DayOfWeek day;
    Temprature high;
    Temprature low;
    String status; // text in API

    public Forecast(int code, Date date, DayOfWeek day, Temprature high, Temprature low, String status) {
        this.code = code;
        this.date = date;
        this.day = day;
        this.high = high;
        this.low = low;
        this.status = status;
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

    public Temprature getHigh() {
        return high;
    }

    public void setHigh(Temprature high) {
        this.high = high;
    }

    public Temprature getLow() {
        return low;
    }

    public void setLow(Temprature low) {
        this.low = low;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
