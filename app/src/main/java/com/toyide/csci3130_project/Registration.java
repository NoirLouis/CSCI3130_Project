package com.toyide.csci3130_project;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JingyunYang on 2018/3/16.
 */
/**
 * Registration Class that defines how we access the user ID and the corresponding course ID they slected
 * project Firebase databse. This is converted to a JSON format
 */
public class Registration implements Serializable {
    public String rid;                          //registeration ID,
    public String uid;                          //user ID
    public String cidList="";                   //a list containing coruse reference IDs
    //constructor

    public  Registration(String rid, String uid){
        this.rid = rid;
        this.uid = uid;

    }
    //remove empty at first
    public void add_withFirst(String add) {
        cidList += add;
        cidList += ",";
    }



    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();

        result.put("rid", rid);
        result.put("uid", uid);

        result.put("cid", cidList);


        return result;
    }


    // Return a list of courses in the form of array
    public String[] getCourses() {
        return cidList.split(",");
        //NOTICE: the last string element is "".
    }
}


