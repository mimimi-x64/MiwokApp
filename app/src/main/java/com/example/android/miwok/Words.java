package com.example.android.miwok;

/**
 * Create a class to store Translations and Default Colors
 */

public class Words {

    private String mDefaulTranslation;

    private String mMiwokTranslation;

    private int mSongId;

    private int mImageResourceID = NO_IMAGE;

    private static final int NO_IMAGE = -1;

    public Words( String MiwokTranslation, String DefaulTranslation ){
        mMiwokTranslation = MiwokTranslation;
        mDefaulTranslation = DefaulTranslation;
    }
    public Words( String MiwokTranslation, String DefaulTranslation, int imageResourceId) {
        mMiwokTranslation = MiwokTranslation;
        mDefaulTranslation = DefaulTranslation;
        mImageResourceID = imageResourceId;
    }
    public Words( String MiwokTranslation, String DefaulTranslation, int imageResourceId, int songResourceId) {
        mMiwokTranslation = MiwokTranslation;
        mDefaulTranslation = DefaulTranslation;
        mImageResourceID = imageResourceId;
        mSongId = songResourceId;
    }

    public String getDefaulTranslation(){
        return mDefaulTranslation;
    }

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    public int getImageResource(){
        return mImageResourceID;
    }

    public int getSongResource(){
        return mSongId;
    }

    public boolean checkImageResource() {
        return mImageResourceID != NO_IMAGE;
    }
}
