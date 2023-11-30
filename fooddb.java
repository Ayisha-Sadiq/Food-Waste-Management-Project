package com.example.food;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import androidx.annotation.Nullable;

    public class fooddb extends SQLiteOpenHelper {
        public fooddb(@Nullable Context context) {
            super(context, "fooddb", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table userdetails(email TEXT primary key,password TEXT)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sq, int i, int i1) {
            sq.execSQL("drop table if exists userdetails");
        }
        public Boolean insertuserdata (String mail,String pass)
        {
            SQLiteDatabase DB=this.getWritableDatabase();
            ContentValues cv=new ContentValues();
            cv.put("email",mail);
            cv.put("password",pass);
            long result=DB.insert("userdetails",null,cv);
            if(result==-1)
                return false;
            else
                return true;

        }
public boolean checkusernamepassword(String username,String password)
{
    SQLiteDatabase db=this.getWritableDatabase();
    String query="select * from userdetails where mail=username and pass=password";
    Cursor cursor=db.rawQuery(query,null);
    if(cursor.getCount()>0)
        return true;
    else
        return false;

}

    }

