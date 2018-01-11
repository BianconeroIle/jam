package com.example.ilijaangeleski.jam_justaddmusic.di.components;

import com.example.ilijaangeleski.jam_justaddmusic.di.modules.MainActivityModule;
import com.example.ilijaangeleski.jam_justaddmusic.ui.MainActivity;

import dagger.Component;

/**
 * Created by Ilija Angeleski on 1/10/2018.
 */
@Component(modules = MainActivityModule.class, dependencies = BaseComponent.class)
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}
