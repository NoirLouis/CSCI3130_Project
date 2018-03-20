package com.toyide.csci3130_project;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by JingyunYang on 2018/2/21.
 * A class display the course information with a check box to register
 */


public class RegisterCourseInfo  {
    Context context;
    Activity activity;
    RegisterFragment fragment;
    View view;
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
        TableLayout stk = (TableLayout)view.findViewById(R.id.registerCourseInfo); //(TableLayout) findViewById(R.id.courseTable);
        Log.i("view", stk.toString());
        TableRow tbrow0 = new TableRow(context);
        TextView tv0 = new TextView(context);
        tv0.setText(" Course Name ");
        tv0.setTextColor(Color.WHITE);
        tbrow0.addView(tv0);
        TextView tv1 = new TextView(context);
        tv1.setText(" Course ID ");
        tv1.setTextColor(Color.WHITE);
        tbrow0.addView(tv1);
        TextView tv2 = new TextView(context);
        tv2.setText(" Time ");
        tv2.setTextColor(Color.WHITE);
        tbrow0.addView(tv2);
        TextView tv3 = new TextView(context);
        tv3.setText(" Enrolled/Toatl ");
        tv3.setTextColor(Color.WHITE);
        tbrow0.addView(tv3);
        stk.addView(tbrow0);
        // TODO: Use a proper data structue to pass the course related information
        // TODO: Add listener to the checkbox
        // TODO: Connect to the database
        // TODO: Adopt a better UI
        for (int i = 0; i < 20; i++) {
            TableRow tbrow = new TableRow(context);
            TextView t1v = new TextView(context);
            TextView t2v = new TextView(context);

            t1v.setText("CSCI" + i);
            t1v.setTextColor(Color.WHITE);
            t1v.setGravity(Gravity.CENTER);
            tbrow.addView(t1v);
            t2v.setText("Course " + i);
            t2v.setTextColor(Color.WHITE);
            t2v.setGravity(Gravity.CENTER);
            tbrow.addView(t2v);
            TextView t3v = new TextView(context);
            t3v.setText("Monday " + (8+i%8 ) + ":00" );
            t3v.setTextColor(Color.WHITE);
            t3v.setGravity(Gravity.CENTER);
            tbrow.addView(t3v);
            TextView t4v = new TextView(context);
            t4v.setText( i + "/50");
            t4v.setTextColor(Color.WHITE);
            t4v.setGravity(Gravity.CENTER);
            tbrow.addView(t4v);
            CheckBox cb = new CheckBox(context);      // create new checkBox
            tbrow.addView(cb);                          // add checkBox
            stk.addView(tbrow);
        }

    }
}