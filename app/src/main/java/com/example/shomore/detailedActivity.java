package com.example.shomore;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.shomore.Domains.PopularDomain;

public class detailedActivity extends AppCompatActivity {

    private TextView titleTxt,descriptionTxt,scoreTxt;
    private PopularDomain item;
    private ImageView picImg,backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        initView();
        setVariable();
    }

    private void setVariable() {
        item =(PopularDomain) getIntent().getSerializableExtra("object");

        titleTxt.setText(item.getTitle());
        scoreTxt.setText(""+(int) item.getScore());
        descriptionTxt.setText(item.getDescription());


        int drawableResId=getResources().getIdentifier(item.getPic(),"drawable",getPackageName());

        Glide.with(this)
                .load(drawableResId)
                .into(picImg);

        backBtn.setOnClickListener(v -> finish());
    }

    private void initView() {
        titleTxt=findViewById(R.id.titleTxt);
        descriptionTxt=findViewById(R.id.descriptionTxt);
        scoreTxt=findViewById(R.id.scoreTxt);
        picImg=findViewById(R.id.picImg);
        backBtn=findViewById(R.id.backBtn);
    }
}