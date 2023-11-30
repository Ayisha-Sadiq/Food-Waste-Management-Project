package com.example.food;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Exampledatabase extends SQLiteOpenHelper {
    public Exampledatabase(@Nullable Context context) {
        super(context, "Userdb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table userdetails(name TEXT primary key,password Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sq, int i, int i1) {
        sq.execSQL("drop table if exists userdetails");
    }
    public Boolean insertuserdata (String name,String password)
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("password",password);
        long result=DB.insert("userdetails",null,cv);
        if(result==-1)
            return false;
        else
            return true;

    }
    public Boolean checkusernamepassword(String username,String password){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from userdetails where name=? and password=?",new String[]{username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

}
