package com.example.robolectric;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class DeckardActivity extends Activity {
    @InjectView(R.id.text2)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deckard);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.button)
    public void buttonClicked(Button button) {
        mTextView.setText("Button Clicked!");
    }
}
