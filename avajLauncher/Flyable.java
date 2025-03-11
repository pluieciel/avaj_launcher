package avajLauncher;

import avajLauncher.WeatherTower;

public abstract class Flyable {
    protected WeatherTower weatherTower;
    public abstract void updateConditions() throws InvalidMethodException;
    public void registerTower(WeatherTower tower) throws InvalidMethodException {
        throw new InvalidMethodException("Method should be implemented by subclass");
    }
}