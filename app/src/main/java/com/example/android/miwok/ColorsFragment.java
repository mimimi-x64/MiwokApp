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
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorsFragment extends Fragment {


    public ColorsFragment() {
        // Required empty public constructor
    }

    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;
    private AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener( ) {
        @Override
        public void onAudioFocusChange( int focusChange ) {
            if(focusChange == AudioManager.AUDIOFOCUS_GAIN){
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS){
                releaseMediaPlayer();
            } else if ( focusChange == AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT){
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            }
        }
    };

    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener( ) {
        @Override
        public void onCompletion( MediaPlayer mediaPlayer ) {
            releaseMediaPlayer();
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        //First, Create a ArrayList and put some data man!
        final ArrayList<Words> colors = new ArrayList<Words>( );

        //Add on ArrayList
        colors.add(new Words("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        colors.add(new Words("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
        colors.add(new Words("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        colors.add(new Words("green", "chokokki", R.drawable.color_green, R.raw.color_green));
        colors.add(new Words("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        colors.add(new Words("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        colors.add(new Words("black", "kululli", R.drawable.color_black, R.raw.color_black));
        colors.add(new Words("white", "kelelli", R.drawable.color_white, R.raw.color_white));

        //Instaciate a objeact to inflate two textview instead of one
        WordsAdapter colorsAdapter = new WordsAdapter(getActivity(), colors, R.color.category_colors);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(colorsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener( ) {
            @Override
            public void onItemClick( AdapterView<?> adapterView, View view, int position, long l ) {
                Words getSong = colors.get(position);
                int result = audioManager.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    releaseMediaPlayer();
                    mediaPlayer = MediaPlayer.create(getActivity(), getSong.getSongResource( ));
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(mOnCompletionListener);
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
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            audioManager.abandonAudioFocus(afChangeListener);
        }
    }
}
