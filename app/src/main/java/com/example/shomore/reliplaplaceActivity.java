package com.example.shomore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.shomore.Activities.MainActivity2;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class reliplaplaceActivity extends AppCompatActivity {

    Spinner spinner;
    ConstraintLayout button;
    LinearLayout profilebtn,settingbtn;
    FloatingActionButton homebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reliplaplace);

        profilebtn=findViewById(R.id.profileplacebtn);
        settingbtn=findViewById(R.id.settingplacebtn);
        homebtn=findViewById(R.id.homeplacebtn);

        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(reliplaplaceActivity.this, profileActivity.class);
                startActivity(intent);
                finish();
            }
        });
        settingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(reliplaplaceActivity.this, settingActivity.class);
                startActivity(intent);
                finish();
            }
        });
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(reliplaplaceActivity.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });

        spinner=findViewById(R.id.spinner3);
        button=findViewById(R.id.submit3);

        String[] places={"Pernem", "Bardez", "Bicholim", "Satari", "Tiswadi", "Ponda", "Murmgao", "Salcete", "Sanguem"," Quepem","Dharbandora","Canacona"};
        ArrayAdapter<String>adapter=new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,places);
        spinner.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(reliplaplaceActivity.this, religiousplacesActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}