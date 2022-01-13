public class aeroport {

    private String IATA;
    private String Name;
    private String country;
    private Double latitude;
    private Double longitude;


    public aeroport( String IATA , String Name , String country , Double latitude , Double longitude) {
        this.IATA = IATA;
        this.Name = Name;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;

    }
    public String getIATA() {
        return IATA;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "aeroport{" +
                "IATA='" + IATA + '\'' +
                ", Name='" + Name + '\'' +
                ", country='" + country + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

}
