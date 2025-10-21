package com.example.shomore;

import static com.example.shomore.R.id.homepgbutn;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.shomore.Activities.MainActivity2;

public class settingActivity extends AppCompatActivity {

    ConstraintLayout homepage;
    ConstraintLayout logoutBtn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        homepage =findViewById(homepgbutn);
        logoutBtn=findViewById(R.id.logoutbutn);

        homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(settingActivity.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(settingActivity.this, loginpg.class);
                startActivity(intent);
                finish();
                Toast.makeText(settingActivity.this,"Successfully Logout",Toast.LENGTH_SHORT).show();
            }
        });
    }
}