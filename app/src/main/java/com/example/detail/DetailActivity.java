package com.example.detail;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class DetailActivity extends ActionBarActivity {
    @InjectView(R.id.text_view)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.inject(this);

        Intent intent = getIntent();
        int index = intent.getIntExtra("Index", 0);
        mTextView.setText("Activity Launched With " + index);
    }
}
