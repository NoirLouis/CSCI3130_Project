package com.toyide.csci3130_project;

/**
 * Created by aya on 2018-02-24.
 */

public class checkPassword {
    String users= "times";
    String password = "123456";
    public boolean check(String name, String pass ){
        if (name.equals(users)){
            if (pass.equals(password)) {
                return true;
            }
        }
        return false;
    }
}
