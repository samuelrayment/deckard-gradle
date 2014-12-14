package com.example.main;

/**
 * Data model layer for the Main view.
 */
public class MainModel implements IMainModel {
    int mCount = 4;

    @Override
    public void incrementCounter() {
        mCount++;
    }

    @Override
    public void decrementCounter() {
        mCount--;
    }
}
