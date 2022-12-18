package com.example.bustopia.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.bustopia.MainActivity;
import com.example.bustopia.R;
import com.example.bustopia.data.MyDbHandler;

import java.util.List;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        EditText registerID = findViewById(R.id.registerID);
        EditText password = findViewById(R.id.setPassword);
        EditText confirmPassword = findViewById(R.id.confirmPassword);
        EditText age = findViewById(R.id.age);
        RadioButton male = findViewById(R.id.male);
        RadioButton female = findViewById(R.id.female);
        RadioButton others = findViewById(R.id.others);
        Button registerButton = findViewById(R.id.registerButton2);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String registerID1 = registerID.getText().toString();
                String password1 = password.getText().toString();
                String confirmPassword1 = confirmPassword.getText().toString();
                String age1 = age.getText().toString();
                String gender1 = (male.isChecked())?"Male":(female.isChecked())?"Female":(others.isChecked())?"Others":"Male";
                if(password1.compareTo(confirmPassword1) != 0){
                    Toast.makeText(getApplicationContext(), R.string.errorMsg, Toast.LENGTH_SHORT).show();
                    return;
                }
                if(registerID1.equals("") || password.equals("") || age1.equals("") || gender1.equals("")){
                    Toast.makeText(getApplicationContext(), R.string.empty_warning, Toast.LENGTH_SHORT).show();
                }else {
                    MyDbHandler DB = new MyDbHandler(Registration.this);
                    User newUser = new User();
                    newUser.setUsername(registerID1);
                    newUser.setPassword(password1);
                    newUser.setAge(age1);
                    newUser.setGender(gender1);
                    DB.addUser(newUser);
                    Intent i = new Intent(Registration.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });
    }


}