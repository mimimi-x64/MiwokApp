package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        //First, Create a ArrayList and put some data man!
        ArrayList<Words> colors = new ArrayList<Words>();

        //Add on ArrayList
        colors.add(new Words("lutti", "one", R.mipmap.ic_launcher));
        colors.add(new Words("lutti", "one", R.mipmap.ic_launcher));
        colors.add(new Words("lutti", "one", R.mipmap.ic_launcher));
        colors.add(new Words("lutti", "one", R.mipmap.ic_launcher));
        colors.add(new Words("lutti", "one", R.mipmap.ic_launcher));
        colors.add(new Words("lutti", "one", R.mipmap.ic_launcher));
        colors.add(new Words("lutti", "one", R.mipmap.ic_launcher));
        colors.add(new Words("lutti", "one", R.mipmap.ic_launcher));
        colors.add(new Words("lutti", "one", R.mipmap.ic_launcher));
        colors.add(new Words("lutti", "one", R.mipmap.ic_launcher));

        //Instaciate a objeact to inflate two textview instead of one
        WordsAdapter colorsAdapter = new WordsAdapter(this, colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(colorsAdapter);
    }
}
