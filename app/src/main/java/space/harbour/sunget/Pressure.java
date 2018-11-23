package space.harbour.sunget;

import io.realm.RealmObject;

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
}
