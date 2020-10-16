# WeatherApp
WeatherApp is a Java Command Line Application for checking weather forecast in any location of given day.
App obtains forecasts from two weather APIs then response with averaged parameters values. It uses h2 data
base to store active forecasts in order to reuse them without api calls.

### APIs
Weather APIs using:<br>
<ul>OpenWeather API,</ul>
<ul>Weatherbit API.</ul>

### Usage
App runs with parameters below:
<ul>--city, --c [location given by city name],</ul>
<ul>--latitude, --lat [location given by latitude coordinate],</ul>
<ul>--longitude, --lon [location given by longitude coordinate],</ul>
<ul>--date, --d [forecast date in format yyyy-mm-dd] (optional),</ul>
Location must be given at least by city name or coordinates, if both are given then
app is using city parameter. In case when date isn't given, app responses with forecast
for tomorrow.

### Output
App responses with parameters below:
<ul>forecast date,</ul>
<ul>temperature (Celsius degree),</ul>
<ul>pressure (hPa) date,</ul>
<ul>humidity (%) date,</ul>
<ul>wind speed (m/s),</ul>
<ul>wind degree (degree).</ul>
    
