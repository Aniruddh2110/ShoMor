package com.example.shomore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.shomore.Activities.MainActivity2;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {

    EditText signupName, signupUsername, signupEmail, signupPassword;
    TextView signin;
    ConstraintLayout registerbtn;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signupName = findViewById(R.id.signupname);
        signupEmail = findViewById(R.id.signupEmail);
        signupUsername = findViewById(R.id.signupUser);
        signupPassword = findViewById(R.id.signupPass);
        signin = findViewById(R.id.signIn);
        registerbtn = findViewById(R.id.registerbtn);

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(signup.this,loginpg.class);
                startActivity(intent);
                Toast.makeText(signup.this,"Successfully Register",Toast.LENGTH_SHORT).show();

                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");

                String name = signupName.getText().toString();
                String email = signupEmail.getText().toString();
                String username = signupUsername.getText().toString();
                String password = signupPassword.getText().toString();

                HelperClass helperClass;
                helperClass = new HelperClass(name, email, username, password);
                reference.child(username).setValue(helperClass);
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signup.this, loginpg.class);
                startActivity(intent);
            }
        });
    }
}