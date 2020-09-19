package weather;

import forecastsource.OpenWeather;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        OpenWeather op = new OpenWeather("dc2e3052755d0f481c8219d9c7967696");
        System.out.println(op.getForecast(-1.466667, 52.916668));
    }
}
