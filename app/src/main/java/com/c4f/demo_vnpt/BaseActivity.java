package com.c4f.demo_vnpt;

import android.app.Activity;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    protected void startActivityAndFinish(Activity activity, Class target) {
        Intent intent = new Intent(activity, target);
        startActivity(intent);
        finish();
    }

    protected void startActivity(Activity activity, Class target) {
        Intent intent = new Intent(activity, target);
        startActivity(intent);
    }
}
