package com.toyide.csci3130_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHAN on 18/2/21.
 */

public class CourseListAdapter extends ArrayAdapter<Course> {

    //constructor
    public CourseListAdapter(Context context, int resource, ArrayList<Course> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //get data for the position
        Course course = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.course_cotent, parent,false);
        }

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
        TextView tvType = (TextView) convertView.findViewById(R.id.tv_type);
        TextView tvWeekday = (TextView) convertView.findViewById(R.id.tv_weekday);
        TextView tvTime = (TextView) convertView.findViewById(R.id.tv_time);
        TextView tvInfo = (TextView) convertView.findViewById(R.id.tv_info);

        //set text for TextView
        tvTitle.setText(course.getCourseTitle());
        tvType.setText(course.getCourseType());
        tvWeekday.setText(course.getCourseWeekday());
        tvTime.setText(course.getCourseTime());
        tvInfo.setText(course.getCourseInfo());

        return convertView;
    }
}
