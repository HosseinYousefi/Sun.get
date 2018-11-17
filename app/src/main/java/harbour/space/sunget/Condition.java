package harbour.space.sunget;

import java.time.ZonedDateTime;

public class Condition {
    int code;
    ZonedDateTime date;
    Temprature temprature; // temp in API
    String status; // text in API

    public Condition(int code, ZonedDateTime date, Temprature temprature, String status) {
        this.code = code;
        this.date = date;
        this.temprature = temprature;
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public Temprature getTemprature() {
        return temprature;
    }

    public void setTemprature(Temprature temprature) {
        this.temprature = temprature;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
