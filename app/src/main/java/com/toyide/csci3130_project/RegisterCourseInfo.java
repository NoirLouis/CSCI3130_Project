//package com.toyide.csci3130_project;

//import android.app.Activity;
//import android.app.Fragment;
//import android.content.Context;
//import android.graphics.Color;
//import android.util.Log;
//import android.view.Gravity;
//import android.view.View;
//import android.widget.CheckBox;
//import android.widget.TableLayout;
//import android.widget.TableRow;
//import android.widget.TextView;
//import android.widget.EditText;
//import android.content.Intent;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by JingyunYang on 2018/2/21.
 * A class display the course information with a check box to register
 */

/*
public class RegisterCourseInfo  {
    Context context;
    Activity activity;
    RegisterFragment fragment;
    View view;
    Course receivedPersonInfo;
    private MyApplicationData appState;
    // Constructor
    public RegisterCourseInfo(Context context, RegisterFragment fragment,View view){
        this.context=context;
        this.fragment=fragment;
        this.view=view;
        Log.i("view", fragment.getClass().toString());
        Log.i("class", context.getClass().toString());
    }

    public void init() {
        // Create the column name: CourseName, CourseID, Time and Location respectively
        Log.i("view", view.toString());
        Log.i("class", context.getClass().toString());
        System.out.print(context.getClass());
        //TableLayout stk = (TableLayout)view.findViewById(R.id.registerCourseInfo); //(TableLayout) findViewById(R.id.courseTable);
        Log.i("view", stk.toString());
        TableRow tbrow0 = new TableRow(context);
        TextView courseNameView = new TextView(context);
        courseNameView.setText(" Course Name ");
        courseNameView.setTextColor(Color.WHITE);
        tbrow0.addView(courseNameView);
        TextView courseIDView = new TextView(context);
        courseIDView.setText(" Course ID ");
        courseIDView.setTextColor(Color.WHITE);
        tbrow0.addView(courseIDView);
        TextView courseTimeView = new TextView(context);
        courseTimeView.setText(" Time ");
        courseTimeView.setTextColor(Color.WHITE);
        tbrow0.addView(courseTimeView);
        TextView spotView = new TextView(context);
        spotView.setText(" Enrolled/Toatl ");
        spotView.setTextColor(Color.WHITE);
        tbrow0.addView(spotView);
        //stk.addView(tbrow0);
        // TODO: Use a proper data structue to pass the course related information
        // TODO: Add listener to the checkbox
        // TODO: Connect to the database
        // TODO: Adopt a better UI
        for (int i = 0; i < 20; i++) {
            TableRow tbrow = new TableRow(context);
            TextView courseNameView1 = new TextView(context);
            TextView courseIDView1 = new TextView(context);

            courseNameView1.setText("CSCI" + i);
            courseNameView1.setTextColor(Color.WHITE);
            courseNameView1.setGravity(Gravity.CENTER);
            tbrow.addView(courseNameView1);
            courseIDView1.setText("Course " + i);
            courseIDView1.setTextColor(Color.WHITE);
            courseIDView1.setGravity(Gravity.CENTER);
            tbrow.addView(courseIDView1);

            TextView courseTimeView1 = new TextView(context);
            courseTimeView1.setText("Monday " + (8+i%8 ) + ":00" );
            courseTimeView1.setTextColor(Color.WHITE);
            courseTimeView1.setGravity(Gravity.CENTER);
            tbrow.addView(courseTimeView1);

            TextView spotView1 = new TextView(context);
            spotView1.setText( i + "/50");
            spotView1.setTextColor(Color.WHITE);
            spotView1.setGravity(Gravity.CENTER);
            tbrow.addView(spotView1);
            CheckBox cb = new CheckBox(context);      // create new checkBox
            tbrow.addView(cb);                          // add checkBox
           // stk.addView(tbrow);
        }
    }
    void getInstanceData(TextView courseNameView, TextView courseIDView, TextView courseTimeView, TextView spotView, DatabaseReference mDatabase){
        mDatabase = FirebaseDatabase.getInstance().getReference();
        String cid = mDatabase.child("Course").getKey();

    }

}*/