package space.harbour.sunget;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

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
    Realm realm;
    Sun sun;

    // Setting the list when the AsyncQuery is loaded
    private RealmChangeListener<RealmResults<Weather>> realmChangeListener = weathers -> {
        mAdapter.setData(weathers);
    };

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

		// Get all the previous weathers in the database
        Realm.deleteRealm(Realm.getDefaultConfiguration());
        realm = Realm.getDefaultInstance();
        weathers = realm.where(Weather.class).findAllAsync();
        System.out.println("********************");
        System.out.println(weathers);
        weathers.addChangeListener(realmChangeListener);

        // Setting up recycler view
		mRecyclerView = findViewById(R.id.my_recycler_view);
		mRecyclerView.setHasFixedSize(true);
		mLayoutManager = new LinearLayoutManager(this);
		mRecyclerView.setLayoutManager(mLayoutManager);
		mAdapter = new WeatherAdapter();
		mRecyclerView.setAdapter(mAdapter);

        sun = new Sun();
        sun.get("barcelona", result -> {});
        sun.get("milano", result -> {});
	}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        weathers.removeAllChangeListeners();
        realm.close();
    }
}
