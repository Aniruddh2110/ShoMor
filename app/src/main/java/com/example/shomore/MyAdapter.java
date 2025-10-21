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

public class MyAdapter extends ArrayAdapter<DataClass> {
    public MyAdapter(@NonNull Context context, ArrayList<DataClass> dataArrayList) {
        super(context, R.layout.recycler_item, dataArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        DataClass listData = getItem(position);

        if (view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.recycler_item, parent, false);
        }

        ImageView listImage = view.findViewById(R.id.listImage);
        TextView listName = view.findViewById(R.id.listName);
        TextView listRating = view.findViewById(R.id.rating);

        listImage.setImageResource(listData.image);
        listName.setText(listData.name);
        listRating.setText(listData.rating);

        return view;
    }
}