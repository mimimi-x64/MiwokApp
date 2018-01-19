package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // Create a list of numbers using Word.class
        ArrayList<Words> numbers = new ArrayList<Words>();
        //Instanciates Object with values

        //Add on ArrayList
        numbers.add(new Words("lutti", "one", R.mipmap.ic_launcher));
        numbers.add(new Words("lutti", "two", R.mipmap.ic_launcher));
        numbers.add(new Words("lutti", "three", R.mipmap.ic_launcher));
        numbers.add(new Words("lutti", "four", R.mipmap.ic_launcher));
        numbers.add(new Words("lutti", "five", R.mipmap.ic_launcher));
        numbers.add(new Words("lutti", "six", R.mipmap.ic_launcher));
        numbers.add(new Words("lutti", "seven", R.mipmap.ic_launcher));
        numbers.add(new Words("lutti", "eight", R.mipmap.ic_launcher));
        numbers.add(new Words("lutti", "nine", R.mipmap.ic_launcher));
        numbers.add(new Words("lutti", "ten", R.mipmap.ic_launcher));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        WordsAdapter numbersAdapter = new WordsAdapter(this, numbers);

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

