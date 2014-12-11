package com.example;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import dagger.ObjectGraph;

public class DeckardApplication extends Application {
    private ObjectGraph mApplicationGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationGraph = ObjectGraph.create(new DaggerModule(this));
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public void inject(Activity activity) {
        mApplicationGraph.inject(activity);
    }

    public ObjectGraph getApplicationGraph() {
        return mApplicationGraph;
    }
}
