package com.toyide.csci3130_project;

import com.google.firebase.database.FirebaseDatabase;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.FirebaseDatabase;
/**
 * Created by aya on 2018-02-24.
 */

public class checkPassword {
    private String users,  password;

    public boolean check(String name, String pass ){

        if (name.equals(users)){
            if (pass.equals(password)) {
                return true;
            }
        }
        return false;
    }
}
