package com.example;

import com.example.navigation.INavigator;
import com.example.navigation.Navigator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Base Application dagger module for the app, provides application
 * level resources.
 */
@Module(library = true)
public class DaggerModule {
    private final DeckardApplication mApplication;

    public DaggerModule(DeckardApplication application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    public INavigator provideNavigator() {
        return new Navigator();
    }
}
