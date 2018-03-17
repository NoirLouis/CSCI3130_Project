package com.toyide.csci3130_project;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
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
        public ArrayList<String> cid;               //a list containing coruse reference IDs

        //constructor
        public  Registration(String rid, String uid, ArrayList<String> cid){
            this.rid = rid;
            this.uid = uid;
            this.cid.addAll(cid);
        }

        @Exclude
        public Map<String, Object> toMap(){
            HashMap<String, Object> result = new HashMap<>();

            result.put("rid", rid);
            result.put("uid", uid);
            String cidList = "";
            for(String var:cid){
                cidList += var;
                cidList += ",";
            }
            result.put("cid", cidList);


            return result;
        }
    public String getUid() {
        return uid;
    }

    public String getRid() {
        return rid;
    }

    public ArrayList<String> getCid() {
        return cid;
    }

}


