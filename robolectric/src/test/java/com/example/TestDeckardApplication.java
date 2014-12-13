package com.example;

import android.content.Context;

import org.robolectric.TestLifecycleApplication;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import dagger.ObjectGraph;

/**
 * Robolectric Test Application handles multidex failures with robolectric
 */
public class TestDeckardApplication extends DeckardApplication implements TestLifecycleApplication {
    List<Object> mModules = new ArrayList<>();

    @Override
    protected void attachBaseContext(Context base) {
        try {
            super.attachBaseContext(base);
        } catch (RuntimeException ignored) {
            // Multidex support doesn't play well with Robolectric yet
        }
    }

    @Override
    public void beforeTest(Method method) {

    }

    @Override
    public void prepareTest(Object test) {
        mModules.clear();
        mModules.add(new DaggerModule(this));
        try {
            for (Annotation annotation : test.getClass().getAnnotations()) {
                if (annotation instanceof UseModule) {
                    Class module = ((UseModule) annotation).value();
                    mModules.add(module.newInstance());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        mApplicationGraph = ObjectGraph.create(mModules.toArray());
        mApplicationGraph.inject(test);
    }

    @Override
    public void afterTest(Method method) {

    }
}
