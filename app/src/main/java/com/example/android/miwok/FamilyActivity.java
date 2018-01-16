package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        //Instanciates an ArrayList
        ArrayList<FamillyWords> famillyArray= new ArrayList<FamillyWords>();

        //Supply Array
        famillyArray.add(new FamillyWords("one", "two") );
        famillyArray.add(new FamillyWords("one", "two") );
        famillyArray.add(new FamillyWords("one", "two") );
        famillyArray.add(new FamillyWords("one", "two") );
        famillyArray.add(new FamillyWords("one", "two") );
        famillyArray.add(new FamillyWords("one", "two") );
        famillyArray.add(new FamillyWords("one", "two") );
        famillyArray.add(new FamillyWords("one", "two") );
        famillyArray.add(new FamillyWords("one", "two") );
        famillyArray.add(new FamillyWords("one", "two") );

        FamillyAdapter famillyAdapter = new FamillyAdapter(this, famillyArray);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(famillyAdapter);
    }
}
