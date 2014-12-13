package com.example.main;

import android.os.Bundle;

import com.example.utils.IPresenter;

/**
 * Presenter for the MainView.
 */
public class MainPresenter implements IMainPresenter, IPresenter {
    private IMainView mMainView;
    private String mTitle = "Hello Espresso!";

    private static String sTitleTag = "TITLE";

    public MainPresenter() {
    }

    @Override
    public void onAttachView(IMainView mainView) {
        mMainView = mainView;
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
}
