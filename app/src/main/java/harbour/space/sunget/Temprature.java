package harbour.space.sunget;

public class Temprature implements Measurement {
    int value;

    public Temprature(int value) {
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
