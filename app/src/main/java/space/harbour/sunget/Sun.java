package space.harbour.sunget;

import org.json.JSONException;
import org.json.JSONObject;

import io.realm.Realm;

/**
 * Public class Sun getting and executing the
 * query defined in the public class WeatherTask.
 *
 * It reads the JSON Object we receive from the
 * weather API in order to give us the information
 * requested from the user in the UI.
 */
public class Sun {

    interface Delegate {
        void got(Weather result);
    }

    static public void get(String cityName, Delegate delegate) {
        new WeatherTask(result -> {

            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();
            JSONObject reader;
            Weather weather = null;
            try {
                reader = new JSONObject(result);
                reader = reader.getJSONObject("query");
                reader = reader.getJSONObject("results");
                reader = reader.getJSONObject("channel");
                if (reader.has("description") && !reader.isNull("description")) {
                    System.out.println(reader.toString());
                    weather = realm.createOrUpdateObjectFromJson(Weather.class, reader);
                    System.out.println(weather);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (delegate != null)
                delegate.got(weather);
            realm.commitTransaction();
            realm.close();

        }).execute(cityName);
    }
}
