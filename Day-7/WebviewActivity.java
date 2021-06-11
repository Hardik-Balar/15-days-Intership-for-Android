package com.example.mydemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WebviewActivity extends AppCompatActivity implements View.OnClickListener {
    TextView t1;
    EditText edit1;
    Button b1;
    WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        t1 =(TextView) findViewById(R.id.t1);
        edit1 =(EditText) findViewById(R.id.edit1);
        b1 =(Button) findViewById(R.id.b1);
        wv1 =(WebView) findViewById(R.id.wv1);
        b1.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId())
        {
            case R.id.b1:
                String url = edit1.getText().toString();
                wv1.getSettings().setJavaScriptEnabled(true);
                wv1.setWebViewClient(new MywebViewClient());
                wv1.loadUrl(url);

                break;
        }
    }
    private class MywebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            return super.shouldOverrideUrlLoading(view, url);
                view.loadUrl(url);
                return true;
        }
    }
    {

    }
}