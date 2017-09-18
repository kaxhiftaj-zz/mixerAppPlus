package com.techease.mixerappplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.thefinestartist.finestwebview.FinestWebView;

public class Webview extends AppCompatActivity {

    String url ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        Intent intent = getIntent();
        url = intent.getExtras().getString("url");
        Toast.makeText(this, url, Toast.LENGTH_SHORT).show();
        // Webview intialization

        new FinestWebView.Builder(Webview.this)
                .showUrl(true)
                .showIconMenu(false)
                .showIconClose(false)
                .showIconBack(true)
                .backPressToClose(false)
                .show(url)
        ;
        this.finish();


    }
}
