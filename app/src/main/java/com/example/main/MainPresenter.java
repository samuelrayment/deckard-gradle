package com.example.main;

import android.os.Bundle;
import android.util.Log;

import com.example.navigation.INavigator;
import com.example.utils.IPresenter;

import javax.inject.Inject;

import dagger.ObjectGraph;

/**
 * Presenter for the MainView.
 */
public class MainPresenter implements IMainPresenter, IPresenter, IMainModel.CountListener {
    @Inject
    IMainModel mMainModel;
    @Inject
    INavigator mNavigator;
    IMainView mMainView;
    String mTitle = "Hello Espresso!";

    static String sTitleTag = "TITLE";

    public MainPresenter() {
    }

    @Override
    public void onAttachView(IMainView mainView, ObjectGraph objectGraph) {
        mMainView = mainView;
        objectGraph.inject(this);

        mMainModel.setCountListener(this);
        mainView.updateTitle(mTitle);
    }

    @Override
    public void onDetachView() {
        mMainView = null;
    }

    @Override
    public void onSaveInstanceState(Bundle saveState) {
        saveState.putString(sTitleTag, mTitle);
    }

    @Override
    public void onRestoreInstanceState(Bundle saveState) {
        mTitle = saveState.getString(sTitleTag);
        mMainView.updateTitle(mTitle);
    }

    @Override
    public void buttonClicked() {
        mTitle = "Button Clicked!";
        mMainView.updateTitle(mTitle);
    }

    @Override
    public void incrementCounter() {
        mMainModel.incrementCounter();
    }

    @Override
    public void decrementCounter() {
        mMainModel.decrementCounter();
    }

    @Override
    public void recyclerViewClicked(int index) {
        mNavigator.navigateToDetail(index);
    }

    @Override
    public void onCountChanged(int newCount) {
        mMainView.updateCounter(newCount);
    }
}
