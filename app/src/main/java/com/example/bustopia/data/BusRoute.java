package com.example.bustopia.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BusRoute {

    // Intialize the arraylist
    private static String [][] busesList = {
            {"Panipat","Delhi","Patna","Pryagraj","Mumbai"},
            {"Kanpur","Vellore","Panipat","Kota","Mumbai"},
            {"Mumbai","Kolkata","Varanasi","Kota","Panipat"},
            {"Kolkata","Delhi","Kanpur","Vellore","Patna"},
            {"Delhi","Kota","Kolkata","Varanasi","Prayagraj"},
            {"Varanasi","Delhi","Kanpur","Kota","Kolkata","Panipat"},
            {"Mumbai","Kolkata","Panipat","Prayagraj","Patna","Kota"},
            {"Panipat","Kolkata","Kota","Vellore","Patna","Mumbai"},
            {"Kolkata","Panipat","Delhi","Prayagraj","Mumbai","Varanasi","Vellore"},
            {"Prayagraj","Kota","Delhi","Mumbai","Patna","Vellore"}
    };

    public static String[] returnVal(String a){
        int i=-1;
        if(a.equals("B1")){
            i = 0;
        }
        if(a.equals("B2")){
            i = 1;
        }
        if(a.equals("B3")){
            i = 2;
        }
        if(a.equals("B4")){
            i = 3;
        }
        if(a.equals("B5")){
            i = 4;
        }
        if(a.equals("B6")){
            i = 5;
        }
        if(a.equals("B7")){
            i = 6;
        }if(a.equals("B8")){
            i = 7;
        }
        if(a.equals("B9")){
            i = 8;
        }
        if(a.equals("B10")){
            i = 9;
        }

        String[] arr1 = busesList[i];

        return arr1;
    }

    public String[] returnRoute(String a){
        String str[] = returnVal(a);
        return str;

    }


}