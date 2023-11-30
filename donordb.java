package com.example.food;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class donordb extends SQLiteOpenHelper {
    public donordb(@Nullable Context context) {
        super(context, "foodtable", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sq) {
        sq.execSQL("create table fooddetails(name TEXT,food Text,quantity Text,contact Text,address Text,Date date,time Text,primary key(date,contact,time))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sq, int i, int i1) {
       sq.execSQL("drop table if exists fooddetails");
    }
    public Boolean insertdonationdata (String name,String food,String quan,String contact,String address)
    {
        SQLiteDatabase DB=this.getWritableDatabase();
       // String sql = "DELETE FROM available WHERE timestamp <= datetime('now','-3 minutes')";
        //DB.execSQL(sql);
      String date=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
       String   time = new SimpleDateFormat("HH:mm").format(new Date());
       // Date date=new Date();
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("food",food);
        cv.put("quantity",quan);
        cv.put("contact",contact);
        cv.put("Date", date);
        cv.put("time",time);
        cv.put("address",address);
        long result=DB.insert("fooddetails",null,cv);
        if(result==-1)
            return false;
        else
            return true;

    }
    public void delete()
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        String sql = "DELETE FROM fooddetails WHERE date<=DATE('now','-2 days')";
         DB.execSQL(sql);

    }
    public Cursor getdata(){
        SQLiteDatabase db=this.getWritableDatabase();
        String query="select food from fooddetails WHERE date>DATE('now','-2 days')";
        Cursor cursor=db.rawQuery(query,null);
            return cursor;
    }
    public Cursor getparticulardata(String item)
    {
        SQLiteDatabase db1=this.getWritableDatabase();
        Cursor cursor=db1.rawQuery("select * from fooddetails where food=?",new String[]{item});
        return cursor;
    }

}
