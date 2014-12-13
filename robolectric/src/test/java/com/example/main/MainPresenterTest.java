package com.example.main;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Tests for the MainPresenter
 */
public class MainPresenterTest {
    private IMainPresenter mMainPresenterUnderTest = new MainPresenter();
    private IMainView mMockMainView;

    @Before
    public void setup() {
        mMockMainView = mock(IMainView.class);
    }

    @Test
    public void testPresenterInitialisesViewTitleWhenAttached() throws Exception {
        mMainPresenterUnderTest.onAttachView(mMockMainView);

        verify(mMockMainView).updateTitle("Hello Espresso!");
    }

    @Test
    public void testPresenterUpdatesViewTitleWhenButtonClicked() throws Exception {
        mMainPresenterUnderTest.onAttachView(mMockMainView);
        mMainPresenterUnderTest.buttonClicked();

        verify(mMockMainView).updateTitle("Button Clicked!");
    }
}
