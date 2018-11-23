package space.harbour.sunget;

import io.realm.RealmObject;

/**
 * Public class specifying the pressure
 * of the selected location
 * value (Double)
 */
public class Pressure extends RealmObject implements Measurement {
    double value;

    public Pressure(double value) {
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

    // pressure does not depend on the interface
}
