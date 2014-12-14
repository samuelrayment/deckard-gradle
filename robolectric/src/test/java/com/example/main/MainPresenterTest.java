package com.example.main;

import com.example.DaggerModule;
import com.example.RobolectricGradleSubModuleTestRunner;
import com.example.UseModule;

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
    IMainPresenter mMainPresenterUnderTest = new MainPresenter();
    IMainView mMockMainView;
    @Inject
    IMainModel mMockMainModel;
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
    }
}
