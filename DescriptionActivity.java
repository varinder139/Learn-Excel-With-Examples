package varinder.study.learnexcelwithexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class DescriptionActivity extends AppCompatActivity {

    private static final String TAG = "DescriptionActivity";
    private Context mcontext;
    private Bundle extras;
    private WebView webView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);


        mcontext = DescriptionActivity.this;
        webView = (WebView) findViewById(R.id.simpleWebView);
        extras = getIntent().getExtras();
        if (!extras.equals(null)) {

            String data = extras.getString("tiles");


            // Toast.makeText(DescriptionActivity.this, data, Toast.LENGTH_SHORT).show();

            //  Log.d(TAG, "oncreate: the comomg data is "+data);

            String url = "file:///android_asset/" + data + ".html";
            webView.loadUrl(url);

            WebSettings webSettings = webView.getSettings();
            webSettings.setBuiltInZoomControls(true);
            webSettings.setDisplayZoomControls(true);
            webSettings.setJavaScriptEnabled(true);


            // Add
            prepaperAD();

          /*  ScheduledExecutorService scheduledExecutorService =
                    Executors.newSingleThreadScheduledExecutor();
            scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (mInterstitialAd.isLoaded()){
                                mInterstitialAd.show();
                            }
                            else
                            {
                                Log.d("TAG", "Add not loaded");
                            }
                            prepaperAD();
                        }
                    });
                }
            } |: 10, |1: 10, TimeUnit.SECOND); */
        }
    }

    public void prepaperAD() {
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-1606790808026247/4403900160");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

    @Override
    public void onBackPressed() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();

            mInterstitialAd.setAdListener(new AdListener()
                                          {
                                              @Override
                                              public void onAdClosed() {
                                                  super.onAdClosed();
                                                  finish();
                                              }
                                          }

            );

        } else {
            super.onBackPressed();
        }
    }
}


next step is design for description class
activity_description.xml 
code is here:-
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".DescriptionActivity">

    <WebView
        android:id="@+id/simpleWebView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>





</RelativeLayout>
