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

public class heriAdapter extends ArrayAdapter<heriDC> {
    public heriAdapter(@NonNull Context context, ArrayList<heriDC> dataArrayList) {
        super(context, R.layout.heritage_item, dataArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        heriDC listData = getItem(position);

        if (view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.heritage_item, parent, false);
        }

        ImageView listImage = view.findViewById(R.id.heritageImage);
        TextView listName = view.findViewById(R.id.heritageName);
        TextView listRating = view.findViewById(R.id.heritagerating);

        listImage.setImageResource(listData.image);
        listName.setText(listData.name);
        listRating.setText(listData.rating);

        return view;
    }
}