package com.example.shomore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class waterplaceActivity extends AppCompatActivity {

    Spinner spinner;
    ConstraintLayout button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_waterplace);

        spinner=findViewById(R.id.spin);
        button=findViewById(R.id.sub);

        String[] places={"Pernem", "Bardez", "Bicholim", "Satari", "Tiswadi", "Ponda", "Murmgao", "Salcete", "Sanguem"," Quepem","Dharbandora","Canacona"};
        ArrayAdapter<String>adapter=new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,places);
        spinner.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(waterplaceActivity.this, waterfallActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}