package space.harbour.sunget;

import io.realm.RealmObject;

/**
 * Public class enabling the user to
 * see the distance parameter in the
 * metric (km) or imperial (miles) method
 */
public class Distance extends RealmObject implements Measurement {
    int value;

    public Distance(int value) {
        this.value = value;
    }

    @Override
    public Integer getMetric() {
        return null;
    }

    @Override
    public Integer getImperial() {
        return null;
    }
}
