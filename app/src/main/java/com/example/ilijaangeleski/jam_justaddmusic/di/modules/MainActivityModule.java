package com.example.ilijaangeleski.jam_justaddmusic.di.modules;


import com.example.ilijaangeleski.jam_justaddmusic.api.NetworkApi;
import com.example.ilijaangeleski.jam_justaddmusic.manager.MainManager;
import com.example.ilijaangeleski.jam_justaddmusic.presenter.MainPresenter;
import com.example.ilijaangeleski.jam_justaddmusic.view.MainView;

import java.lang.ref.WeakReference;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ilija Angeleski on 1/10/2018.
 */
@Module
public class MainActivityModule {
    WeakReference<MainView> view;

    public MainActivityModule(MainView view) {
        this.view = new WeakReference<>(view);
    }

    @Provides
    MainPresenter provideMainPresenter(MainManager mainManager){
        return new MainPresenter(mainManager,view);
    }

    @Provides
    MainManager provideMainManager(NetworkApi networkApi){
        return new MainManager(networkApi);
    }
}
