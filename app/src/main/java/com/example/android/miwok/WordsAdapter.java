package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by phartmann on 13/01/2018.
 */

public class WordsAdapter extends ArrayAdapter<Words> {

    private int mCategoryColors;
    MediaPlayer mediaPlayer;

    public WordsAdapter( Activity context, ArrayList<Words> Words, int categoryColors) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, Words);
        mCategoryColors = categoryColors;
    }

    @Override
    public View getView( int position, View convertView, ViewGroup parent ) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext( )).inflate(
                    R.layout.list_item, parent, false);
           listItemView.setBackgroundResource(mCategoryColors);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        final Words currentWord = getItem(position);
        /**
         * First Self implementation of OnClickListener on each View.
         *
        //Find the Button in the list_item.xml with the ID
        Button playButton = (Button) listItemView.findViewById(R.id.playButton);
        mediaPlayer = MediaPlayer.create(getContext(), currentWord.getSongResource());
        playButton.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick( View view ) {
                mediaPlayer.start();
            }
        });
        */

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.miwokWords);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentWord.getMiwokTranslation( ));

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.englishWords);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        numberTextView.setText(currentWord.getDefaulTranslation( ));

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.imageList);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        iconView.setImageResource( currentWord.getImageResource( ));

        if (currentWord.checkImageResource()){
            iconView.setImageResource( currentWord.getImageResource( ));
            iconView.setVisibility(View.VISIBLE);
        } else {
            iconView.setVisibility(View.GONE);
        }
        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}

