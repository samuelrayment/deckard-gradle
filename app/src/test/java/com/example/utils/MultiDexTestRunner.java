package com.example.utils;

import android.os.Bundle;
import android.support.multidex.MultiDex;
import android.support.test.runner.AndroidJUnitRunner;

/**
 * Espresso test runner that also supports multidex
 */
public class MultiDexTestRunner extends AndroidJUnitRunner {
    @Override
    public void onCreate(Bundle arguments) {
        MultiDex.install(getTargetContext());
        super.onCreate(arguments);
    }
}
