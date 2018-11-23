package space.harbour.sunget;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Item extends RealmObject {
    Condition condition;
    RealmList<Forecast> forecast;

    public Item(Condition condition, RealmList<Forecast> forecast) {
        this.condition = condition;
        this.forecast = forecast;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public RealmList<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(RealmList<Forecast> forecast) {
        this.forecast = forecast;
    }
}
