package com.mahashakti.di.components;



import com.mahashakti.baseactivity.BaseActivity;
import com.mahashakti.di.modules.HttpModule;
import com.mahashakti.di.modules.SharedPrefsHelper;
import com.mahashakti.manager.GitApiInterface;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {HttpModule.class, SharedPrefsHelper.class})
public interface AppComponent {

    void inject(BaseActivity activity);

    GitApiInterface api();

}
