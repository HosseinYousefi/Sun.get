package space.harbour.sunget;

import io.realm.RealmObject;

/**
 * Public class specifying the wind
 * speed in either km/h or miles/h
 * value (Double)
 */
public class Speed extends RealmObject implements Measurement {
    double value;

    public Speed(double value) {
        this.value = value;
    }

    @Override
    public Double getMetric() {
        return null;
    }

    @Override
    public Double getImperial() {
        return null;
    }
}
