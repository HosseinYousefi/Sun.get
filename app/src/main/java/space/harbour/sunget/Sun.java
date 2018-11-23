package space.harbour.sunget;

public class Sun {
    public void get(String cityName, WeatherTask.Delegate delegate) {
        WeatherTask weatherTask = new WeatherTask();
        weatherTask.delegate = delegate;
        weatherTask.execute(cityName);
    }
}
