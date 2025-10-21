package com.example.shomore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shomore.Activities.MainActivity2;
import com.example.shomore.databinding.ActivityBeachBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class beachActivity extends AppCompatActivity {

    ActivityBeachBinding binding;
    MyAdapter listAdapter;
    ArrayList<DataClass> dataArrayList = new ArrayList<>();
    DataClass listData;
    LinearLayout profilebtn,settingbtn;
    FloatingActionButton homebtn;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBeachBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        profilebtn=findViewById(R.id.beachprofilebtn);
        settingbtn=findViewById(R.id.beachsettingbtn);
        homebtn=findViewById(R.id.beachhomebtn);

        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(beachActivity.this, profileActivity.class);
                startActivity(intent);
                finish();
            }
        });
        settingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(beachActivity.this, settingActivity.class);
                startActivity(intent);
                finish();
            }
        });
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(beachActivity.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });

        int[] imageList = {R.drawable.miramar, R.drawable.baga, R.drawable.candolim, R.drawable.vagator, R.drawable.butterfly, R.drawable.beach, R.drawable.majorda, R.drawable.betalbatim, R.drawable.keri, R.drawable.chapora};
        int[] descList = {R.string.miramar, R.string.baga, R.string.candolim,R.string.vagator,R.string.butterfly,R.string.palolem, R.string.majorda,R.string.betalbatim, R.string.keri, R.string.chapora};
        String[] nameList = {"Miramar Beach","Baga Beach","Candolim Beach","Vagator Beach","Butterfly Beach","Palolem Beach","Majorda Beach","Betalbatim Beach","Keri Beach","Chapora Beach"};
        String[] ratingList = {"4.6","5.0","4.0","4.5","5.0","4.6","5.0","5.0","4.6","4.0"};

        for (int i = 0; i < imageList.length; i++){
            listData = new DataClass(nameList[i], descList[i], imageList[i], ratingList[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new MyAdapter(beachActivity.this, dataArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);

        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(beachActivity.this, DetailActivity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                intent.putExtra("rating", ratingList[i]);
                startActivity(intent);
            }
        });
    }
}