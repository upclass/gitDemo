package com.example.jpushdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.administrator.tuisongdemo.*;
import com.example.jpushdemo.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import cn.jpush.android.api.JPushInterface;

public class WebActivity extends AppCompatActivity {
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        Intent intent=getIntent();
        Bundle bundle = intent.getExtras();
        String json = bundle.getString(JPushInterface.EXTRA_EXTRA);
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
            String url = jsonObject.getString("url");
            mWebView= (WebView) findViewById(R.id.wenlink);
            mWebView.setWebViewClient(new WebViewClient());
            mWebView.loadUrl(url);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
