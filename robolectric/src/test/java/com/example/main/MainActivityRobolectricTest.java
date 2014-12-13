package com.example.main;

import android.app.Activity;
import android.widget.Button;

import com.example.R;
import com.example.RobolectricGradleSubModuleTestRunner;
import com.example.UseModule;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@Config(manifest = "../app/src/main/AndroidManifest.xml")
@RunWith(RobolectricGradleSubModuleTestRunner.class)
@UseModule(MainActivityRobolectricTest.TestMainModule.class)
public class MainActivityRobolectricTest {
    @Inject
    IMainPresenter mMockPresenter;

    @Test
    public void testClickingTheButtonNotifiesThePresenter() throws Exception {
        MainActivity activity = Robolectric.buildActivity(MainActivity.class).create().get();
        Button button = (Button)activity.findViewById(R.id.button);
        button.performClick();

        verify(mMockPresenter).buttonClicked();
    }

    @Module(
            injects={
                    MainActivity.class,
                    MainActivityRobolectricTest.class
            },
            library = true,
            overrides = true
    )
    public static class TestMainModule {
        @Provides
        @Singleton
        IMainPresenter produceMainPresenter() {
            return mock(IMainPresenter.class);
        }
    }
}

