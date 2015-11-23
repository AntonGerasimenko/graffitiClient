package by.minsk.gerasimenko.anton.feed;

import android.app.Application;
import android.os.Build;

import by.minsk.gerasimenko.anton.feed.DB.DBManager;

/**
 * Created by gerasimenko on 30.09.2015.
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DBManager.getInstance().init(getApplicationContext());

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.FROYO) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        DBManager.getInstance().release();
    }
}
