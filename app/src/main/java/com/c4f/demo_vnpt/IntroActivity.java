package com.c4f.demo_vnpt;

import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;

public class IntroActivity extends BaseActivity {
    public static final int DELAY_TIME = 4000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_intro);

        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivityAndFinish(IntroActivity.this, MainActivity.class);
            }
        }, DELAY_TIME);
    }
}
