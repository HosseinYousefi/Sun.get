package space.harbour.sunget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class WeatherInfoActivity extends Activity {
    private Weather weather;
    private TextView codeTextView;
    private TextView cityTextView;
    private TextView tempTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_info);
        Intent intent = getIntent();

        // Getting the data
        String code = intent.getStringExtra("code");
        String temp = intent.getStringExtra("temp");
        String city = intent.getStringExtra("city");

        // Retrieving objects
        codeTextView = findViewById(R.id.code);
        tempTextView = findViewById(R.id.temp);
        cityTextView = findViewById(R.id.city);

        // Initializing codeTextView
        // Finding the icon for the corresponding weather status
        String propertyName = "wi_yahoo_" + code;
        String codeText = getResources().getString(getResources().getIdentifier(propertyName, "string", getPackageName()));
        codeTextView.setText(codeText);

        // Initializing other views
        tempTextView.setText(temp);
        cityTextView.setText(city);
    }
}
