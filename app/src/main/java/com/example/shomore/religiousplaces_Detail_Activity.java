package com.example.shomore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shomore.databinding.ActivityReligiousplacesDetailBinding;

import java.util.ArrayList;

public class religiousplaces_Detail_Activity extends AppCompatActivity {

    ActivityReligiousplacesDetailBinding binding;
    reliplaAdapter listAdapter;
    ArrayList<reliplaDC> dataArrayList = new ArrayList<>();
    reliplaDC listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReligiousplacesDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();
        if (intent != null){
            String name = intent.getStringExtra("name");
            String rating = intent.getStringExtra("rating");
            int desc = intent.getIntExtra("desc", R.string.birla);
            int image = intent.getIntExtra("image", R.drawable.birla_temple_rp);

            binding.namederepl.setText(name);
            binding.ratingderepl.setText(rating);
            binding.descderepl.setText(desc);
            binding.imagederepl.setImageResource(image);
        }

        int[] imageList = {R.drawable.birla_temple_rp, R.drawable.church_of_st_john_the_baptist_rp,R.drawable.st_alex_rp,R.drawable.holy_family_church_marcela_rp};
        int[] descList = {R.string.birla, R.string.baptist,R.string.alex,R.string.holy};
        String[] nameList = {"Birla Radha Krishna Temple","Church of St John the Baptist","St Alex Church","Holy Family Church"};
        String[] ratingList = {"4.9","4.2","4.8","4.4"};

        for (int i = 0; i < imageList.length; i++){
            listData = new reliplaDC(nameList[i], descList[i], imageList[i], ratingList[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new reliplaAdapter(religiousplaces_Detail_Activity.this, dataArrayList);
        binding.listview4.setAdapter(listAdapter);
        binding.listview4.setClickable(true);

        binding.listview4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(religiousplaces_Detail_Activity.this, religiousplaces_Detail_Activity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                intent.putExtra("rating", ratingList[i]);
                startActivity(intent);
            }
        });

    }
}