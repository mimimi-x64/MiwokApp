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

    public Words( String MiwokTranslation, String DefaulTranslation, int songResourceId) {
        mMiwokTranslation = MiwokTranslation;
        mDefaulTranslation = DefaulTranslation;
        mSongId = songResourceId;
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

    public boolean checkImageResource() {
        return mImageResourceID != NO_IMAGE;
    }

    @Override
    public String toString() {
        return "Words{" +
                "mDefaulTranslation='" + mDefaulTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mSongId=" + mSongId +
                ", mImageResourceID=" + mImageResourceID +
                '}';
    }

    public int getSongResource(){
        return mSongId;
    }
}
