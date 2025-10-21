package com.example.shomore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shomore.Activities.MainActivity2;
import com.example.shomore.databinding.ActivityReligiousplacesBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class religiousplacesActivity extends AppCompatActivity {

    ActivityReligiousplacesBinding binding;
    reliplaAdapter listAdapter;
    ArrayList<reliplaDC> dataArrayList = new ArrayList<>();
    reliplaDC listData;
    LinearLayout profilebtn,settingbtn;
    FloatingActionButton homebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReligiousplacesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        profilebtn=findViewById(R.id.beachprofilebtn);
        settingbtn=findViewById(R.id.beachsettingbtn);
        homebtn=findViewById(R.id.beachhomebtn);

        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(religiousplacesActivity.this, profileActivity.class);
                startActivity(intent);
                finish();
            }
        });
        settingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(religiousplacesActivity.this, settingActivity.class);
                startActivity(intent);
                finish();
            }
        });
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(religiousplacesActivity.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });

        int[] imageList = {R.drawable.birla_temple_rp, R.drawable.church_of_st_john_the_baptist_rp, R.drawable.jama_masjid_rp, R.drawable.shri_damodar_temple_rp, R.drawable.st_alex_rp, R.drawable.mosque_safa_rp, R.drawable.mahalasa_temple_verna_rp, R.drawable.holy_family_church_marcela_rp, R.drawable.shantadurga_temple_kavlem_main_rp, R.drawable.church_of_holy_spirit_rp};
        int[] descList = {R.string.birla, R.string.baptist, R.string.jama,R.string.damodar,R.string.alex,R.string.safa, R.string.mahalasa,R.string.holy, R.string.shantadurga, R.string.spirit};
        String[] nameList = {"Birla Radha Krishna Temple","Church of St John the Baptist","Jama Masjid","Shri Damodar Temple","St Alex Church","Safa Shahouri Mosque","Shri Mahalasa Narayani Temple","Holy Family Church","Shri Shantadurga Temple","Church of Holy Spirit"};
        String[] ratingList = {"4.9","4.2","4.0","5.0","4.8","4.7","5.0","4.4","4.3","3.5"};

        for (int i = 0; i < imageList.length; i++){
            listData = new reliplaDC(nameList[i], descList[i], imageList[i], ratingList[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new reliplaAdapter(religiousplacesActivity.this, dataArrayList);
        binding.listview4.setAdapter(listAdapter);
        binding.listview4.setClickable(true);

        binding.listview4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(religiousplacesActivity.this, religiousplaces_Detail_Activity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                intent.putExtra("rating", ratingList[i]);
                startActivity(intent);
            }
        });
    }
}