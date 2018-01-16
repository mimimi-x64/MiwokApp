package com.example.android.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by phartmann on 16/01/2018.
 */

public class FamillyAdapter extends ArrayAdapter<FamillyWords> {

    public FamillyAdapter( Activity context, ArrayList<FamillyWords> FamillyWords ){
        super(context,0, FamillyWords);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        FamillyWords currentWord = getItem(position);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwokWords);
        miwokTextView.setText(currentWord.getMiwok());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.englishWords);
        defaultTextView.setText(currentWord.getDefault());

        return listItemView;

    }

}
