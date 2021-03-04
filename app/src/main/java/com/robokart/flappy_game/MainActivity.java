package com.robokart.flappy_game;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    WebView webView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView webView2 = new WebView(getApplicationContext());
        this.webView = webView2;
        WebSettings settings = webView2.getSettings();
        this.webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }

            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                Log.e("Error", description);
            }
        });

        settings.setJavaScriptEnabled(true);
        this.webView.addJavascriptInterface(new WebAppInterface(this), "Android");
        settings.setDomStorageEnabled(true);
        //this.webView.loadUrl("https://studio.code.org/projects/applab/6AaVqpsDWKKzf8v4R6I16NkBojgYZWbJ01yRwf_EiVg");
        this.webView.loadUrl("https://studio.code.org/projects/applab/-R1X2Z0RIOOHJfY2yVKvfywSgYrUxstwo74tFB4DxsM");
        //https://studio.code.org/projects/applab/9WpBwujbzSItxyTwPIJOdsNej2NnJbuhU6DCWj5PrcY
        setContentView((View) this.webView);
    }

    public class WebAppInterface {
        Context mContext;

        WebAppInterface(Context c) {
            this.mContext = c;
        }

        @JavascriptInterface
        public void showToast(String toast) {
            //Toast.makeText(this.mContext, toast, 0).show();
        }
    }
}