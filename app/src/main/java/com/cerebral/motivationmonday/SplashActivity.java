package com.cerebral.motivationmonday;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SplashActivity extends AppCompatActivity {
    private final int SPLASH_INTERAL = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Request for full screen window
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        SharedPreferences pref = getSharedPreferences("ActivityPref", Context.MODE_PRIVATE);
        if(pref.getBoolean("activity_executed", false)){
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            finish();
        }else{
            setContentView(R.layout.activity_splash);
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("activity_executed", true);
            editor.commit();

            //start the login activity after some time
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
                }
            }, SPLASH_INTERAL);
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
