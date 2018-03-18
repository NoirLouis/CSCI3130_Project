package com.toyide.csci3130_project;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aya on 2018-03-17.
 */

public class login implements Serializable {
    public String userID;
    public String password;

    public login() {

    }

    public login( String userID, String password) {
        this.userID = userID;
        this.password = password;
    }
    public String getUserID(){
        return this.userID;
    }
    public String getPassword(){
        return  this.password;
    }
    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("userID", userID);
        result.put("password", password);
        return result;
    }
}