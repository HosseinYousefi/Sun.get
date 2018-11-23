package space.harbour.sunget;

import java.time.ZonedDateTime;

import io.realm.RealmObject;

/**
 * Public class to get and set the
 * parameter code, date, temperature and status
 * Code is an Integer 
 */
public class Condition extends RealmObject {
    int code;
    ZonedDateTime date;
    Temperature temp;
    String text;

    public Condition(int code, ZonedDateTime date, Temperature temp, String text) {
        this.code = code;
        this.date = date;
        this.temp = temp;
        this.text = text;
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

    public Temperature getTemp() {
        return temp;
    }

    public void setTemp(Temperature temp) {
        this.temp= temp;
    }

    public String getText() {
        return text;
    }

    public void setText(String status) {
        this.text = text;
    }
}
