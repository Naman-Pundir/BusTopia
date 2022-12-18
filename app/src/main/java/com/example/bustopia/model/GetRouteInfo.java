package com.example.bustopia.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.bustopia.R;
import com.example.bustopia.data.BusRoute;

import java.util.Arrays;
import java.util.List;

public class GetRouteInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_route_info);

        ListView l1 = findViewById(R.id.busListAdmin);
        String arr[] = {"B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "B10"};
        ArrayAdapter<String> a = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arr);
        l1.setAdapter(a);
        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("menu items", "You clicked item " + i + " at position " + l);
                String busName = arr[i];
                Log.d("busname : ", busName);

                Intent intent = new Intent(GetRouteInfo.this, Route.class);
                intent.putExtra("busName", busName);
                startActivity(intent);
            }
        });
    }
}