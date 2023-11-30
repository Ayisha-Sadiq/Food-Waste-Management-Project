package com.example.food;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

import java.util.ArrayList;

public class donorpage extends AppCompatActivity {
EditText name,food,quant,phn,address;

Button donate;
donordb db;
receiverpage rc;
    @SuppressLint("MissingInflatedId" )
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donorpage);
        name=findViewById(R.id.name);
        food=findViewById(R.id.food);
        quant=findViewById(R.id.quantity);
        phn=findViewById(R.id.phno);
        donate=findViewById(R.id.donate1);
        address=findViewById(R.id.add);

        db=new donordb(this);
        rc=new receiverpage();
     // db.delete();

    donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String donorname=name.getText().toString();
                String foodname=food.getText().toString();
                String quantity=quant.getText().toString();
                String phone=phn.getText().toString();
                String addres=address.getText().toString();
                if(donorname.equals("")||foodname.equals("")||quantity.equals("")||phone.equals("")||addres.equals(""))
                {
                    Toast.makeText(donorpage.this, "Enter all Fields", Toast.LENGTH_SHORT).show();
                }
                else if(phone.length()<10)
                {
                    phn.setError("Enter valid phone no.");
                }
                else {
                    boolean result=db.insertdonationdata(donorname,foodname,quantity,phone,addres);
                    if(result==true)
                    {
                        Toast.makeText(donorpage.this, "Thanks For Donating", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(donorpage.this, "Donation Failed", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });
    }
}