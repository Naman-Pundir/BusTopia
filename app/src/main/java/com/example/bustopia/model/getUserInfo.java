package com.example.bustopia.model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.bustopia.R;
import com.example.bustopia.data.MyDbHandler;

import java.util.List;

public class getUserInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_user_info);

        MyDbHandler db = new MyDbHandler(this);
        List<User> allContacts = db.getAllContacts();

        int n = allContacts.size();
        int i = 0;
        User arr[] = new User[n];
        for(User contact : allContacts){
            arr[i] = contact;
            i++;
        }
        RecyclerView rv = findViewById(R.id.dataView);
        RecyclerViewAdapter rva = new RecyclerViewAdapter(arr);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(rva);
    }
}