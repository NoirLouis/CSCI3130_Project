package com.toyide.csci3130_project;
import com.google.firebase.database.Exclude;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;

/**
 * Profile Class that defines how the data will be stored in our
 * project Firebase databse. This is converted to a JSON format
 */
//Refactoring - using Profile to get profile object and removing meaningless variable
public class Profile implements Serializable {

    public String UserID;
    public String UserName;
    public String Password;
    public String Department;
    public String UserDegree;
    public Profile() {

    }

    public  Profile(String uid, String username, String password, String department, String degree){
        this.UserID = uid;
        this.UserName = username;
        this.Password = password;
        this.Department = department;
        this.UserDegree = degree;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("UserID", UserID);
        result.put("UserName", UserName);
        result.put("Password", Password);
        result.put("Department", Department);
        result.put("UserDegree", UserDegree);
        return result;
    }

}