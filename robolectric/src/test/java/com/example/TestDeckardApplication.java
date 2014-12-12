package com.example;

import android.content.Context;

/**
 * Robolectric Test Application handles multidex failures with robolectric
 */
public class TestDeckardApplication extends DeckardApplication {
    @Override
    protected void attachBaseContext(Context base) {
        try {
            super.attachBaseContext(base);
        } catch (RuntimeException ignored) {
            // Multidex support doesn't play well with Robolectric yet
        }
    }
}
