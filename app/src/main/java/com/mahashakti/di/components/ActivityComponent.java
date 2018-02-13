package com.mahashakti.di.components;



import com.mahashakti.di.modules.ActivityModule;
import com.mahashakti.di.scopes.PerActivity;

import dagger.Component;


@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {


}
