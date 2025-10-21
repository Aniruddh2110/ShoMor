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

public class waterAdapter extends ArrayAdapter<waterDC> {
    public waterAdapter(@NonNull Context context, ArrayList<waterDC> dataArrayList) {
        super(context, R.layout.waterfall_item, dataArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        waterDC listData = getItem(position);

        if (view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.waterfall_item, parent, false);
        }

        ImageView listImage = view.findViewById(R.id.waterImage);
        TextView listName = view.findViewById(R.id.waterName);
        TextView listRating = view.findViewById(R.id.waterrating);

        listImage.setImageResource(listData.image);
        listName.setText(listData.name);
        listRating.setText(listData.rating);

        return view;
    }
}