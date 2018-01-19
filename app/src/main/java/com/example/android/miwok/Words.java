package com.example.android.miwok;

/**
 * Create a class to store Translations and Default Colors
 */

public class Words {

    private String mDefaulTranslation;

    private String mMiwokTranslation;

    private int mImageResourceID;

    public Words( String MiwokTranslation, String DefaulTranslation ){
        mMiwokTranslation = MiwokTranslation;
        mDefaulTranslation = DefaulTranslation;
    }
    public Words( String MiwokTranslation, String DefaulTranslation, int resource) {
        mMiwokTranslation = MiwokTranslation;
        mDefaulTranslation = DefaulTranslation;
        mImageResourceID = resource;
    }

    public String getDefaulTranslation(){
        return mDefaulTranslation;
    }

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    public int getImageResource(){ return mImageResourceID; }
}
