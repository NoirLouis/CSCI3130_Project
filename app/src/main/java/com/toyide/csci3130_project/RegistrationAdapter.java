package com.toyide.csci3130_project;

import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
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

public class RegistrationAdapter extends ArrayAdapter<Courses> {

    private static final String TAG ="test" ;

    //constructor
    public RegistrationAdapter(Context context, int resource, ArrayList<Courses> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //get data for the position
        Courses course = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.registration_content, parent, false);
        }

        TextView courseTitleView = (TextView) convertView.findViewById(R.id.courseTitle);
        final TextView civ = (TextView) convertView.findViewById(R.id.courseInfo);
        TextView courseTime = (TextView) convertView.findViewById(R.id.courseTime);
        TextView courseSpot = (TextView) convertView.findViewById(R.id.courseSpot);
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);
        Log.i(TAG, "MyClass.getView()  " + course.CourseInfo+" secod");
        //set text for TextView
        courseTitleView.setText(" "+course.CourseTitle.substring(0,3)+ "\n"+course.CourseTitle.substring(4));
        civ.setText(" "+course.CourseInfo);
        //civ.setSingleLine(true);
        civ.setMovementMethod(ScrollingMovementMethod.getInstance());
        //Collapse if not long enough to display
        civ.setOnClickListener(new View.OnClickListener() {
            Boolean flag = true;
            @Override
            public void onClick(View v) {
                Log.i("civ.getLineCount()",civ.getLineCount()+"");
                if(flag){
                    flag = false;
                    civ.setEllipsize(null);

                }

            }
        });

        courseTime.setText(" "+course.CourseWeekday + "\n"+ course.CourseTime);
        courseSpot.setText(" "+course.SpotCurrent + "/" + course.SpotMax);



        return convertView;
    }
}