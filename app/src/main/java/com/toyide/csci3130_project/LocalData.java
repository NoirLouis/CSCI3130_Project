package com.toyide.csci3130_project;

/**
 * Created by YZ on 2018-03-17.
 */

public class LocalData {

    private static String UserID;


    public static void setUserID(String UserId) {
        UserID = UserId;
    }
    public static String getUserID(){
        return  UserID;
    }

}