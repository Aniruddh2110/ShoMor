package com.example.shomore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shomore.databinding.ActivityDetailBinding;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;
    MyAdapter listAdapter;
    ArrayList<DataClass> dataArrayList = new ArrayList<>();
    DataClass listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();
        if (intent != null){
            String name = intent.getStringExtra("name");
            String rating = intent.getStringExtra("rating");
            int desc = intent.getIntExtra("desc", R.string.miramar);
            int image = intent.getIntExtra("image", R.drawable.miramar);

            binding.detailName.setText(name);
            binding.detailRating.setText(rating);
            binding.detailDesc.setText(desc);
            binding.detailImage.setImageResource(image);
        }

        int[] imageList = {R.drawable.miramar, R.drawable.candolim, R.drawable.butterfly, R.drawable.majorda};
        int[] descList = {R.string.miramar, R.string.candolim, R.string.butterfly,R.string.majorda};
        String[] nameList = {"Miramar Beach", "Candolim Beach", "Butterfly Beach", "Majorda Beach"};
        String[] ratingList = {"4.6","4.0","5.0","5.0"};

        for (int i = 0; i < imageList.length; i++){
            listData = new DataClass(nameList[i], descList[i], imageList[i], ratingList[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new MyAdapter(DetailActivity.this, dataArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);

        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(DetailActivity.this, DetailActivity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                intent.putExtra("rating", ratingList[i]);
                startActivity(intent);
            }
        });

    }
}