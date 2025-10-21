package com.example.shomore.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.shomore.R;
import com.example.shomore.signup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout introbtn = findViewById(R.id.introbtn);
        introbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent to start the desired activity
                openMainActivity();
            }
        });

    }

    private void openMainActivity() {
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
    }
}