package com.example.main;

/**
 * Interface for the Main views model.
 */
public interface IMainModel {
    public void setPresenter(IMainPresenter mainPresenter);

    public void incrementCounter();

    public void decrementCounter();
}
