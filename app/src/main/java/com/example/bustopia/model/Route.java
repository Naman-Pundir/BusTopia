package com.example.bustopia.model;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.bustopia.R;
import com.example.bustopia.data.BusRoute;

import java.util.Arrays;

public class Route extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);
        Bundle b = this.getIntent().getExtras();
        String busName = b.getString("busName");
        BusRoute br = new BusRoute();
        //       Log.i("bus_info welcomes you",bl.busName);
        Log.i("Here", busName);
        ListView l = findViewById(R.id.busRouteAdmin);
        String[] routeArr =  Arrays.copyOf(br.returnRoute(busName),br.returnRoute(busName).length );
        ArrayAdapter<String> arr = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, routeArr);
        l.setAdapter(arr);
    }
}