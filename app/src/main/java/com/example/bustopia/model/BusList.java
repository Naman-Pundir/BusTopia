package com.example.bustopia.model;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.bustopia.MainActivity;
import com.example.bustopia.R;
import com.example.bustopia.data.BusData;
import com.example.bustopia.model.BusSearch;

import java.util.Arrays;

public class BusList extends AppCompatActivity {
    private String busName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_list);
        ListView l = findViewById(R.id.busList);
        BusSearch bs = new BusSearch();
        String listitem[] = Arrays.copyOf(bs.getBuses(), bs.getBuses().length);
        Log.d("Hello", listitem[0]);
        ArrayAdapter<String> arr = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listitem);
        l.setAdapter(arr);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("menu items", "You clicked item " + i + " at position " + l);
                busName = listitem[i];
                Log.d("busname : ", busName);

                Intent intent = new Intent(BusList.this, bus_info.class);
                intent.putExtra("busName", busName);
                startActivity(intent);
            }
        });
    }
}