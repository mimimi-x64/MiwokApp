package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamillyActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

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

        final WordsAdapter famillyAdapter = new WordsAdapter(this, famillyArray, R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(famillyAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener( ) {
            @Override
            public void onItemClick( AdapterView<?> adapterView, View view, int position, long l ) {
                Words getSong = famillyArray.get(position);
                MediaPlayer mediaPlayer = MediaPlayer.create(FamillyActivity.this, getSong.getSongResource());
                releaseMediaPlayer();
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener( ) {
                    @Override
                    public void onCompletion( MediaPlayer mediaPlayer ) {
                        releaseMediaPlayer();
                    }
                });
            }
        });
    }
    private void releaseMediaPlayer(){
        if (mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
