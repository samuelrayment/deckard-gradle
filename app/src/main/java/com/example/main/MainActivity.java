package com.example.main;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.DeckardApplication;
import com.example.R;

import java.util.Arrays;
import java.util.List;

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
        ButterKnife.inject(this);
        mMainPresenter.onAttachView(this);
        if (savedInstanceState != null) {
            mMainPresenter.onRestoreInstanceState(savedInstanceState);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMainPresenter.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainPresenter.onDetachView();
        mObjectGraph = null;
    }

    @Override
    public void updateTitle(String title) {
        mTextView.setText(title);
    }

    @OnClick(R.id.button)
    public void buttonClicked(Button button) {
        mMainPresenter.buttonClicked();
    }

    private void setupActivityDaggerModule() {
        DeckardApplication application = ((DeckardApplication) getApplication());
        mObjectGraph = application.getApplicationGraph().plus(getModules().toArray());
        mObjectGraph.inject(this);
    }

    protected List<Object> getModules() {
        return Arrays.<Object>asList(new MainModule(this));
    }
}
