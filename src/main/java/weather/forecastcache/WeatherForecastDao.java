package weather.forecastcache;

import weather.DatabaseConfig;
import weather.model.WeatherForecast;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class WeatherForecastDao {
    public void saveForecast(WeatherForecast forecast) {
         try(Session session = DatabaseConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(forecast);

            transaction.commit();
//            session.close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<WeatherForecast> listForecast() {
        Session session = DatabaseConfig.getSessionFactory().openSession();

        List<WeatherForecast> forecasts = session
                .createQuery("select w from WeatherForecast w").list();

//        session.close();
        return forecasts;
    }
}