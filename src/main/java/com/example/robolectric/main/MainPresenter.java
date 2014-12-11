package com.example.robolectric.main;

import android.content.Context;

/**
 * Created by sam on 11/12/14.
 */
public class MainPresenter implements IMainPresenter {
    private Context mContext;

    public MainPresenter(Context context) {
        mContext = context;
    }
}
