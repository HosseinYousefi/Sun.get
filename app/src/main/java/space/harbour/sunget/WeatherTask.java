package space.harbour.sunget;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import io.realm.Realm;


/**
 * Public class WeatherTask asynchronously performs a task
 * in the background without the requirement to proactively
 * manipulate the threads individually
 * onPreExecute is used to setup the task
 * doInBackground is a task with computational efforts being
 * executed immediately after onPreExecute and results will be
 * published in next step
 * onPostExecute is invoked as soon as the background computation
 * finishes and a result should be passed as a parameter
 *
 * In general words this class enables us to execute the search
 * query in the background while the user sees a potential
 * progress bar in the UI
 */
public class WeatherTask extends AsyncTask<String, Void, String> {
    final static String API_ADDRESS = "https://query.yahooapis.com/v1/public/yql?";
    final static String YQL_QUERY = "q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22$city$%22)";
    final static String CONFIG = "&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";

    Realm realm;

    interface Delegate {
        void taskFinished(String result);
    }

    Delegate delegate;

    public WeatherTask(Delegate delegate) {
        realm = Realm.getDefaultInstance();
        this.delegate = delegate;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    /**
     * The method doInBackground is responsible for the background
     * computation in order to get the weather API built up
     *
     *
     * @param strings
     * @return a String with the weather conditions for the requested
     * city
     */
    @Override
    protected String doInBackground(String... strings) {
        try {
            StringBuilder result = new StringBuilder();
            String city = strings[0];
            city.replace(" ", "%20");
            String query = YQL_QUERY.replace("$city$", city);
            String address = API_ADDRESS + query + CONFIG;
            URL url = new URL(address);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = urlConnection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"), 8);
            String line;
            while ((line = reader.readLine()) != null)
                result.append(line + "\n");
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "FAILED";
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        delegate.taskFinished(s);
    }
}