package gabilam.com.loginexample;

import android.app.Application;

import com.firebase.client.Firebase;
import com.firebase.client.Logger;

/**
 * Created by gabrielmarcos on 1/4/16.
 */
public class ExampleApplication extends Application {

    public static final String FIREBASE_URL = "https://gabilamlogintest.firebaseio.com/";

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
        Firebase.getDefaultConfig().setLogLevel(Logger.Level.DEBUG);
    }
}
