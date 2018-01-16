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
        ArrayList<Colors> colors = new ArrayList<Colors>();

        //Add on ArrayList
        colors.add(new Colors("lutti", "one"));
        colors.add(new Colors("lutti", "one"));
        colors.add(new Colors("lutti", "one"));
        colors.add(new Colors("lutti", "one"));
        colors.add(new Colors("lutti", "one"));
        colors.add(new Colors("lutti", "one"));
        colors.add(new Colors("lutti", "one"));
        colors.add(new Colors("lutti", "one"));
        colors.add(new Colors("lutti", "one"));
        colors.add(new Colors("lutti", "one"));

        //Instaciate a objeact to inflate two textview instead of one
        ColorsAdapter colorsAdapter = new ColorsAdapter(this, colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(colorsAdapter);
    }
}
