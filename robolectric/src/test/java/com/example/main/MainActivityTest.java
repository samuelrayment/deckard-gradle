package com.example.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.R;
import com.example.RobolectricGradleSubModuleTestRunner;
import com.example.UseModule;
import com.example.navigation.INavigator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.Any;
import org.robolectric.Robolectric;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.withSettings;

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

    @Test
    public void testUpdatingTheCounterUpdatesTextView() throws Exception {
        MainActivity activity = Robolectric.buildActivity(MainActivity.class).create().get();
        TextView textView = (TextView)activity.findViewById(R.id.counter_text);
        activity.updateCounter(7);

        assertThat(textView.getText()).isEqualTo("7");
    }

    @Test
    public void testUpdatingTheCounterUpdatesRecyclerViewItemCount() throws Exception {
        MainActivity activity = Robolectric.buildActivity(MainActivity.class).create().get();
        RecyclerView recyclerView = (RecyclerView)activity.findViewById(R.id.recycler_view);
        activity.updateCounter(7);

        assertThat(recyclerView.getAdapter().getItemCount()).isEqualTo(7);
    }

    @Test
    public void testClickingIncrementNotifiesThePresenter() throws Exception {
        MainActivity activity = Robolectric.buildActivity(MainActivity.class).create().get();
        Button button = (Button)activity.findViewById(R.id.increment_button);
        button.performClick();

        verify(mMockPresenter).incrementCounter();
    }

    @Test
    public void testClickingDecrementNotifiesThePresenter() throws Exception {
        MainActivity activity = Robolectric.buildActivity(MainActivity.class).create().get();
        Button button = (Button)activity.findViewById(R.id.decrement_button);
        button.performClick();

        verify(mMockPresenter).decrementCounter();
    }

    @Test
    public void testClickingRecyclerViewNotifiesThePresenter() throws Exception {
        MainActivity activity = Robolectric.buildActivity(MainActivity.class).create().get();
        activity.updateCounter(7);
        RecyclerView recyclerView = (RecyclerView)activity.findViewById(R.id.recycler_view);
        recyclerView.measure(0, 0);
        recyclerView.layout(0, 0, 100, 10000);
        recyclerView.getChildAt(0).performClick();

        verify(mMockPresenter).recyclerViewClicked(0);
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

