package info.slifers.allstarworkouts;

import android.app.Application;
import android.util.Log;

import com.orhanobut.hawk.Hawk;
import com.orm.SugarContext;

/**
 * Created by user on 9/26/2016.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        SugarContext.init(this);
        Log.d("Init... ", "SugarContext**********");
        // Normal app init code...
        Hawk.init(getApplicationContext()).build();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }
}
