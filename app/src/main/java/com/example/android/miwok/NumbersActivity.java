package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // Create a list of numbers using Word.class
        ArrayList<Numbers> numbers = new ArrayList<Numbers>();
        //Instanciates Object with values

        //Add on ArrayList
        numbers.add(new Numbers("lutti", "one"));
        numbers.add(new Numbers("lutti", "two"));
        numbers.add(new Numbers("lutti", "three"));
        numbers.add(new Numbers("lutti", "four"));
        numbers.add(new Numbers("lutti", "five"));
        numbers.add(new Numbers("lutti", "six"));
        numbers.add(new Numbers("lutti", "seven"));
        numbers.add(new Numbers("lutti", "eight"));
        numbers.add(new Numbers("lutti", "nine"));
        numbers.add(new Numbers("lutti", "ten"));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        NumbersAdapter numbersAdapter = new NumbersAdapter(this, numbers);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of numbers.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(numbersAdapter);

    }
}

