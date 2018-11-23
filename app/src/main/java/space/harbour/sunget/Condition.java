package space.harbour.sunget;

import io.realm.RealmObject;

/**
 * Public class to get and set the
 * date, temperature and text of
 * the weather conditions of a
 * specific location
 */

public class Condition extends RealmObject {
    String date;
    String temp;
    String text;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
