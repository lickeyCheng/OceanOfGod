package com.lickey.asus.oceanofgod;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class WebViewPage_Activity extends Activity {

    private WebView wv_content;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_page);

        wv_content= (WebView) findViewById(R.id.wv_content);
        imageView= (ImageView) findViewById(R.id.wv_back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        wv_content.getSettings().setJavaScriptEnabled(true);
        wv_content.setWebViewClient(new WebViewClient());
        String url= getIntent().getStringExtra("url");
        Log.d("url:",url);
        wv_content.loadUrl(url);
    }
}
