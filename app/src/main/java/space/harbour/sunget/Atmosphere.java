package space.harbour.sunget;

import io.realm.RealmObject;

/**
 * Public class to set and get
 * key values of the atmospheric conditions
 * Humidity is defined as and Integer
 * Pressure is defined as an Object of Pressure
 * Visibility is defined as a Double
 */

public class Atmosphere extends RealmObject {
    String humidity;
    String pressure;
    String rising;
    String visibility;

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getRising() {
        return rising;
    }

    public void setRising(String rising) {
        this.rising = rising;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }
}
