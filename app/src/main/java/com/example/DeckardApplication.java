package com.example;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

public class DeckardApplication extends Application {
    private ObjectGraph mApplicationGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationGraph = ObjectGraph.create(getModules().toArray());
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    protected List<Object> getModules() {
        return Arrays.<Object>asList(new DaggerModule(this));
    }

    public void inject(Activity activity) {
        mApplicationGraph.inject(activity);
    }

    public ObjectGraph getApplicationGraph() {
        return mApplicationGraph;
    }
}
