package com.toyide.csci3130_project;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by aya on 2018-03-21.
 */

public class getData {
    public static ArrayList<Course> courses_list = new ArrayList<Course>();
    public static void setCourses_list(Course newone){
        courses_list.add(newone);
    }

}
