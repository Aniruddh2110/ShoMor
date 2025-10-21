package com.example.shomore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class heriplaceActivity extends AppCompatActivity {

    Spinner spinner;
    ConstraintLayout button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_heriplace);

        spinner=findViewById(R.id.spinner2);
        button=findViewById(R.id.submit2);

        String[] places={"Pernem", "Bardez", "Bicholim", "Satari", "Tiswadi", "Ponda", "Murmgao", "Salcete", "Sanguem"," Quepem","Dharbandora","Canacona"};
        ArrayAdapter<String>adapter=new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,places);
        spinner.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(heriplaceActivity.this, heritageActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}