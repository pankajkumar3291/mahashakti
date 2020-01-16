package com.mahashakti.di.modules;


import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.GsonBuilder;
import com.mahashakti.BuildConfig;
import com.mahashakti.manager.GitApiInterface;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import com.mahashakti.ApplicationClass.AppController;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Module
public class HttpModule {

    private AppController appController;

    public HttpModule(AppController appController) {
        this.appController = appController;
    }

    @Provides
    @Singleton
    public OkHttpClient provideHttpLogging() {
        Cache cache = new Cache(appController.getCacheDir(), 10 * 1024 * 1024);
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);


        return new OkHttpClient.Builder().addInterceptor(logging).addNetworkInterceptor(new StethoInterceptor()).readTimeout(180, TimeUnit.SECONDS).cache(cache).build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {

        return new Retrofit.Builder()
                .baseUrl("http://smartit.ventures/mahash/public/api/api/")    // .baseUrl(BuildConfig.SERVER_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    public GitApiInterface provideApiService(Retrofit retrofit) {
        return retrofit.create(GitApiInterface.class);
    }
}
