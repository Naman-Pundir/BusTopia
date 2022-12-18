package com.example.bustopia.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bustopia.R;
import com.example.bustopia.data.BusRoute;

import java.util.Arrays;

public class bus_info extends AppCompatActivity {

    ListView l;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_info);
        Bundle b = this.getIntent().getExtras();
        String busName = b.getString("busName");
        BusRoute br = new BusRoute();
 //       Log.i("bus_info welcomes you",bl.busName);
        t = findViewById(R.id.BusInfoTop);
        t.setText(busName);
        Log.i("Here", busName);
        l = findViewById(R.id.BusRouteList);
          String[] routeArr =  new String[10];
          routeArr = Arrays.copyOf(br.returnRoute(busName),br.returnRoute(busName).length );
          ArrayAdapter<String> arr = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, routeArr);
         l.setAdapter(arr);

        Button book = findViewById(R.id.bookTicket);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.abhibus.com/operator/781/GSRTC?campaignname=Gsrtc_gujarat&adgroupname=&keyword=gsrtc%20booking%20redbus&term={term}&creative=&devicemodel=&target=&device=c&network=o&matchtype=b&placement=&gclid=&msclkid=f9a3570cc60819747420347a6fb9c101&utm_source=bing&utm_medium=cpc&utm_campaign=GSRTC_Gujarat&utm_term=gsrtc%20booking%20redbus&utm_content=Gujarat%20RTC");
                Intent i = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i);
            }
        });
    }
}