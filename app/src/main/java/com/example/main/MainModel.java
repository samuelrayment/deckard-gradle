package com.example.main;

/**
 * Data model layer for the Main view.
 */
public class MainModel implements IMainModel {
    int mCount = 4;
    IMainPresenter mMainPresenter;

    @Override
    public void setPresenter(IMainPresenter mainPresenter) {
        mMainPresenter = mainPresenter;
        mainPresenter.updateCounter(mCount);
    }

    @Override
    public void incrementCounter() {
        mCount++;
        mMainPresenter.updateCounter(mCount);
    }

    @Override
    public void decrementCounter() {
        mCount--;
        mMainPresenter.updateCounter(mCount);
    }
}
