package com.example.main;

import com.example.DaggerModule;
import com.example.RobolectricGradleSubModuleTestRunner;
import com.example.UseModule;
import com.example.navigation.INavigator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.ObjectGraph;
import dagger.Provides;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Tests for the MainPresenter
 */
public class MainPresenterTest {
    MainPresenter mMainPresenterUnderTest = new MainPresenter();
    IMainView mMockMainView;
    @Inject
    IMainModel mMockMainModel;
    @Inject
    INavigator mMockNavigator;
    ObjectGraph mObjectGraph;

    @Before
    public void setup() {
        mMockMainView = mock(IMainView.class);
        mObjectGraph = ObjectGraph.create(new TestMainModule());
        mObjectGraph.inject(mMainPresenterUnderTest);
        mObjectGraph.inject(this);
    }

    @Test
    public void testPresenterInitialisesViewTitleWhenAttached() throws Exception {
        mMainPresenterUnderTest.onAttachView(mMockMainView, mObjectGraph);

        verify(mMockMainView).updateTitle("Hello Espresso!");
    }

    @Test
    public void testPresenterUpdatesViewTitleWhenButtonClicked() throws Exception {
        mMainPresenterUnderTest.onAttachView(mMockMainView, mObjectGraph);
        mMainPresenterUnderTest.buttonClicked();

        verify(mMockMainView).updateTitle("Button Clicked!");
    }

    @Test
    public void testPresenterNotifiesModelToIncrement() throws Exception {
        mMainPresenterUnderTest.onAttachView(mMockMainView, mObjectGraph);
        mMainPresenterUnderTest.incrementCounter();

        verify(mMockMainModel).incrementCounter();
    }

    @Test
    public void testPresenterNotifiesModelToDecrement() throws Exception {
        mMainPresenterUnderTest.onAttachView(mMockMainView, mObjectGraph);
        mMainPresenterUnderTest.decrementCounter();

        verify(mMockMainModel).decrementCounter();
    }

    @Test
    public void testPresenterNotifiesViewWhenModelCounterUpdates() throws Exception {
        int newCounterValue = 5;

        mMainPresenterUnderTest.onAttachView(mMockMainView, mObjectGraph);
        mMainPresenterUnderTest.onCountChanged(newCounterValue);

        verify(mMockMainView).updateCounter(newCounterValue);

    }

    @Test
    public void testPresenterNavigatesToSecondActivityOnRecyclerViewTouch() throws Exception {
        final int itemIndex = 3;
        mMainPresenterUnderTest.onAttachView(mMockMainView, mObjectGraph);

        mMainPresenterUnderTest.recyclerViewClicked(itemIndex);

        verify(mMockNavigator).navigateToDetail(itemIndex);
    }

    @Module(
            injects={
                    MainPresenter.class,
                    MainPresenterTest.class
            }
    )
    public static class TestMainModule {
        @Provides
        @Singleton
        IMainModel produceMainModel() {
            return mock(IMainModel.class);
        }

        @Provides
        @Singleton
        INavigator provideNavigator() {
            return mock(INavigator.class);
        }
    }
}
