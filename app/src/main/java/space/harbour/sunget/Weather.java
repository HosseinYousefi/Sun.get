package space.harbour.sunget;

import io.realm.RealmObject;

/**
 * Public class weather providing the climate
 * information for one location for one specific
 * day defined in the item
 * location (Location)
 * wind (Wind)
 * atmosphere (Atmosphere)
 * astronomy (Astronomy)
 */
public class Weather extends RealmObject {
    Location location;
    Wind wind;
    Atmosphere atmosphere;
    Astronomy astronomy;
    Item item;

    public Weather(Location location, Wind wind, Atmosphere atmosphere, Astronomy astronomy, Item item) {
        this.location = location;
        this.wind = wind;
        this.atmosphere = atmosphere;
        this.astronomy = astronomy;
        this.item = item;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }

    public Astronomy getAstronomy() {
        return astronomy;
    }

    public void setAstronomy(Astronomy astronomy) {
        this.astronomy = astronomy;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
