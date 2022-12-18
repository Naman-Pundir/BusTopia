package com.example.bustopia.model;


import com.example.bustopia.MainActivity;
import com.example.bustopia.data.MyDbHandler;

import java.util.List;

public class LoginValidity extends MainActivity {
    public boolean loginValidate(String loginID, String password, String givenID, String givenPassword){
        if(loginID.compareTo(givenID) == 0 && password.compareTo(givenPassword) == 0){
            return true;
        }

        else{
            return false;
        }
    }
}
