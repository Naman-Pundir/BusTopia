package com.example.bustopia.data;

public class BusData {

    // Intialize the arraylist
    private static String [][] busesList = {
            {"null", "null", "B4", "B5", "B1", "null", "B10", "null", "B6", "null"},
            {"B4#B6", "null", "null", "null", "null", "null", "null", "null", "null", "B2"},
            {"null", "null", "null", "null", "B8#B9", "null", "null", "B3#B7", "B5", "B4"},
            {"B10", "B6#B8", "B5", "null", "B2", "null", "B7", "null", "null", "null"},
            {"B1#B9", "null", "B6#B7", "B8", "null", "null", "null", "null", "B3", "null"},
            {"null", "B4", "null", "null", "null", "null", "B1", "B10", "null", "B8"},
            {"B5", "null", "null", "null", "null", "B7", "null", "B1", "null", "B9"},
            {"null", "null", "null", "B2#B7#B10", "B3", "B8", "null", "null", "null", "null"},
            {"null", "null", "null", "B3", "B6", "null", "B9", "null", "null", "null"},
            {"null", "null", "B8#B9", "null", "null", "B10", "null", "null", "null", "null"}
    };

    public static String returnVal(String a, String b){
        int i=-1,j=-1;
        if(a.equals("Delhi")){
            i = 0;
        }
        if(a.equals("Kanpur")){
            i = 1;
        }
        if(a.equals("Kolkata")){
            i = 2;
        }
        if(a.equals("Kota")){
            i = 3;
        }
        if(a.equals("Panipat")){
            i = 4;
        }
        if(a.equals("Patna")){
            i = 5;
        }
        if(a.equals("Prayagraj")){
            i = 6;
        }if(a.equals("Mumbai")){
            i = 7;
        }
        if(a.equals("Varanasi")){
            i = 8;
        }
        if(a.equals("Vellore")){
            i = 9;
        }

        if(b.equals("Delhi")){
            j = 0;
        }
        if(b.equals("Kanpur")){
            j = 1;
        }
        if(b.equals("Kolkata")){
            j = 2;
        }
        if(b.equals("Kota")){
            j = 3;
        }
        if(b.equals("Panipat")){
            j = 4;
        }
        if(b.equals("Patna")){
            j = 5;
        }
        if(b.equals("Prayagraj")){
            j = 6;
        }if(b.equals("Mumbai")){
            j = 7;
        }
        if(b.equals("Varanasi")){
            j = 8;
        }
        if(b.equals("Vellore")){
            j = 9;
        }
        if(i==-1 || j==-1){
            return "Problem occured in BusList";
        }

        return busesList[i][j];
    }

    public static String[] returnDash(String a, String b){
        String str = returnVal(a,b);
        String[] arrOfStr = str.split("#", 15);

        return arrOfStr;

    }
}
//public class BusList {
//    static List create2DArrayList()
//    {
//
//        // Creating a 2D ArrayList of Integer type
//        ArrayList<ArrayList<String> > buses
//                = new ArrayList<ArrayList<String> >();
//
//        // One space allocated for R0
////        x.add(new ArrayList<String>());
////
////        // Adding 3 to R0 created above x(R0, C0)
////        x.get("Delhi").add(0, 3);
//
//        // Creating R1 and adding values
//        // Note: Another way for adding values in 2D
//        // collections
//        buses.add(
//                new ArrayList<String>(Arrays.asList("null" + "null" + "B4" + "B5" + "B1" + "null" + "B10" + "null" + "B6" + "null")));
//
//        buses.add(
//                new ArrayList<String>(Arrays.asList("B4#B6" + "null" + "null" + "null" + "null" + "null" + "null" + "null" + "null" + "B2")));
//
//        buses.add(
//                new ArrayList<String>(Arrays.asList("null" + "null" + "null" + "null" + "B8#B9" + "null" + "null" + "B3#B7" + "B5" + "B4")));
//
//        buses.add(
//                new ArrayList<String>(Arrays.asList("B10" + "B6#B8" + "B5" + "null" + "B2" + "null" + "B7" + "null" + "null" + "null")));
//
//        buses.add(
//                new ArrayList<String>(Arrays.asList("B1#B9" + "null" + "B6#B7" + "B8" + "null" + "null" + "null" + "null" + "B3" + "null")));
//
//        buses.add(
//                new ArrayList<String>(Arrays.asList("null" + "B4" + "null" + "null" + "null" + "null" + "B1" + "B10" + "null" + "B8")));
//
//        buses.add(
//                new ArrayList<String>(Arrays.asList("B5" + "null" + "null" + "null" + "null" + "B7" + "null" + "B1" + "null" + "B9")));
//
//        buses.add(
//                new ArrayList<String>(Arrays.asList("null" + "null" + "null" + "B2#B7#B10" + "B3" + "B8" + "null" + "null" + "null" + "null")));
//
//        buses.add(
//                new ArrayList<String>(Arrays.asList("null" + "null" + "null" + "B3" + "B6" + "null" + "B9" + "null" + "null" + "null")));
//
//        buses.add(
//                new ArrayList<String>(Arrays.asList("null" + "null" + "B8#B9" + "null" + "null" + "B10" + "null" + "null" + "null" + "null")));
//        // This method will return 2D array
//        return buses;
//    }
//
//    // Method 2
//    // Main driver method
//    public static void main(String args[])
//    {
//        // Display message prior for better readability
//        System.out.println("2D ArrayList :");
//
//        // Printing 2D ArrayList by calling Method 1
//        System.out.println(create2DArrayList());
//    }
//}
