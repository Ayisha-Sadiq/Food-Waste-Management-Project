package com.example.food;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    Button signup;
    EditText username,password;
    Exampledatabase db;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=findViewById(R.id._signupusername);
        password=findViewById(R.id._signuppassword);
        signup=findViewById(R.id._signupbutton);
        db=new Exampledatabase(this);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=username.getText().toString();
                String s1=password.getText().toString();
                boolean result=db.checkusernamepassword(s,s1);
                if(result==true){
                    Toast.makeText(login.this, "welcome", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(login.this,donor_receiver.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(login.this, "please register", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}