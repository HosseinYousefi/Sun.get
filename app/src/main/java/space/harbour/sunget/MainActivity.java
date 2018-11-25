package space.harbour.sunget;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

/**
 * Public class extending Activity and representing
 * the main activity our users can perform - looking
 * up the weather for specific cities.
 * The activity is initialized by the method onCreate
 * (more details below)
 *
 */
public class MainActivity extends Activity {
	private RecyclerView mRecyclerView;
	private WeatherAdapter mAdapter;
	private RecyclerView.LayoutManager mLayoutManager;
    private RealmResults<Weather> weathers;
    private EditText cityEditText;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private Realm realm;

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    // Setting the list when the AsyncQuery is loaded
    private RealmChangeListener<RealmResults<Weather>> realmChangeListener = weathers -> mAdapter.setData(weathers);

    /**
     * This method is used to initialize the activity.
     * Initially, the content is set to a specific view
     * by setContentView
     * Thereafter, we get the previous weather data from
     * the database by accessing Realm.
     * With the gathered data we will set up the UI for
     * the user by accessing the recycler view.
     *
     *
     * @param savedInstanceState from a String keys to various values
     */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		cityEditText = findViewById(R.id.cityEditText);

        // Setting up recycler view
        mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new WeatherAdapter(getApplicationContext());
        mRecyclerView.setAdapter(mAdapter);

        // Setting up the animation
        mRecyclerView.setItemAnimator(new SlideInUpAnimator());

		// Get all the previous weathers in the database
        // Realm.deleteRealm(Realm.getDefaultConfiguration()); // Resetting the DB
        realm = Realm.getDefaultInstance();
        weathers = realm.where(Weather.class).findAllAsync();
        weathers.addChangeListener(realmChangeListener);

        // Setting swipe to refresh
        mSwipeRefreshLayout = findViewById(R.id.swipe_refresh);
        mSwipeRefreshLayout.setOnRefreshListener(() -> refreshData());

        // Updating the weathers in saved city
        refreshData();

	}

    /**
     *
     * @param view
     */
    public void getWeather(View view) {
        String city = cityEditText.getText().toString();
        Sun.get(city, result -> {
            if (result != null)
                cityEditText.setText("");
            else
                Toast.makeText(this.mRecyclerView.getContext(), cityEditText.getText() + " is not a valid city!", Toast.LENGTH_SHORT).show();
        });
    }

    public void refreshData() {
        if (isNetworkAvailable()) {
            for (Weather w: weathers) {
                Sun.get(w.location.city, null);
            }
        } else {
            Toast.makeText(this.mRecyclerView.getContext(), "No internet connection!", Toast.LENGTH_SHORT).show();
        }
        mSwipeRefreshLayout.setRefreshing(false);
    }

    // Loading the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_refresh:
                refreshData();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        weathers.removeAllChangeListeners();
        realm.close();
    }
}
