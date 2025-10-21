package com.example.shomore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shomore.databinding.ActivityHeritageDetailBinding;

import java.util.ArrayList;

public class heritage_Detail_Activity extends AppCompatActivity {

    ActivityHeritageDetailBinding binding;
    heriAdapter listAdapter;
    ArrayList<heriDC> dataArrayList = new ArrayList<>();
    heriDC listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHeritageDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();
        if (intent != null){
            String name = intent.getStringExtra("name");
            String rating = intent.getStringExtra("rating");
            int desc = intent.getIntExtra("desc", R.string.keri);
            int image = intent.getIntExtra("image", R.drawable.heritage);

            binding.heriName.setText(name);
            binding.heriRating.setText(rating);
            binding.heriDesc.setText(desc);
            binding.heriImage.setImageResource(image);
        }

        int[] imageList = {R.drawable.reismogos_fort_heritage, R.drawable.pandava_cave_heritage, R.drawable.viceroys_arch__heritage,R.drawable.figueierdo_mansion};
        int[] descList = {R.string.reisfort, R.string.pandava,R.string.viceroys,R.string.figueiredo,};
        String[] nameList = {"Reis Fagos fort","Pandava Cave","Viceroys Arch","The Figueierdo Mansion"};
        String[] ratingList = {"5.0","4.9","4.5","4.6"};

        for (int i = 0; i < imageList.length; i++){
            listData = new heriDC(nameList[i], descList[i], imageList[i], ratingList[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new heriAdapter(heritage_Detail_Activity.this, dataArrayList);
        binding.listview3.setAdapter(listAdapter);
        binding.listview3.setClickable(true);

        binding.listview3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(heritage_Detail_Activity.this, heritage_Detail_Activity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                intent.putExtra("rating", ratingList[i]);
                startActivity(intent);
            }
        });

    }
}