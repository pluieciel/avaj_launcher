package avajLauncher;

public class JetPlane extends Aircraft {
    private static final String[] msg = {
            "Suuuuuuuuuuunnnnnnnnnnn!",
            "It's raining. Better watch out for lighting.",
            "Blind as a cloud.",
            "OMG! Winter is coming!"
    };

    public JetPlane(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                System.out.println("JetPlane#" + this.name + "(" + this.id + ")" + " " + msg[0]);
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                break;
            case "RAIN":
                System.out.println("JetPlane#" + this.name + "(" + this.id + ")" + " " + msg[1]);
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
                break;
            case "FOG":
                System.out.println("JetPlane#" + this.name + "(" + this.id + ")" + " " + msg[2]);
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
                break;
            case "SNOW":
                System.out.println("JetPlane#" + this.name + "(" + this.id + ")" + " " + msg[3]);
                this.coordinates.setHeight(this.coordinates.getHeight() - 7);
        }
        if (this.coordinates.getHeight() == 0) {
            System.out.println("JetPlane#" + this.name + "(" + this.id + ")" + " landed. What a sad day.");
            this.weatherTower.unregister(this);
            System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register( this);
        System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}
