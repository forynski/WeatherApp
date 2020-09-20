package weather;

import weather.model.WeatherForecast;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class DatabaseConfig {

    private static SessionFactory sessionFactory;

    private static Properties getSettings() {
        Properties settings = new Properties();

        settings.put(Environment.URL, "jdbc:h2:file:./test.db");
        settings.put(Environment.USER, "SA");
        settings.put(Environment.PASS, "");
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.HBM2DDL_AUTO, "create-drop");
        // optional in most cases
        settings.put(Environment.DRIVER, "org.h2.Driver");
        settings.put(Environment.DIALECT,
                "org.hibernate.dialect.H2Dialect");

        return settings;
    }

    private static SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration();
        // Hibernate settings equivalent to hibernate.cfg.xml's properties
        configuration.setProperties(getSettings());

        configuration.addAnnotatedClass(WeatherForecast.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = createSessionFactory();
        }
        return sessionFactory;
    }
}