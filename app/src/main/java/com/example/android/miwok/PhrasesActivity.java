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

        ArrayList<Words> phrasesWords = new ArrayList<Words>();

        phrasesWords.add(new Words("one", "two"));
        phrasesWords.add(new Words("one", "two"));
        phrasesWords.add(new Words("one", "two"));
        phrasesWords.add(new Words("one", "two"));
        phrasesWords.add(new Words("one", "two"));
        phrasesWords.add(new Words("one", "two"));
        phrasesWords.add(new Words("one", "two"));
        phrasesWords.add(new Words("one", "two"));
        phrasesWords.add(new Words("one", "two"));
        phrasesWords.add(new Words("one", "two"));
        //Instacietates Object and Use on XML
        WordsAdapter phWords = new WordsAdapter(this, phrasesWords, R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(phWords);
    }
}
