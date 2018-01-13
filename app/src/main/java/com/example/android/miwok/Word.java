package com.example.android.miwok;

import android.content.Context;

/**
 * Created by phartmann on 13/01/2018.
 */

public class Word {

    private String mDefaulTranslation;

    private String mMiwokTranslation;

    public Word( String MiwokTranslation, String DefaulTranslation) {
        mDefaulTranslation = DefaulTranslation;
        mMiwokTranslation = MiwokTranslation;
    }

    public String getDefaulTranslation(){
        return mDefaulTranslation;
    }

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }
}
