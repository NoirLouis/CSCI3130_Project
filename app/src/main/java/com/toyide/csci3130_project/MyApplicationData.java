package com.toyide.csci3130_project;

/**
 * Created by aya on 2018-03-14.
 */

import android.app.Application;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MyApplicationData extends Application {

    public DatabaseReference firebaseReference;
    public FirebaseDatabase firebaseDBInstance;

}