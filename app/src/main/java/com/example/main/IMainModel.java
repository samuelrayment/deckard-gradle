package com.example.main;

/**
 * Interface for the Main views model.
 */
public interface IMainModel {
    public void incrementCounter();

    public void decrementCounter();

    public void setCountListener(CountListener countListener);

    /**
     * Interface for a presenter class to register interest for count updates.
     */
    public static interface CountListener {
        public void onCountChanged(int newCount);
    }

    /**
     * Null Count Listener use this to prevent scattered if ... != null checks.
     */
    public static class NullCountListener implements CountListener {
        @Override
        public void onCountChanged(int newCount) {

        }
    }
}
