package mahashakti.mahashakti.ApplicationClass;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.mahashakti.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by dharamveer on 8/1/18.
 */

public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

    }

    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }



}
