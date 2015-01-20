package com.example.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.detail.DetailActivity;

/**
 * Created by sam.rayment on 19/01/2015.
 */
public class Navigator implements INavigator {
    Activity mActivity;

    public Navigator(Activity activity) {
        mActivity = activity;
    }

    @Override
    public void navigateToDetail(int index) {
        Intent intent = new Intent(mActivity.getApplicationContext(), DetailActivity.class);
        intent.putExtra("Index", index);
        mActivity.startActivity(intent);
    }
}
