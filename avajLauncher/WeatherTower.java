package avajLauncher;

public class WeatherTower extends Tower {
    private final WeatherProvider weatherProvider = WeatherProvider.getInstance();

    public String getWeather(Coordinates coordinates) {
        return weatherProvider.getCurrentWeather(coordinates);
    }
    public void changeWeather() throws InvalidMethodException {
        this.conditionChanged();
    }
}
