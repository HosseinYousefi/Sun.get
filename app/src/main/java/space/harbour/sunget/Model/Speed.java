package space.harbour.sunget.Model;

public class Speed implements Measurement {
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
