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
public class PhrasesFragment extends Fragment {


    public PhrasesFragment() {
        // Required empty public constructor
    }

    private MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener( ) {
        @Override
        public void onCompletion( MediaPlayer mediaPlayer ) {
            releaseMediaPlayer();
        }
    };

    private AudioManager audioManager;
    private AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener( ) {
        @Override
        public void onAudioFocusChange( int focusChange ) {
            if (focusChange == AudioManager.AUDIOFOCUS_GAIN){
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS){
                releaseMediaPlayer();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);


        final ArrayList<Words> phrasesWords = new ArrayList<Words>( );
        phrasesWords.add(new Words("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
        phrasesWords.add(new Words("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        phrasesWords.add(new Words("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        phrasesWords.add(new Words("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
        phrasesWords.add(new Words("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        phrasesWords.add(new Words("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
        phrasesWords.add(new Words("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        phrasesWords.add(new Words("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
        phrasesWords.add(new Words("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
        phrasesWords.add(new Words("Come here.", "әnni'nem", R.raw.phrase_come_here));

        //Instacietates Object and Use on XML
        WordsAdapter phWords = new WordsAdapter(getActivity(), phrasesWords, R.color.category_phrases);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(phWords);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener( ) {
            @Override
            public void onItemClick( AdapterView<?> adapterView, View view, int position, long l ) {
                int result = audioManager.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    Words words = phrasesWords.get(position);
                    releaseMediaPlayer();
                    mediaPlayer = MediaPlayer.create(getActivity(), words.getSongResource( ));
                    mediaPlayer.start( );
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

    private void releaseMediaPlayer(){
        if (mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
            audioManager.abandonAudioFocus(afChangeListener);
        }
    }

}
