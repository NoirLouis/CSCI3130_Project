package com.toyide.csci3130_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by JingyunYang on 2018/3/17.
 */

public class RegistrationAdapter extends ArrayAdapter<Course> {

    //constructor
    public RegistrationAdapter(Context context, int resource, ArrayList<Course> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //get data for the position
        Course course = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.registration_content, parent, false);
        }

        TextView courseTitleView = (TextView) convertView.findViewById(R.id.courseName);
        TextView courseInfoView = (TextView) convertView.findViewById(R.id.courseInfo);
        TextView courseTime = (TextView) convertView.findViewById(R.id.courseTime);
        TextView courseSpot = (TextView) convertView.findViewById(R.id.courseSpot);
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);

        //set text for TextView
        courseTitleView.setText(course.CourseTitle);
     // courseInfoView.setText(course.CourseInfo);
        courseTime.setText(course.CourseWeekday + course.CourseTime);
        courseSpot.setText(course.SpotCurrent + "/" + course.SpotMax);


        return convertView;
    }
}