package com.example.main;

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

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricGradleSubModuleTestRunner.class)
@UseModule(MainActivityTest.TestMainModule.class)
public class MainActivityTest {
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
                    MainActivityTest.class
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

