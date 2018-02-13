package com.mahashakti.di.modules;

import android.app.Activity;
import android.content.Context;


import com.mahashakti.di.scopes.ActivityContext;
import com.mahashakti.di.scopes.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @PerActivity
    @Provides
    @ActivityContext
    public Context provideContext() {
        return activity;
    }
}
