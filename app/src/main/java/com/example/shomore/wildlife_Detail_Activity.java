package com.example.shomore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shomore.databinding.ActivityWildlifeDetailBinding;

import java.util.ArrayList;

public class wildlife_Detail_Activity extends AppCompatActivity {

    ActivityWildlifeDetailBinding binding;
    wildAdapter listAdapter;
    ArrayList<wildDC> dataArrayList = new ArrayList<>();
    wildDC listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWildlifeDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();
        if (intent != null){
            String name = intent.getStringExtra("name");
            String rating = intent.getStringExtra("rating");
            int desc = intent.getIntExtra("desc", R.string.candolim);
            int image = intent.getIntExtra("image", R.drawable.wildlife);

            binding.wildName.setText(name);
            binding.wildRating.setText(rating);
            binding.wildDesc.setText(desc);
            binding.wildImage.setImageResource(image);
        }

        int[] imageList = {R.drawable.netravali_wildlife_sanctuary,R.drawable.bhagwan_mahavir_wildlife_sanctuary_mollem,R.drawable.mystic_wood_by_the_butterfly, R.drawable.cotigao_wfs};
        int[] descList = {R.string.netravaliwf,R.string.bhagwan,R.string.mystic, R.string.cotigao};
        String[] nameList = {"Netrawali Wildlife Sanctuary	","Bhagwan Mahavir Wildlife Sanctuary","Mystic Wood by the Butterfly", "Cotigao Wildlife Sanctuary"};
        String[] ratingList = {"4.9","5.0","4.8","4.5"};

        for (int i = 0; i < imageList.length; i++){
            listData = new wildDC(nameList[i], descList[i], imageList[i], ratingList[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new wildAdapter(wildlife_Detail_Activity.this, dataArrayList);
        binding.listview2.setAdapter(listAdapter);
        binding.listview2.setClickable(true);

        binding.listview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(wildlife_Detail_Activity.this, wildlife_Detail_Activity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                intent.putExtra("rating", ratingList[i]);
                startActivity(intent);
            }
        });

    }
}