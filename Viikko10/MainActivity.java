package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView web;
    EditText link;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = findViewById(R.id.WebView);
        link = findViewById(R.id.EditText);
        web.setWebViewClient(new WebViewClient());





    }
    public void onClick(View v){
        String url = link.getText().toString();

        web.getSettings().setLoadsImagesAutomatically(true);
        web.getSettings().setJavaScriptEnabled(true);

        if(!url.startsWith("http://") && !url.startsWith("https://"))
            url = "http://" + url;
        web.loadUrl(url);
    }


    public void refresh(View v) {
        String webUrl = web.getUrl();
        web.loadUrl(webUrl);
    }


}
