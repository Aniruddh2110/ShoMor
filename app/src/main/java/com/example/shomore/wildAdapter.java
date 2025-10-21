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

public class wildAdapter extends ArrayAdapter<wildDC> {
    public wildAdapter(@NonNull Context context, ArrayList<wildDC> dataArrayList) {
        super(context, R.layout.wildlife_item, dataArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        wildDC listData = getItem(position);

        if (view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.wildlife_item, parent, false);
        }

        ImageView listImage = view.findViewById(R.id.wildlifeImage);
        TextView listName = view.findViewById(R.id.wildlifeName);
        TextView listRating = view.findViewById(R.id.wildliferating);

        listImage.setImageResource(listData.image);
        listName.setText(listData.name);
        listRating.setText(listData.rating);

        return view;
    }
}