package weather;

import weather.forecastcache.WeatherForecastDao;
import weather.forecastsource.openweather.OpenWeather;
import org.apache.commons.cli.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        String key = Files.readAllLines(Paths.get("key.txt")).get(0).trim();
        OpenWeather forecastSource = new OpenWeather(key);

        callWithArbitraryArguments(forecastSource);

        callWithPassedArguments(forecastSource, args);

        WeatherForecastDao dao = new WeatherForecastDao();
        dao.saveForecast(forecastSource.getForecast("Rzeszow"));

        System.out.println(dao.listForecast());
    }

    private static void callWithPassedArguments(OpenWeather forecastSource, String[] args) {
        LocalDate tomorrow = LocalDate.now().plusDays(1);

        System.out.println(Arrays.toString(args));
        CommandLine commandLine = parseCommandLine(args);
        if (Objects.nonNull(commandLine)) {
            System.out.println(commandLine.getOptionValue("date"));
            System.out.println(commandLine.getArgList());
            List<String> arguments = commandLine.getArgList();

            // if date is not passed in commandline, use tomorrow
            LocalDate date = commandLine.hasOption("date") ? LocalDate.parse(commandLine.getOptionValue("date")) : tomorrow;

            if (arguments.size() == 1) {
                // a single argument means it should be a city name
                String city = arguments.get(0);
                System.out.println(String.format("Forecast for city: %s, on date: %s", city, date));
                System.out.println(forecastSource.getForecast(city, date));
            } else if (arguments.size() == 2) {
                // two arguments means it should be coordinates
                double lat = Double.valueOf(arguments.get(0));
                double lon = Double.valueOf(arguments.get(1));
                System.out.println(String.format("Forecast for location: (%f, %f), on date: %s", lat, lon, date));
                System.out.println(forecastSource.getForecast(lat, lon, date));
            }
        }
    }
    private static void callWithArbitraryArguments(OpenWeather forecastSource) {
        LocalDate fiveDaysForward = LocalDate.now().plusDays(5);

        System.out.println(forecastSource.getForecast(52.916668, -1.466667));
        System.out.println(forecastSource.getForecast("Derby"));

        System.out.println(forecastSource.getForecast(52.916668, -1.466667));
        System.out.println(forecastSource.getForecast("Derby"));
    }

    private static CommandLine parseCommandLine(String[] args) {
        try {
            CommandLineParser parser = new GnuParser();
            Options options = new Options();
            options.addOption("d", "date", true, "date to get forecast for");
            return parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println("An error occured during argument parsing");
            return null;
        }
    }
}