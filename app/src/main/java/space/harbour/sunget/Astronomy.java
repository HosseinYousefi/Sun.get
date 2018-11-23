package space.harbour.sunget;

import java.time.LocalTime;

import io.realm.RealmObject;

public class Astronomy extends RealmObject {
    LocalTime sunrise;
    LocalTime sunset;

    public Astronomy(LocalTime sunrise, LocalTime sunset) {
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public LocalTime getSunrise() {
        return sunrise;
    }

    public void setSunrise(LocalTime sunrise) {
        this.sunrise = sunrise;
    }

    public LocalTime getSunset() {
        return sunset;
    }

    public void setSunset(LocalTime sunset) {
        this.sunset = sunset;
    }
}
