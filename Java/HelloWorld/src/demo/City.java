package demo;

public class City {
    private String name;
    String[] args;
    private double latitude;
    private double longitude;

    public void setName(String name) {
        this.name = name;
    }

    public void setArgs(String... args) {
        this.args = args;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return new String(name + "latitude:" + latitude + " longitude:" + longitude + ":" );
    }
}
