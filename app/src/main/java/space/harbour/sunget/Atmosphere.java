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
    int humidity;
    Pressure pressure;
    int rising;
    double visibility;

    public Atmosphere(int humidity, Pressure pressure, int rising, double visibility) {
        this.humidity = humidity;
        this.pressure = pressure;
        this.rising = rising;
        this.visibility = visibility;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public Pressure getPressure() {
        return pressure;
    }

    public void setPressure(Pressure pressure) {
        this.pressure = pressure;
    }

    public int getRising() {
        return rising;
    }

    public void setRising(int rising) {
        this.rising = rising;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }
}
