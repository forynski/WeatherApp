package weather.forecastsource.openweather;

import com.fasterxml.jackson.databind.ObjectMapper;
import weather.forecastsource.openweather.model.OpenWeatherCurrentForecast;
import weather.forecastsource.openweather.model.OpenWeatherResponse;
import org.apache.http.client.fluent.Request;

import java.io.IOException;

public class OpenWeather {
    private final static String URI_PATTERN = "https://api.openweathermap.org/data/2.5/onecall?lat=%f&lon=%f&exclude=minutely,hourly&units=metric&appid=%s";
    private final static ObjectMapper MAPPER = new ObjectMapper();

    private final String key;

    public OpenWeather(String key) {
        this.key = key;
    }

    public OpenWeatherCurrentForecast getForecast(String city) {
        //TODO
        return null;
    }

    public OpenWeatherCurrentForecast getForecast(double lat, double lon) {
        try {
            String uri = String.format(URI_PATTERN, lat, lon, key);

            String response = Request.Get(uri)
                    .execute().returnContent().asString();
            OpenWeatherResponse openWeatherResponse = MAPPER.readValue(response, OpenWeatherResponse.class);
            return openWeatherResponse.getCurrent();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}