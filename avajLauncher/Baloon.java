package avajLauncher;

public class Baloon extends Aircraft {
    private static final String[] msg = {
            "Let's enjoy the good weather and take some pics.",
            "Damn you rain! You messed up my baloon.",
            "Too bad! We can see nothing.",
            "It's snowing. We're gonna crash."
    };

    public Baloon(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                System.out.println("Baloon#" + this.name + "(" + this.id + ")" + " " + msg[0]);
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
                this.coordinates.setHeight(this.coordinates.getHeight() + 4);
                break;
            case "RAIN":
                System.out.println("Baloon#" + this.name + "(" + this.id + ")" + " " + msg[1]);
                this.coordinates.setHeight(this.coordinates.getHeight() - 5);
                break;
            case "FOG":
                System.out.println("Baloon#" + this.name + "(" + this.id + ")" + " " + msg[2]);
                this.coordinates.setHeight(this.coordinates.getHeight() - 3);
                break;
            case "SNOW":
                System.out.println("Baloon#" + this.name + "(" + this.id + ")" + " " + msg[3]);
                this.coordinates.setHeight(this.coordinates.getHeight() - 15);
        }
        if (this.coordinates.getHeight() == 0) {
            System.out.println("Baloon#" + this.name + "(" + this.id + ")" + " crashed. Goodbye!");
            this.weatherTower.unregister(this);
            System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register( this);
        System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}
