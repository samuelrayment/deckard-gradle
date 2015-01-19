package com.example.main;

import com.example.utils.IPresenter;

import dagger.ObjectGraph;

/**
 * Interface for the MainPresenter
 */
public interface IMainPresenter extends IPresenter {

    public void onAttachView(IMainView mainView, ObjectGraph objectGraph);
    public void onDetachView();

    public void buttonClicked();

    public void incrementCounter();
    public void decrementCounter();

    public void recyclerViewClicked(int index);
}
