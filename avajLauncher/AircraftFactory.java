package avajLauncher;

public class AircraftFactory {
    private static AircraftFactory instance = null;
    private static long id = 1;

    private AircraftFactory() {}

    public static AircraftFactory getInstance() {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }

    public Flyable newAirCraft(String type, String name, Coordinates coordinates) throws UnknownAircraftException {
        return switch (type) {
            case "Baloon" -> new Baloon(id++, name, coordinates);
            case "JetPlane" -> new JetPlane(id++, name, coordinates);
            case "Helicopter" -> new Helicopter(id++, name, coordinates);
            default -> throw new UnknownAircraftException("Unknown type of aircraft, only Baloon, JetPlane and Helicopter are supported");
        };
    }
}
