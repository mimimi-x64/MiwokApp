package com.example.android.miwok;

/**
 * Created by phartmann on 16/01/2018.
 */

public class FamillyWords {
    //Encapsulation Strings
    private String mDefault;
    private String mMiwok;
    //Constructor
    public FamillyWords(String defaultWord, String miwokWord ){
        mDefault = defaultWord;
        mMiwok = miwokWord;
    }
    //Access Default Translation
    public String getDefault(){
        return mDefault;
    }
    //Acesss Miwok
    public String getMiwok(){
        return mMiwok;
    }
}
