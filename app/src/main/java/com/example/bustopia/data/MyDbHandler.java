package com.example.bustopia.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.bustopia.model.User;
import com.example.bustopia.params.Params;

import java.util.ArrayList;
import java.util.List;

public class MyDbHandler extends SQLiteOpenHelper {

//    public static final String USER_DATA_TABLE = "USER_DATA_TABLE";
//    public static final String ID = "ID";
//    public static final String USER_NAME = "USER_NAME";
//    public static final String USER_PASSWORD = "USER_PASSWORD";
//    public static final String USER_AGE = "USER_AGE";
//    public static final String USER_GENDER = "USER_GENDER";

    public MyDbHandler(@Nullable Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String create = "CREATE TABLE " + Params.USER_DATA_TABLE + " (" + Params.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Params.USER_NAME + " TEXT, " + Params.USER_PASSWORD + " TEXT, " + Params.USER_AGE + " TEXT, " + Params.USER_GENDER + " TEXT )";

        db.execSQL(create);

    }
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put(Params.USER_NAME, user.getUsername());
            values.put(Params.USER_PASSWORD, user.getPassword());
            values.put(Params.USER_AGE, user.getAge());
            values.put(Params.USER_GENDER, user.getGender());

            db.insert(Params.USER_DATA_TABLE, null, values);

            Log.d("userdatabase", "Successfully inserted");
            db.close();
        } catch (Exception e) {
            Log.d("dbdemo", "Error while trying to add post to database");
        }
    }
    public List<User> getAllContacts(){
        List<User> contactList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Generate the query to read from the database
        String select = "SELECT * FROM " + Params.USER_DATA_TABLE;
        Cursor cursor = db.rawQuery(select, null);

        //Loop through now
        if(cursor.moveToFirst()){
            do{
                User contact = new User();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setUsername(cursor.getString(1));
                contact.setPassword(cursor.getString(2));
                contact.setGender(cursor.getString(4));
                contact.setAge(cursor.getString(3));
                contactList.add(contact);
            }while(cursor.moveToNext());
        }
        return contactList;
    }

    public void deleteContact(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Params.USER_DATA_TABLE, Params.ID +"=?", new String[]{String.valueOf(user.getId())});
        db.close();
    }

//    public int updateContact(User user){
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(USER_NAME, user.getUsername());
//        values.put(USER_AGE, user.getAge());
//        values.put(USER_GENDER, user.getGender());
//
//        //Lets update now
//        return db.update(Params.TABLE_NAME, values, ID + "=?",
//                new String[]{String.valueOf(user.getId())});
//
//
//    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
