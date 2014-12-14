package com.example.main;

/**
 * Data model layer for the Main view.
 */
public class MainModel implements IMainModel {
    int mCount = 4;
    CountListener mCountListener = new NullCountListener();

    public MainModel() {
    }

    @Override
    public void incrementCounter() {
        mCount++;
        mCountListener.onCountChanged(mCount);
    }

    @Override
    public void decrementCounter() {
        mCount--;
        mCountListener.onCountChanged(mCount);
    }

    @Override
    public void setCountListener(CountListener countListener) {
        if(countListener == null) {
            countListener = new NullCountListener();
        }
        mCountListener = countListener;
        mCountListener.onCountChanged(mCount);
    }
}
