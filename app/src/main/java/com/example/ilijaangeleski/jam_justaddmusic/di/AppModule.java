package com.example.ilijaangeleski.jam_justaddmusic.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ilija Angeleski on 1/10/2018.
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
