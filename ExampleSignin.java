package com.example.food;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class ExampleSignin extends AppCompatActivity {
    EditText username,password;
    Button signin,signinwithgoogle;
    Exampledatabase db;
    Pattern uppercase=Pattern.compile("[A-Z]");
    Pattern lowercase=Pattern.compile("[a-z]");
    Pattern digit=Pattern.compile("[0-9]");

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_signin);
        username=findViewById(R.id._signinusername);
        password=findViewById(R.id._signinpassword);
        signin=findViewById(R.id._signinbutton);
        signinwithgoogle=findViewById(R.id._signinwthgoogle);
        db=new Exampledatabase(this);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = username.getText().toString();
                String s1 = password.getText().toString();

                if (s1.equals("") || s.equals("")) {
                    Toast.makeText(ExampleSignin.this, "Enter all fields", Toast.LENGTH_SHORT).show();}
                else if(!isEmail(s)&&isPass(s1))
                    {
                      username.setError("enter valid email");
                      password.setError("enter valid password");
                    } else if (!isEmail(s))
                    {
                    username.setError("enter valid email");
                }
                else if (isPass(s1))
                {
                    password.setError("enter valid password");
                }
                else {
                        boolean result = db.insertuserdata(s, s1);
                        if (result == false)
                            Toast.makeText(ExampleSignin.this, "user already exists", Toast.LENGTH_SHORT).show();

                        else {
                            Toast.makeText(ExampleSignin.this, "successfully register", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(ExampleSignin.this,donor_receiver.class);
                            startActivity(intent);
                            finish();

                        }
                    }
            }
        });
        signinwithgoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ExampleSignin.this,donor_receiver.class));
            }
        });
}
   boolean isEmail(String s)
   {
       return(!TextUtils.isEmpty(s)&& Patterns.EMAIL_ADDRESS.matcher(s).matches());
   }
   boolean isPass(String s1)
   {
       return(!(s1.length()<7)&&!uppercase.matcher(s1).find()&&!lowercase.matcher(s1).find()&&!digit.matcher(s1).find());
   }
}