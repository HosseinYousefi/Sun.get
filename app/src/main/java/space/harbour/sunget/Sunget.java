package space.harbour.sunget;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Public class Sunget extends base class Application
 * for maintaining global application state. Sunget,
 * the subclass of the Application class, is instantiated
 * before any other class when the process for your
 * application/package is created.
 */
public class Sunget extends Application {


    /**
     * Called when the application is starting, before any activity, service,
     * or receiver objects (excluding content providers) have been created.
     * Realm library is initiated and thereafter an instance of the Realm
     * library is created to store the Realm file in the own internal
     * directory
     */
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().name("default.realm").build();
        Realm.setDefaultConfiguration(config);
    }
}
