package space.harbour.sunget;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Public class to set and get
 * climate information for one
 * location for one specific
 * day including the wind,
 * atmospheric, astronomic
 * information
 */
public class Weather extends RealmObject {

    @PrimaryKey
    String description;

    Location location;
    Wind wind;
    Atmosphere atmosphere;
    Astronomy astronomy;
    Item item;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
