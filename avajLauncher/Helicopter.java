package avajLauncher;

public class Helicopter extends Aircraft {
    private static final String[] msg = {
            "This is hot.",
            "Too much water.",
            "Better to land in such foggy conditions.",
            "My rotor is going to freeze!"
    };

    public Helicopter(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                System.out.println("Helicopter#" + this.name + "(" + this.id + ")" + " " + msg[0]);
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                break;
            case "RAIN":
                System.out.println("Helicopter#" + this.name + "(" + this.id + ")" + " " + msg[1]);
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
                break;
            case "FOG":
                System.out.println("Helicopter#" + this.name + "(" + this.id + ")" + " " + msg[2]);
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
                break;
            case "SNOW":
                System.out.println("Helicopter#" + this.name + "(" + this.id + ")" + " " + msg[3]);
                this.coordinates.setHeight(this.coordinates.getHeight() - 12);
        }
        if (this.coordinates.getHeight() == 0) {
            System.out.println("Helicopter#" + this.name + "(" + this.id + ")" + " landed safely. Miracle!");
            this.weatherTower.unregister(this);
            System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register( this);
        System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}
