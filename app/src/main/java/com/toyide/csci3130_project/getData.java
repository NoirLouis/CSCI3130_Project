package com.toyide.csci3130_project;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by aya on 2018-03-21.
 */

public class getData {
    public static ArrayList<Courses> courses_list = new ArrayList<Courses>();
    public static void setCourses_list(Courses newone){
        courses_list.add(newone);
    }

}
