package com.example.food;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.LauncherActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class receiverpage extends AppCompatActivity {
    ListView items;
    EditText food,donor,phn,q;
    Button donate;

    donordb db;
    ArrayList<String> arrayList;
    ListAdapter adapter;
   // TextView t;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiverpage);
        arrayList = new ArrayList<>();
        items = findViewById(R.id.items);
       /* donor=findViewById(R.id.name);
        q=findViewById(R.id.quantity);
        phn=findViewById(R.id.phno);
        donate = findViewById(R.id.donate1);
        items = findViewById(R.id.items);
        food = findViewById(R.id.food);*/
        db = new donordb(this);
        Cursor cursor = db.getdata();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                arrayList.add(cursor.getString(0));

            }

        }
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        items.setAdapter(adapter);
      items.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               /*String result= String.valueOf(db.getparticulardata(String.valueOf(view)));
               t.setText(result);*/
                String a = null,b = null,c = null,d = null,e=null,f=null,g=null;
                Toast.makeText(receiverpage.this, "You clicked"+arrayList.get(i), Toast.LENGTH_SHORT).show();
                String s=arrayList.get(i);
                Cursor cursor1=db.getparticulardata(s);
                if (cursor1.getCount() > 0) {
                    while (cursor1.moveToNext()) {
                        a=cursor1.getString(0);
                        b=cursor1.getString(1);
                        c=cursor1.getString(2);
                        d=cursor1.getString(3);
                        e=cursor1.getString(4);
                        f=cursor1.getString(5);
                        g=cursor1.getString(6);
                    }

                }
                Intent intent=new Intent(receiverpage.this,ListViewDetails.class);
                intent.putExtra("name",a);
                intent.putExtra("food",b);
                intent.putExtra("quantity",c);
                intent.putExtra("contact",d);
                intent.putExtra("date",e);
                intent.putExtra("time",f);
                intent.putExtra("address",g);
                startActivity(intent);
            }
        });

        
    }

}