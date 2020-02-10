package com.example.multipledemo;

import java.io.Serializable;

public class UserModel implements Serializable {

    //declare the variable
    private String mName, mHobby, mCity;
    private int id;

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        this.mCity = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getHobby() {
        return mHobby;
    }

    public void setHobby(String hobby) {
        this.mHobby = hobby;
    }
}
