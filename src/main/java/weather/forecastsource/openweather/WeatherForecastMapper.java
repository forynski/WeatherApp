package weather.forecastsource.openweather;

import weather.forecastsource.openweather.model.OpenWeatherDailyForecast;
import weather.model.WeatherForecast;

public class WeatherForecastMapper {
    public static WeatherForecast fromOpenWeatherForecast(OpenWeatherDailyForecast forecast) {
        WeatherForecast result = new WeatherForecast();

        result.setHumidity(forecast.getHumidity());
        result.setPressure(forecast.getPressure());
        result.setTemperature(forecast.getTemp());
        result.setWindDegree(forecast.getWindDegree());
        result.setWindSpeed(forecast.getWindSpeed());

        return result;
    }
}