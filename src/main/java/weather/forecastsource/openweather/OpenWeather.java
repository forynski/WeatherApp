package weather.forecastsource.openweather;

import com.fasterxml.jackson.databind.ObjectMapper;
import weather.forecastsource.openweather.model.Coords;
import weather.forecastsource.openweather.model.OpenWeatherDailyForecast;
import weather.forecastsource.openweather.model.OpenWeatherResponse;
import weather.forecastsource.openweather.model.OpenWeatherWeatherResponse;
import weather.model.WeatherForecast;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

public class OpenWeather {
    private final static String URI_PATTERN = "https://api.openweathermap.org/data/2.5/onecall?lat=%f&lon=%f&exclude=minutely,hourly&units=metric&appid=%s";
    private final static String CITY_PATTERN = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s";
    private final static ObjectMapper MAPPER = new ObjectMapper();

    private final String key;

    public OpenWeather(String key) {
        this.key = key;
    }

    public WeatherForecast getForecast(String city) {
        return getForecast(city, getTomorrow());
    }

    public WeatherForecast getForecast(String city, LocalDate date) {
        try {
            String uri = String.format(CITY_PATTERN, city, key);
            String response = Request.Get(uri)
                    .execute().returnContent().asString();
            Coords coords = MAPPER.readValue(response, OpenWeatherWeatherResponse.class).getCoord();
            return getForecast(coords.getLat(), coords.getLon(), date);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public WeatherForecast getForecast(double lat, double lon) {
        return getForecast(lat, lon, getTomorrow());
    }

    public WeatherForecast getForecast(double lat, double lon, LocalDate date) {
        try {
            String uri = String.format(URI_PATTERN, lat, lon, key);

            String response = Request.Get(uri)
                    .execute().returnContent().asString();
            OpenWeatherResponse openWeatherResponse = MAPPER.readValue(response, OpenWeatherResponse.class);
            OpenWeatherDailyForecast forecastForDate = findForecastForDate(openWeatherResponse.getDaily(), date);
            return WeatherForecastMapper.fromOpenWeatherForecast(forecastForDate);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private OpenWeatherDailyForecast findForecastForDate(List<OpenWeatherDailyForecast> dailyForecasts, LocalDate date) {
        return dailyForecasts.stream()
                .filter(forecast -> date.equals(Instant.ofEpochSecond(forecast.getDateTime())
                        .atZone(ZoneId.systemDefault()).toLocalDate()))
                .findAny()
                .orElse(null);
    }

    private LocalDate getTomorrow() {
        return LocalDate.now().plusDays(1);
    }
}