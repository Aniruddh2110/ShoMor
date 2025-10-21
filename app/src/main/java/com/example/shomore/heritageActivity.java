package com.example.shomore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shomore.Activities.MainActivity2;
import com.example.shomore.databinding.ActivityHeritageBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class heritageActivity extends AppCompatActivity {

    ActivityHeritageBinding binding;
    heriAdapter listAdapter;
    ArrayList<heriDC> dataArrayList = new ArrayList<>();
    heriDC listData;
    LinearLayout profilebtn,settingbtn;
    FloatingActionButton homebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHeritageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        profilebtn=findViewById(R.id.beachprofilebtn);
        settingbtn=findViewById(R.id.beachsettingbtn);
        homebtn=findViewById(R.id.beachhomebtn);

        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(heritageActivity.this, profileActivity.class);
                startActivity(intent);
                finish();
            }
        });
        settingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(heritageActivity.this, settingActivity.class);
                startActivity(intent);
                finish();
            }
        });
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(heritageActivity.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });

        int[] imageList = {R.drawable.reismogos_fort_heritage, R.drawable.fort_cabo_de_rama, R.drawable.fontainhas_heritage, R.drawable.pandava_cave_heritage, R.drawable.vasco_clock_tower_heritage, R.drawable.viceroys_arch__heritage, R.drawable.menezes_braganza_house_heritage,R.drawable.figueierdo_mansion,R.drawable.ancestral_goa_museum_heritage,};
        int[] descList = {R.string.reisfort, R.string.cabo, R.string.fontainhas,R.string.pandava,R.string.clocktower,R.string.viceroys, R.string.menezes,R.string.figueiredo, R.string.bigfoot};
        String[] nameList = {"Reis Fagos fort","Cabo De Rama Fort ","Fountainhas","Pandava Cave","Vasco Clock Tower","Viceroys Arch","Menezes Braganza House","The Figueierdo Mansion","Big Foot Museum"};
        String[] ratingList = {"5.0","5.0","3.9","4.9","5.0","4.5","5.0","4.6","5.0"};

        for (int i = 0; i < imageList.length; i++){
            listData = new heriDC(nameList[i], descList[i], imageList[i], ratingList[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new heriAdapter(heritageActivity.this, dataArrayList);
        binding.listview3.setAdapter(listAdapter);
        binding.listview3.setClickable(true);

        binding.listview3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(heritageActivity.this, heritage_Detail_Activity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                intent.putExtra("rating", ratingList[i]);
                startActivity(intent);
            }
        });
    }
}