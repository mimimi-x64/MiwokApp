package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamillyActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener( ) {
        @Override
        public void onCompletion( MediaPlayer mediaPlayer ) {
            releaseMediaPlayer();
        }
    };

    private AudioManager audioManager;
    AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener( ) {
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
        setContentView(R.layout.activity_family);
        audioManager = (AudioManager) FamillyActivity.this.getSystemService(Context.AUDIO_SERVICE);

        //Instanciates an ArrayList
        final ArrayList<Words> famillyArray = new ArrayList<Words>( );

        //Supply Array
        famillyArray.add(new Words("father", "әpә", R.drawable.family_father, R.raw.family_father));
        famillyArray.add(new Words("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
        famillyArray.add(new Words("son", "angsi", R.drawable.family_son, R.raw.family_son));
        famillyArray.add(new Words("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        famillyArray.add(new Words("older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        famillyArray.add(new Words("younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        famillyArray.add(new Words("older sister", "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        famillyArray.add(new Words("younger sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        famillyArray.add(new Words("grandmother ", "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        famillyArray.add(new Words("grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather));

        WordsAdapter famillyAdapter = new WordsAdapter(this, famillyArray, R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(famillyAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener( ) {
            @Override
            public void onItemClick( AdapterView<?> adapterView, View view, int position, long l ) {
                int result = audioManager.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    Words getSong = famillyArray.get(position);
                    releaseMediaPlayer();
                    mediaPlayer = MediaPlayer.create(FamillyActivity.this, getSong.getSongResource());
                    mediaPlayer.start();
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
