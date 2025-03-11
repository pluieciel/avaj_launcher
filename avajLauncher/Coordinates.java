package avajLauncher;

public class Coordinates {

    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int longitude, int latitude, int height) throws InputException {
        if (longitude < 0 || latitude < 0 || height < 0) {
            throw new InputException("Coordinates should be positive numbers");
        }
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = Math.min(100, height);
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setHeight(int height) {
        this.height = Math.min(100, Math.max(height, 0));
    }
}