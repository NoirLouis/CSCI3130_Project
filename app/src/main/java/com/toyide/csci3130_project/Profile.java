package com.toyide.csci3130_project;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by aya on 2018-03-14.
 */
/**
 * Profile Class that defines how the data will be stored in our
 * project Firebase databse. This is converted to a JSON format
 */
public class Profile implements Serializable {

    public String UserID;
    public String UserName;
    public String Password;
    public String Department;
    public String UserDegree;
    //public ArrayList<String> couseid;
    public Profile() {

    }

    public  Profile(String uid, String username, String password, String department, String degree){
        this.UserID = uid;
        this.UserName = username;
        this.Password = password;
        this.Department = department;
        this.UserDegree = degree;
    }
    /*
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
*/

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