package com.example.main;

import com.example.RobolectricGradleSubModuleTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Unit Tests for the MainView Model
 */
@RunWith(RobolectricGradleSubModuleTestRunner.class)
public class MainModelTest {
    IMainModel.CountListener mMockCountListener;
    IMainModel mModelUnderTest;

    @Before
    public void setup() {
        mMockCountListener = mock(IMainModel.CountListener.class);
        mModelUnderTest = new MainModel();
        mModelUnderTest.setCountListener(mMockCountListener);
    }

    @Test
    public void modelNotifiesPresenterOfCounterOnCreation() {
        verify(mMockCountListener).onCountChanged(4);
    }

    @Test
    public void modelNotifiesPresenterOfCounterOnIncrement() {
        mModelUnderTest.incrementCounter();
        verify(mMockCountListener).onCountChanged(5);
    }

    @Test
    public void modelNotifiesPresenterOfCounterOnDecrement() {
        mModelUnderTest.decrementCounter();
        verify(mMockCountListener).onCountChanged(3);
    }
}
