package com.example.food;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class donor_receiver extends AppCompatActivity {
 Button donation,receive;
    @SuppressLint("MissingInflatedId" )
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_receiver);
        donation=findViewById(R.id.donate);
        receive=findViewById(R.id.receive);
        donation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in=new Intent(donor_receiver.this,donorpage.class);
                startActivity(in);
                finish();
            }
        });
        receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(donor_receiver.this,receiverpage.class);
                startActivity(intent);
                finish();
            }
        });

    }
}