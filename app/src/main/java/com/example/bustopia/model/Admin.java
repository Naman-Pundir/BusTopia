package com.example.bustopia.model;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bustopia.MainActivity;


public class Admin{

    private String AdminID = "Admin";
    private String AdminPassword = "Admin123";

    public String getAdminID() {
        return AdminID;
    }

    public String getAdminPassword() {
        return AdminPassword;
    }

    public void setAdminID(String adminID) {
        AdminID = adminID;
    }

    public void setAdminPassword(String adminPassword) {
        AdminPassword = adminPassword;
    }


}
