package com.example.bustopia.model;

public class User {
    private String username;
    private int id;
    private String password;
    private String age;
    private String gender;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public void setId(int inputID) {
        this.id = inputID;
    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}
