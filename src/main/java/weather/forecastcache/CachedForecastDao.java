package weather.forecastcache;

import weather.DatabaseConfig;
import weather.model.CachedForecast;
import org.hibernate.Session;
import org.hibernate.Transaction;
import weather.model.WeatherSource;

import java.time.LocalDate;
import java.util.List;

public class CachedForecastDao {
    public void saveForecast(CachedForecast forecast) {
        try (Session session = DatabaseConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(forecast);

            transaction.commit();
//            session.close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<CachedForecast> listForecast() {
        try (Session session = DatabaseConfig.getSessionFactory().openSession()) {

            List<CachedForecast> forecasts = session
                    .createQuery("select f from CachedForecast f").list();

//        session.close();
            return forecasts;
        }
    }

    public CachedForecast findWeatherForecastForLocalization(WeatherSource source, String localization, LocalDate date) {
        try (Session session = DatabaseConfig.getSessionFactory().openSession()) {
            List<CachedForecast> forecasts = session
                    .createQuery("select f from CachedForecast f where f.source = source and f.localization = localization and f.date = date ").list();

            return forecasts.stream().findFirst().orElse(null);


        }
    }
}