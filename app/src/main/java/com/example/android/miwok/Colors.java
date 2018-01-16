package com.example.android.miwok;

/**
 * Create a class to store Translations and Default Colors
 */

public class Colors {

    private String mDefaultColors;
    private String mMiwokColors;

    public Colors(String miwokColors, String defaultColors){
        mMiwokColors = miwokColors;
        mDefaultColors = defaultColors;
    }

    public String getMiwokColors(){
        return mMiwokColors;
    }

    public String getDefaultColors(){
        return mDefaultColors;
    }
}
