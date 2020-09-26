package weather.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class CachedForecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private WeatherForecast forecast;

    private WeatherSource source;
    private String localization;
    private LocalDate date;
    private LocalDateTime created;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public WeatherForecast getForecast() {
        return forecast;
    }

    public void setForecast(WeatherForecast forecast) {
        this.forecast = forecast;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public WeatherSource getSource() {
        return source;
    }

    public void setSource(WeatherSource source) {
        this.source = source;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "CachedForecast{" +
                "id=" + id +
                ", forecast=" + forecast +
                ", source=" + source +
                ", localization='" + localization + '\'' +
                ", date=" + date +
                ", created=" + created +
                '}';
    }
}