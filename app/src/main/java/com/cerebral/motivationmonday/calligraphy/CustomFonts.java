package com.cerebral.motivationmonday.calligraphy;

import android.app.Application;

import com.cerebral.motivationmonday.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/*
* Setup class for calligraphy fonts in the manifesdt
* */
public class CustomFonts extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //setup calligraphy configurations
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
        .setDefaultFontPath("fonts/poppinslight.ttf")
        .setFontAttrId(R.attr.fontPath)
        .build());
    }
}
