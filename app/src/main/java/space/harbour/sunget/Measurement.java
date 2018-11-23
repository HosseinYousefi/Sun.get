package space.harbour.sunget;

/**
 * Interface enabling the customer to select
 * between metric and imperial measurement
 * for the temperature (Fahrenheit vs Celsius)
 * @param <T>
 */
public interface Measurement<T> {
    T getMetric();
    T getImperial();
}
