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
    IMainPresenter mMockPresenter;
    IMainModel mModelUnderTest;

    @Before
    public void setup() {
        mMockPresenter = mock(IMainPresenter.class);
        mModelUnderTest = new MainModel();
        mModelUnderTest.setPresenter(mMockPresenter);
    }

    @Test
    public void modelNotifiesPresenterOfCounterOnCreation() {
        verify(mMockPresenter).updateCounter(4);
    }

    @Test
    public void modelNotifiesPresenterOfCounterOnIncrement() {
        mModelUnderTest.incrementCounter();
        verify(mMockPresenter).updateCounter(5);
    }

    @Test
    public void modelNotifiesPresenterOfCounterOnDecrement() {
        mModelUnderTest.decrementCounter();
        verify(mMockPresenter).updateCounter(3);
    }
}
