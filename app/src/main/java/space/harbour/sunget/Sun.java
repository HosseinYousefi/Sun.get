package space.harbour.sunget;

import org.json.JSONException;
import org.json.JSONObject;

import io.realm.Realm;

public class Sun {

    interface Delegate {
        void got(Weather result);
    }

    static public void get(String cityName, Delegate delegate) {
        new WeatherTask(result -> {

            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();
            JSONObject reader;
            try {
                reader = new JSONObject(result);
                reader = reader.getJSONObject("query");
                reader = reader.getJSONObject("results");
                reader = reader.getJSONObject("channel");
                System.out.println(reader.toString());;
                Weather weather = realm.createOrUpdateObjectFromJson(Weather.class, reader);
                System.out.println(weather);
                delegate.got(weather);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            realm.commitTransaction();;
            realm.close();

        }).execute(cityName);
    }
}
