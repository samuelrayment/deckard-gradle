package com.example.robolectric.main;

import com.example.robolectric.utils.IPresenter;

/**
 * Interface for the MainPresenter
 */
public interface IMainPresenter extends IPresenter {

    public void onAttachView(IMainView mainView);
    public void onDetachView();

    public void buttonClicked();
}
