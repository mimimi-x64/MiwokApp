package com.example.android.miwok;

/**
 * Create a class to store Translations and Default Colors
 */

public class Numbers {

    private String mDefaulTranslation;

    private String mMiwokTranslation;

    public Numbers( String MiwokTranslation, String DefaulTranslation) {
        mMiwokTranslation = MiwokTranslation;
        mDefaulTranslation = DefaulTranslation;
    }

    public String getDefaulTranslation(){
        return mDefaulTranslation;
    }

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }
}
