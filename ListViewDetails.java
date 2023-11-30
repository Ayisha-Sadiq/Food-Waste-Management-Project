package com.example.food;
import com.example.food.R;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.widget.TextView;

public class ListViewDetails extends AppCompatActivity {

    TextView name,food,quality,contac,date,time,address;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_details);
        quality=findViewById(R.id.listquantity);
        name = findViewById(R.id.listdonar);
        food = findViewById(R.id.listfood);
        contac=findViewById(R.id.listcontact);
        date=findViewById(R.id.listdate);
        time=findViewById(R.id.listtime);
        address=findViewById(R.id.listaddress);

        name.setText(getIntent().getExtras().getString("name"));
        food.setText(getIntent().getExtras().getString("food"));
        quality.setText(getIntent().getExtras().getString("quantity"));
        contac.setText(getIntent().getExtras().getString("contact"));
        date.setText(getIntent().getExtras().getString("date"));
        time.setText(getIntent().getExtras().getString("time"));
        address.setText(getIntent().getExtras().getString("address"));

    }
}