package com.example.utils;

import android.os.Bundle;
import android.support.multidex.MultiDex;

import com.google.android.apps.common.testing.testrunner.GoogleInstrumentationTestRunner;

/**
 * Espresso test runner that also supports multidex
 */
public class MultiDexTestRunner extends GoogleInstrumentationTestRunner {
    @Override
    public void onCreate(Bundle arguments) {
        MultiDex.install(getTargetContext());
        super.onCreate(arguments);
    }
}
