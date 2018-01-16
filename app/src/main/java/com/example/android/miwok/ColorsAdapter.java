package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by phartmann on 15/01/2018.
 */

public class ColorsAdapter extends ArrayAdapter<Colors> {

    public ColorsAdapter( Activity context, ArrayList<Colors> Colors ){
        super(context,0, Colors);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Colors currentWord = getItem(position);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwokWords);
        miwokTextView.setText(currentWord.getMiwokColors());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.englishWords);
        defaultTextView.setText(currentWord.getDefaultColors());

        return listItemView;

    }
}
