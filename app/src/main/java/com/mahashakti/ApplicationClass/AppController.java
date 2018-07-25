package com.mahashakti.ApplicationClass;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.facebook.stetho.Stetho;
import com.mahashakti.R;
import com.mahashakti.di.components.DaggerAppComponent;
import com.mahashakti.di.modules.HttpModule;
import com.mahashakti.di.modules.SharedPrefsHelper;
import com.mahashakti.utils.RxBus;

import com.mahashakti.di.components.AppComponent;
import com.vanniktech.emoji.EmojiManager;
import com.vanniktech.emoji.one.EmojiOneProvider;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;



public class AppController extends Application {


    private RxBus bus;
    private AppComponent component;


    @Override
    public void onCreate() {
        super.onCreate();

        EmojiManager.install(new EmojiOneProvider());
        Stetho.initializeWithDefaults(this);

        bus = new RxBus();

        component = DaggerAppComponent.builder().sharedPrefsHelper(new SharedPrefsHelper(this))
                .httpModule(new HttpModule(this))
                .build();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

    }

    public RxBus bus() {
        return bus;
    }
    public AppComponent getComponent() {
        return component;
    }



    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }



}
