package space.harbour.sunget;

public class Pressure implements Measurement {
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
