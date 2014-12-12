package com.example.activity;

import android.app.Activity;

import com.example.RobolectricGradleSubModuleTestRunner;
import com.example.robolectric.main.MainActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertTrue;

@Config(manifest = "../app/src/main/AndroidManifest.xml")
@RunWith(RobolectricGradleSubModuleTestRunner.class)
public class MainActivityRobolectricTest {

    @Test
    public void testSomething() throws Exception {
        Activity activity = Robolectric.buildActivity(MainActivity.class).create().get();
        assertTrue(activity != null);
    }
}
