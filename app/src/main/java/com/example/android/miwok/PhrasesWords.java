package com.example.android.miwok;

/**
 * Created by phartmann on 16/01/2018.
 */

public class PhrasesWords {
    //Varibles
    private String mMiwok;
    private String mDefault;
    //Constructor
    public PhrasesWords( String miwokWords, String defaulWords){
        mMiwok = miwokWords;
        mDefault = defaulWords;
    }
    //Getters
    public String getMiwok() {
        return mMiwok;
    }
    public String getDefault(){
        return mDefault;
    }
}
