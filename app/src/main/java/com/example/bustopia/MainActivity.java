package com.example.bustopia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bustopia.data.MyDbHandler;
import com.example.bustopia.model.Admin;
import com.example.bustopia.model.AdminInterface;
import com.example.bustopia.model.BusSearch;
import com.example.bustopia.model.LoginValidity;
import com.example.bustopia.model.Registration;
import com.example.bustopia.model.User;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //to send all data to LoginValidity class
    List<User> allContacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        MyDbHandler db = new MyDbHandler(MainActivity.this);
        allContacts = db.getAllContacts();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText login = findViewById(R.id.loginID);
        EditText password = findViewById(R.id.loginPassword);
        Button loginBtn = findViewById(R.id.loginButton);
        Button registerBtn = findViewById(R.id.registerButton);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loginID = login.getText().toString();
                String loginPassword = password.getText().toString();
                LoginValidity lv = new LoginValidity();
                int error = 0;
                for(User contact: allContacts) {

                    if (lv.loginValidate(loginID, loginPassword,contact.getUsername(),contact.getPassword())) {
                        Intent i = new Intent(MainActivity.this, BusSearch.class);
                        startActivity(i);
                    } else {
                        error++;
                    }
                }
                if(error == allContacts.size()){
                    Admin ad = new Admin();
                    Log.i("Hello", ad.getAdminID() + ad.getAdminPassword());
                    if(loginID.compareTo(ad.getAdminID()) == 0 && loginPassword.compareTo(ad.getAdminPassword()) == 0){
                        Intent i = new Intent(MainActivity.this, AdminInterface.class);
                        startActivity(i);
                    }
                    else{
                    Toast.makeText(getApplicationContext(), R.string.warning, Toast.LENGTH_SHORT).show();}
                }
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Registration.class);
                startActivity(i);
            }
        });
    }

}