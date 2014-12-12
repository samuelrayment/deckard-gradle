package com.example;

import dagger.Module;

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
}
