package com.example.shomore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shomore.Activities.MainActivity2;
import com.example.shomore.databinding.ActivityWaterfallBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class waterfallActivity extends AppCompatActivity {

    ActivityWaterfallBinding binding;
    waterAdapter listAdapter;
    ArrayList<waterDC> dataArrayList = new ArrayList<>();
    waterDC listData;
    LinearLayout profilebtn,settingbtn;
    FloatingActionButton homebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWaterfallBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        profilebtn=findViewById(R.id.waterfallpb);
        settingbtn=findViewById(R.id.waterfallsb);
        homebtn=findViewById(R.id.waterfallhb);

        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(waterfallActivity.this, profileActivity.class);
                startActivity(intent);
                finish();
            }
        });
        settingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(waterfallActivity.this, settingActivity.class);
                startActivity(intent);
                finish();
            }
        });
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(waterfallActivity.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });

        int[] imageList = {R.drawable.waterfall, R.drawable.harvalem, R.drawable.tambdi_surla, R.drawable.netravali, R.drawable.bamanbudo, R.drawable.kuskem, R.drawable.kesarval, R.drawable.mangeli, R.drawable.amboli};
        int[] descList = {R.string.dudhsagar, R.string.harvalem, R.string.tambdisurla,R.string.netravali,R.string.bamanbudo,R.string.kuskem, R.string.kesarval,R.string.mangeli, R.string.amboli};
        String[] nameList = {"Dudhsagar	Waterfall","Harvalem Waterfall","Tamdi surla Waterfall","Netrawali Waterfall","Bamanbudo Waterfall","Kuskem	Waterfall","Keserval Waterfall","Mangeli Waterfall","Amboli Waterfall"};
        String[] ratingList = {"5.0","4.5","4.2","5.0","4.8","4.4","3.5","3.5","4.2"};

        for (int i = 0; i < imageList.length; i++){
            listData = new waterDC(nameList[i], descList[i], imageList[i], ratingList[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new waterAdapter(waterfallActivity.this, dataArrayList);
        binding.listview1.setAdapter(listAdapter);
        binding.listview1.setClickable(true);

        binding.listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(waterfallActivity.this, waterfall_Detail_Activity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                intent.putExtra("rating", ratingList[i]);
                startActivity(intent);
            }
        });
    }
}