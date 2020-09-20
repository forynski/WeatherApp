package weather;

import weather.forecastsource.openweather.OpenWeather;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        OpenWeather op = new OpenWeather(readKey());
        System.out.println(op.getForecast(-1.466667, 52.916668));
    }

    private static String readKey() {
        try {
            return Files.readAllLines(Paths.get("key.txt")).get(0).trim();
        } catch (IOException e) {
            return "";
        }
    }
}
