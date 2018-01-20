package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        //Instanciates an ArrayList
        ArrayList<Words> famillyArray= new ArrayList<Words>();

        //Supply Array
        famillyArray.add(new Words("one", "two", R.mipmap.ic_launcher));
        famillyArray.add(new Words("one", "two", R.mipmap.ic_launcher));
        famillyArray.add(new Words("one", "two", R.mipmap.ic_launcher));
        famillyArray.add(new Words("one", "two", R.mipmap.ic_launcher));
        famillyArray.add(new Words("one", "two", R.mipmap.ic_launcher));
        famillyArray.add(new Words("one", "two", R.mipmap.ic_launcher));
        famillyArray.add(new Words("one", "two", R.mipmap.ic_launcher));
        famillyArray.add(new Words("one", "two", R.mipmap.ic_launcher));
        famillyArray.add(new Words("one", "two", R.mipmap.ic_launcher));
        famillyArray.add(new Words("one", "two", R.mipmap.ic_launcher));

        WordsAdapter famillyAdapter = new WordsAdapter(this, famillyArray, R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(famillyAdapter);
    }
}
