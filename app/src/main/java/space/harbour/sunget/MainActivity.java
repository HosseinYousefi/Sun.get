package space.harbour.sunget;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class MainActivity extends Activity {
	private RecyclerView mRecyclerView;
	private WeatherAdapter mAdapter;
	private RecyclerView.LayoutManager mLayoutManager;
    private RealmResults<Weather> weathers;
    private EditText cityEditText;
    private Realm realm;

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    // Setting the list when the AsyncQuery is loaded
    private RealmChangeListener<RealmResults<Weather>> realmChangeListener = weathers -> mAdapter.setData(weathers);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		cityEditText = findViewById(R.id.cityEditText);

		// Get all the previous weathers in the database
        realm = Realm.getDefaultInstance();
        weathers = realm.where(Weather.class).findAllAsync();
        weathers.addChangeListener(realmChangeListener);

        // Setting up recycler view
		mRecyclerView = findViewById(R.id.my_recycler_view);
		mRecyclerView.setHasFixedSize(true);
		mLayoutManager = new LinearLayoutManager(this);
		mRecyclerView.setLayoutManager(mLayoutManager);
		mAdapter = new WeatherAdapter();
		mRecyclerView.setAdapter(mAdapter);

        // Updating the weathers in saved city
        if (isNetworkAvailable()) {
            for (Weather w: weathers) {
                Sun.get(w.location.city, null);
            }
        }

	}

    public void getWeather(View view) {
        String city = cityEditText.getText().toString();
        Sun.get(city, result -> {
            cityEditText.setText("");
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        weathers.removeAllChangeListeners();
        realm.close();
    }
}
