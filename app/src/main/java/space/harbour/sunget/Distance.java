package space.harbour.sunget;

public class Distance implements Measurement {
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
