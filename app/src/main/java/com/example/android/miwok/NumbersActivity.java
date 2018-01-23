package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
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
    private AudioManager audioManager;
    private AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener( ) {
        @Override
        public void onAudioFocusChange( int focusChage ) {
            if (focusChage == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start( );
            } else if (focusChage == AudioManager.AUDIOFOCUS_LOSS){
                releaseMediaPlayer();
            } else if (focusChage == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChage == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }
        }
    };

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

        audioManager = (AudioManager) NumbersActivity.this.getSystemService(Context.AUDIO_SERVICE);

        // Create a list of numbers using Word.class
        final ArrayList<Words> numbers = new ArrayList<Words>( );
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
                int result = audioManager.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    Words words = numbers.get(positon);
                    releaseMediaPlayer( );
                    mMediaPlayer = MediaPlayer.create(NumbersActivity.this, words.getSongResource( ));
                    // afChangeListener.onAudioFocusChange(AudioManager.AUDIOFOCUS_REQUEST_GRANTED); // Could not do I this instead?m
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
    }

    @Override
    protected void onStop(){
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            audioManager.abandonAudioFocus(afChangeListener);
        }
    }
}