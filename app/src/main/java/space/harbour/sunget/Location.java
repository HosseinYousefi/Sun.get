package space.harbour.sunget;

import io.realm.RealmObject;

/**
 * Public class specifying the location
 * attributes down to city level
 * city (String)
 * country (String)
 * region (String)
 */
public class Location extends RealmObject {
    String city;
    String country;
    String region;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
