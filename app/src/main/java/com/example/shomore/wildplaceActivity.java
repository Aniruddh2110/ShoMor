package com.example.shomore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class wildplaceActivity extends AppCompatActivity {

    Spinner spinner;
    ConstraintLayout button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_wildplace);

        spinner=findViewById(R.id.spinner1);
        button=findViewById(R.id.submit1);

        String[] places={"Pernem", "Bardez", "Bicholim", "Satari", "Tiswadi", "Ponda", "Murmgao", "Salcete", "Sanguem"," Quepem","Dharbandora","Canacona"};
        ArrayAdapter<String>adapter=new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,places);
        spinner.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(wildplaceActivity.this, wildlifeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}