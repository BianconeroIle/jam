package com.example.ilijaangeleski.jam_justaddmusic.di.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ilija Angeleski on 1/11/2018.
 */
@Module
public class AppModule {
    Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    Context provideContext(){
        return context;
    }
}
