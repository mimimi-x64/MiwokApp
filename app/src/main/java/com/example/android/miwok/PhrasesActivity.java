package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        ArrayList<PhrasesWords> phrasesWords = new ArrayList<PhrasesWords>();

        phrasesWords.add(new PhrasesWords("one", "two"));
        phrasesWords.add(new PhrasesWords("one", "two"));
        phrasesWords.add(new PhrasesWords("one", "two"));
        phrasesWords.add(new PhrasesWords("one", "two"));
        phrasesWords.add(new PhrasesWords("one", "two"));
        phrasesWords.add(new PhrasesWords("one", "two"));
        phrasesWords.add(new PhrasesWords("one", "two"));
        phrasesWords.add(new PhrasesWords("one", "two"));
        phrasesWords.add(new PhrasesWords("one", "two"));
        phrasesWords.add(new PhrasesWords("one", "two"));
        //Instacietates Object and Use on XML
        PhrasesAdapter phWords = new PhrasesAdapter(this, phrasesWords);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(phWords);
    }
}
