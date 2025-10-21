package com.example.shomore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shomore.databinding.ActivityWaterfallDetailBinding;

import java.util.ArrayList;

public class waterfall_Detail_Activity extends AppCompatActivity {

    ActivityWaterfallDetailBinding binding;
    waterAdapter listAdapter;
    ArrayList<waterDC> dataArrayList = new ArrayList<>();
    waterDC listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWaterfallDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();
        if (intent != null){
            String name = intent.getStringExtra("name");
            String rating = intent.getStringExtra("rating");
            int desc = intent.getIntExtra("desc", R.string.majorda);
            int image = intent.getIntExtra("image", R.drawable.waterfall);

            binding.nameWater.setText(name);
            binding.ratingWater.setText(rating);
            binding.descWater.setText(desc);
            binding.imageWater.setImageResource(image);
        }

        int[] imageList = {R.drawable.waterfall, R.drawable.tambdi_surla, R.drawable.bamanbudo,R.drawable.amboli};
        int[] descList = {R.string.dudhsagar,  R.string.tambdisurla,R.string.bamanbudo, R.string.amboli};
        String[] nameList = {"Dudhsagar	Waterfall","Tamdi surla Waterfall","Bamanbudo Waterfall","Amboli Waterfall"};
        String[] ratingList = {"5.0","4.2","4.8","4.2"};

        for (int i = 0; i < imageList.length; i++){
            listData = new waterDC(nameList[i], descList[i], imageList[i], ratingList[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new waterAdapter(waterfall_Detail_Activity.this, dataArrayList);
        binding.listview1.setAdapter(listAdapter);
        binding.listview1.setClickable(true);

        binding.listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(waterfall_Detail_Activity.this, waterfall_Detail_Activity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                intent.putExtra("rating", ratingList[i]);
                startActivity(intent);
            }
        });

    }
}