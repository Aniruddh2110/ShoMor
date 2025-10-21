package com.example.shomore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class reliplaAdapter extends ArrayAdapter<reliplaDC> {
    public reliplaAdapter(@NonNull Context context, ArrayList<reliplaDC> dataArrayList) {
        super(context, R.layout.religiousplaces_item, dataArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        reliplaDC listData = getItem(position);

        if (view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.religiousplaces_item, parent, false);
        }

        ImageView listImage = view.findViewById(R.id.imagerelipla);
        TextView listName = view.findViewById(R.id.namerelipla);
        TextView listRating = view.findViewById(R.id.ratingrelipla);

        listImage.setImageResource(listData.image);
        listName.setText(listData.name);
        listRating.setText(listData.rating);

        return view;
    }
}