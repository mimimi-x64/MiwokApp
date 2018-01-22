package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener( ) {
        @Override
        public void onCompletion( MediaPlayer mMediaPlayer ) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // Create a list of numbers using Word.class
        final ArrayList<Words> numbers = new ArrayList<Words>();
        //Instanciates Object with values

        //Add on ArrayList
        numbers.add(new Words("one", "lutti", R.drawable.number_one, R.raw.number_one));
        numbers.add(new Words("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        numbers.add(new Words("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        numbers.add(new Words("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        numbers.add(new Words("five", "massokka", R.drawable.number_five, R.raw.number_five));
        numbers.add(new Words("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        numbers.add(new Words("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        numbers.add(new Words("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        numbers.add(new Words("nine", "wo’e", R.drawable.number_nine, R.raw.number_nine));
        numbers.add(new Words("ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten));

        final WordsAdapter numbersAdapter = new WordsAdapter(this, numbers, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(numbersAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener( ) {
            @Override
            public void onItemClick( AdapterView<?> adapterView, View view, int positon, long l ) {
                releaseMediaPlayer();
                Words words = numbers.get(positon) ;
                MediaPlayer mMediaPlayer = MediaPlayer.create(NumbersActivity.this, words.getSongResource());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);

            }
        });
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}

