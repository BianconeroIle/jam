package com.example.ilijaangeleski.jam_justaddmusic.di.components;

import android.content.Context;


import com.example.ilijaangeleski.jam_justaddmusic.api.NetworkApi;
import com.example.ilijaangeleski.jam_justaddmusic.di.modules.AppModule;
import com.example.ilijaangeleski.jam_justaddmusic.di.modules.NetworkModule;

import dagger.Component;

/**
 * Created by Ilija Angeleski on 1/10/2018.
 */
@Component(modules = {AppModule.class,NetworkModule.class})
public interface BaseComponent {
    Context getContext();

    NetworkApi getNetworkApi();
}
