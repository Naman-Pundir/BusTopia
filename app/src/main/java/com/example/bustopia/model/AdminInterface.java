package com.example.bustopia.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bustopia.R;

public class AdminInterface extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_interface);

        Button getUserInfo = findViewById(R.id.getUserData);
        Button getRouteInfo = findViewById(R.id.getBusRouteData);
        Button deleteUser = findViewById(R.id.deleteUser);

        getRouteInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminInterface.this, GetRouteInfo.class);
                startActivity(i);
            }
        });

        getUserInfo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(AdminInterface.this, com.example.bustopia.model.getUserInfo.class);
                startActivity(i);
            }
        });

        deleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminInterface.this, DeleteUser.class);
                startActivity(i);
            }
        });
    }
}