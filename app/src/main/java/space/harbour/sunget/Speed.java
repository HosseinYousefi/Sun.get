package space.harbour.sunget;

import io.realm.RealmObject;

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
