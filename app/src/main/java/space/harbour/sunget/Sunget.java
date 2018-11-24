package space.harbour.sunget;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class Sunget extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().name("default.realm").build();
        Realm.setDefaultConfiguration(config);
    }
}
