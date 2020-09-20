package weather.forecastsource.openweather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherWeatherResponse {
    private Coords coord;

    public Coords getCoord() {
        return coord;
    }

    public void setCoord(Coords coord) {
        this.coord = coord;
    }
}