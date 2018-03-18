package com.toyide.csci3130_project;

import android.app.Application;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
/**
 * Created by aya on 2018-03-09.
 */


public class DataConnection {


    public class MyApplicationData extends Application {

        public DatabaseReference firebaseReference;
        public FirebaseDatabase firebaseDBInstance;

    }
}
