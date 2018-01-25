package com.example.android.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumbersFragment extends Fragment {


    public NumbersFragment() {
        // Required empty public constructor
    }

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        /** TODO: Insira todo o código do método NumberActivity’s onCreate() após a chamada do método setContentView */

        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

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

        final WordsAdapter numbersAdapter = new WordsAdapter(getActivity(), numbers, R.color.category_numbers);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(numbersAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener( ) {
            @Override
            public void onItemClick( AdapterView<?> adapterView, View view, int positon, long l ) {
                int result = audioManager.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    Words words = numbers.get(positon);
                    releaseMediaPlayer( );
                    mMediaPlayer = MediaPlayer.create(getActivity(), words.getSongResource( ));
                    // afChangeListener.onAudioFocusChange(AudioManager.AUDIOFOCUS_REQUEST_GRANTED); // Could not do I this instead?m
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop( );
        releaseMediaPlayer();
    }


    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            audioManager.abandonAudioFocus(afChangeListener);
        }
    }

}
