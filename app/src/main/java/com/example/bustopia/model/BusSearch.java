package com.example.bustopia.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.bustopia.R;
import com.example.bustopia.data.BusData;

import java.util.ArrayList;
import java.util.Arrays;

public class BusSearch extends AppCompatActivity {

    private static String location1;
    private static String destination1;

    private static final String[] cities = new String[]{"Delhi", "Kanpur", "Kolkata", "Kota", "Panipat", "Patna", "Prayagraj", "Mumbai", "Varanasi", "Vellore"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_search);

        AutoCompleteTextView location = (AutoCompleteTextView) findViewById(R.id.location);
        AutoCompleteTextView destination = (AutoCompleteTextView) findViewById(R.id.destination);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cities );
        location.setAdapter(adapter);
        destination.setAdapter(adapter);
        Button findBuses = findViewById(R.id.findBusButton);

        findBuses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                location1 = location.getText().toString();
                destination1 = destination.getText().toString();
                String arr[] = Arrays.copyOf(getBuses(), getBuses().length);
                if(arr[0] == "null"){
                    Toast.makeText(getApplicationContext(), "No bus found", Toast.LENGTH_SHORT).show();}
                else {
                    Intent i = new Intent(BusSearch.this, BusList.class);
                    startActivity(i);
                }
            }
        });
    }

    public static String[] getBuses(){
        BusData bd = new BusData();
        String[] temp = new String[10];
        temp = Arrays.copyOf(bd.returnDash(location1, destination1), bd.returnDash(location1,destination1).length);
        Log.d("Hello1", temp[0]);
        Log.d("Hello2", bd.returnDash(location1, destination1)[0]);
        return temp;
    }
}