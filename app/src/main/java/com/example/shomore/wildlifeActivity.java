package com.example.shomore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shomore.Activities.MainActivity2;
import com.example.shomore.databinding.ActivityWildlifeBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class wildlifeActivity extends AppCompatActivity {

    ActivityWildlifeBinding binding;
    wildAdapter listAdapter;
    ArrayList<wildDC> dataArrayList = new ArrayList<>();
    wildDC listData;
    LinearLayout profilebtn,settingbtn;
    FloatingActionButton homebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWildlifeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        profilebtn=findViewById(R.id.beachprofilebtn);
        settingbtn=findViewById(R.id.beachsettingbtn);
        homebtn=findViewById(R.id.beachhomebtn);

        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(wildlifeActivity.this, profileActivity.class);
                startActivity(intent);
                finish();
            }
        });
        settingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(wildlifeActivity.this, settingActivity.class);
                startActivity(intent);
                finish();
            }
        });
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(wildlifeActivity.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });

        int[] imageList = {R.drawable.wildlife, R.drawable.mollem_wfs, R.drawable.netravali_wildlife_sanctuary, R.drawable.salim_ali_sanctuary, R.drawable.mhadei_wildlife_sanctuary, R.drawable.bhagwan_mahavir_wildlife_sanctuary_mollem, R.drawable.palolem_island_reserve, R.drawable.mystic_wood_by_the_butterfly, R.drawable.cotigao_wfs};
        int[] descList = {R.string.bondla, R.string.mollem, R.string.netravaliwf,R.string.drsalimali,R.string.madei,R.string.bhagwan, R.string.palolem,R.string.mystic, R.string.cotigao};
        String[] nameList = {"Bondla Wildlife Sanctuary","Mollem Wildlife Sanctuary	","Netrawali Wildlife Sanctuary	","Dr. Salim Ali Bird Sanctuary	","Mhadei Wildlife Sanctuary","Bhagwan Mahavir Wildlife Sanctuary", "Palolem Island reserve", "Mystic Wood by the Butterfly", "Cotigao Wildlife Sanctuary"};
        String[] ratingList = {"4.0","4.0","4.9","4.5","4.0","5.0","3.9","4.8","4.5"};

        for (int i = 0; i < imageList.length; i++){
            listData = new wildDC(nameList[i], descList[i], imageList[i], ratingList[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new wildAdapter(wildlifeActivity.this, dataArrayList);
        binding.listview2.setAdapter(listAdapter);
        binding.listview2.setClickable(true);

        binding.listview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(wildlifeActivity.this, wildlife_Detail_Activity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                intent.putExtra("rating", ratingList[i]);
                startActivity(intent);
            }
        });
    }
}