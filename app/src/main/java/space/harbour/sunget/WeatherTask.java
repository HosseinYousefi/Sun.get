package space.harbour.sunget;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherTask extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... strings) {
        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL(strings[0]);
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
}
