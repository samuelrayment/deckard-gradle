package com.example.main;

import com.example.DaggerModule;
import com.example.navigation.INavigator;
import com.example.navigation.Navigator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger injection module for the MainActivity
 */
@Module(
        injects={
                MainActivity.class,
                MainPresenter.class
        },
        addsTo = DaggerModule.class,
        library = true
)
public class MainModule {
    private final MainActivity mActivity;

    public MainModule(MainActivity activity) {
        mActivity = activity;
    }

    @Provides
    IMainPresenter produceMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    // This is a singleton to provide persistence simulation
    @Singleton
    IMainModel produceMainModel() {
        return new MainModel();
    }

    @Provides
    @Singleton
    public INavigator provideNavigator() {
        return new Navigator(mActivity);
    }
}
