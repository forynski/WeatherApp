package weather.forecastsource.openweather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherResponse {
    private double lat;
    private double lon;
    private OpenWeatherCurrentForecast current;
    private List<OpenWeatherDailyForecast> daily;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public OpenWeatherCurrentForecast getCurrent() {
        return current;
    }

    public void setCurrent(OpenWeatherCurrentForecast current) {
        this.current = current;
    }

    public List<OpenWeatherDailyForecast> getDaily() {
        return daily;
    }

    public void setDaily(List<OpenWeatherDailyForecast> daily) {
        this.daily = daily;
    }
}