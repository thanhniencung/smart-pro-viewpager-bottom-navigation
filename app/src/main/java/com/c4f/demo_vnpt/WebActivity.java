package com.c4f.demo_vnpt;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WebActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_web);

        WebView webView = findViewById(R.id.webView);

        String url = getIntent().getStringExtra("WEB_URL");
        String title = getIntent().getStringExtra("TITLE");

        webView.loadUrl(url);
        setTitle(title);
    }
}
