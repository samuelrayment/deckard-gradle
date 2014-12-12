package com.example.robolectric.utils;

import android.os.Bundle;

/**
 * Created by sam on 11/12/14.
 */
public interface IPresenter {
    public void onSaveInstanceState(Bundle saveState);
    public void onRestoreInstanceState(Bundle saveState);
}
