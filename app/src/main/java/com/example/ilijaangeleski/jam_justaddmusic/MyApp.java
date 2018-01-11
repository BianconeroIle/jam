package com.example.ilijaangeleski.jam_justaddmusic;

import android.app.Application;

import com.example.ilijaangeleski.jam_justaddmusic.di.components.BaseComponent;
import com.example.ilijaangeleski.jam_justaddmusic.di.components.DaggerBaseComponent;
import com.example.ilijaangeleski.jam_justaddmusic.di.modules.AppModule;
import com.example.ilijaangeleski.jam_justaddmusic.di.modules.NetworkModule;

/**
 * Created by Ilija Angeleski on 1/10/2018.
 */

public class MyApp extends Application {
    private BaseComponent baseComponent;
    private static MyApp myApp;

    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
        baseComponent = DaggerBaseComponent
                .builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    public BaseComponent getBaseComponent(){
        return baseComponent;
    }

    public static MyApp getMyApp(){
        return myApp;
    }
}
