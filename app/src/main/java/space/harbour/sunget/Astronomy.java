package space.harbour.sunget;

import java.time.LocalTime;

import io.realm.RealmObject;

/**
 * Public class to set and get the time
 * of the sunrise and sunset introducing
 * two parameters of an Object String
 */

public class Astronomy extends RealmObject {
    String sunrise;
    String sunset;

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }
}
