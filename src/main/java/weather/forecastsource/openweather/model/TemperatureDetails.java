package weather.forecastsource.openweather.model;

public class TemperatureDetails {
    private double day;
    private double night;
    private double min;
    private double max;
    private double eve;
    private double morn;

    public double getDay() {
        return day;
    }

    public void setDay(double day) {
        this.day = day;
    }

    public double getNight() {
        return night;
    }

    public void setNight(double night) {
        this.night = night;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getEve() {
        return eve;
    }

    public void setEve(double eve) {
        this.eve = eve;
    }

    public double getMorn() {
        return morn;
    }

    public void setMorn(double morn) {
        this.morn = morn;
    }

    @Override
    public String toString() {
        return "TemperatureDetails{" +
                "day=" + day +
                ", night=" + night +
                ", min=" + min +
                ", max=" + max +
                ", eve=" + eve +
                ", morn=" + morn +
                '}';
    }
}