package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

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
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        audioManager = (AudioManager) PhrasesActivity.this.getSystemService(Context.AUDIO_SERVICE);


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
        WordsAdapter phWords = new WordsAdapter(this, phrasesWords, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(phWords);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener( ) {
            @Override
            public void onItemClick( AdapterView<?> adapterView, View view, int position, long l ) {
                int result = audioManager.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    Words words = phrasesWords.get(position);
                    releaseMediaPlayer();
                    mediaPlayer = MediaPlayer.create(PhrasesActivity.this, words.getSongResource( ));
                    mediaPlayer.start( );
                    mediaPlayer.setOnCompletionListener(mOnCompletionListener);
                }
            }
        });
    }

    @Override
    protected void onStop() {
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
