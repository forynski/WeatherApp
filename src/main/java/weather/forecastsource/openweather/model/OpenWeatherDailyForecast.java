package weather.forecastsource.openweather.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherDailyForecast {
    @JsonProperty("dt")
    private long dateTime;
    @JsonProperty("temp")
    private TemperatureDetails temperatureDetails;
    private int pressure;
    private double humidity;

    @JsonProperty("wind_speed")
    private double windSpeed;

    @JsonProperty("wind_deg")
    private int windDegree;

    public long getDateTime() {
        return dateTime;
    }

    public void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }

    public TemperatureDetails getTemperatureDetails() {
        return temperatureDetails;
    }

    public void setTemperatureDetails(TemperatureDetails temperatureDetails) {
        this.temperatureDetails = temperatureDetails;
    }

    @JsonIgnore
    public double getTemp() {
        return temperatureDetails.getDay();
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getWindDegree() {
        return windDegree;
    }

    public void setWindDegree(int windDegree) {
        this.windDegree = windDegree;
    }

    @Override
    public String toString() {
        return "OpenWeatherDailyForecast{" +
                "dateTime=" + dateTime +
                ", temp=" + getTemp() +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", windSpeed=" + windSpeed +
                ", windDegree=" + windDegree +
                '}';
    }
}