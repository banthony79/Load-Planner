public class City {

    private String cityName;
    private double longt;
    private double lat;

    public City(String cityName, double longt, double lat) {
        this.cityName = cityName;
        this.longt = longt;
    }


    public String getCityName() {
        return cityName;
    }

    public double getLongt() {
        return longt;
    }

    public double getLat() {
        return lat;
    }
}