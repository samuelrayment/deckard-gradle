package com.example.robolectric.main;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.DeckardApplication;
import com.example.R;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import dagger.ObjectGraph;

public class MainActivity extends Activity implements IMainView {
    private ObjectGraph mObjectGraph;
    @InjectView(R.id.text)
    TextView mTextView;
    @Inject
    IMainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupActivityDaggerModule();
        setContentView(R.layout.deckard);
        Log.e("TEST", "" + mMainPresenter);
        ButterKnife.inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mObjectGraph = null;
    }

    @OnClick(R.id.button)
    public void buttonClicked(Button button) {
        mTextView.setText("Button Clicked!");
    }

    private void setupActivityDaggerModule() {
        DeckardApplication application = ((DeckardApplication) getApplication());
        mObjectGraph = application.getApplicationGraph().plus(new MainModule(this));
        mObjectGraph.inject(this);
    }
}
