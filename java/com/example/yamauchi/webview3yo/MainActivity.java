package com.example.yamauchi.webview3yo;

import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        WebView webview = new WebView(this);
        webview.getSettings().setJavaScriptEnabled(true);
        // ビューにクライアントを追加する
        webview.setWebViewClient(mClient);
        //webview.loadUrl("http://www.google.com");
        webview.loadUrl("http://www.it-college.ac.jp");
        setContentView(webview);
    }

    private WebViewClient mClient = new WebViewClient(){
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Uri requst = Uri.parse(url);

            //if(TextUtils.equals(requst.getAuthority(), "www.google.com")){
            if(TextUtils.equals(requst.getAuthority(), "www.it-college.ac.jp")){
                // ロードを許可する
                return false;
            }else{
                Toast.makeText(MainActivity.this, "Sorry, Budd", Toast.LENGTH_SHORT).show();
                return true;
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
