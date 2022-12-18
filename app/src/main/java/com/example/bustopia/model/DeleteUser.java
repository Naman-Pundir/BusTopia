package com.example.bustopia.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bustopia.R;
import com.example.bustopia.data.MyDbHandler;

import java.util.List;

public class DeleteUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_user);
        EditText Id = findViewById(R.id.deleteUID);
        EditText Uname = findViewById(R.id.deleteUserName);
        EditText Uage = findViewById(R.id.deleteAge);
        EditText Ugender = findViewById(R.id.deleteGender);
        Button del = findViewById(R.id.DeleteThisUser);
        MyDbHandler db = new MyDbHandler(this);
        List<User> allContacts = db.getAllContacts();

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String GivenID = Id.getText().toString();
                int error = 0;
                if(GivenID.equals("")){
                    String GivenUname = Uname.getText().toString();
                    String GivenUage = Uage.getText().toString();
                    String GivenUgender = Ugender.getText().toString();
                    for(User contact: allContacts){
                        if(contact.getUsername().equals(GivenUname) && contact.getAge().equals(GivenUage) && contact.getGender().equals(GivenUgender)){
                            db.deleteContact(contact);
                        }else{
                            error++;
                        }
                    }
                    if(error == allContacts.size()){
                        Toast.makeText(getApplicationContext(), "No such user exist", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(), "User Deleted", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(DeleteUser.this, AdminInterface.class);
                        startActivity(i);
                    }
                }else{
                    for(User contacts: allContacts){
                        if(Integer.toString(contacts.getId()).equals(GivenID)){
                            db.deleteContact(contacts);
                        }else{
                            error++;
                        }
                    }
                    if(error == allContacts.size()){
                        Toast.makeText(getApplicationContext(), "No such user exist", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(), "User Deleted", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(DeleteUser.this, AdminInterface.class);
                        startActivity(i);
                    }
                }
            }
        });
    }
}