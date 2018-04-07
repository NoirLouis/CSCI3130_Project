package com.toyide.csci3130_project;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JingyunYang, YideGe on 18/3/17.
 */

public class Courses {
    public  Long CourseID;
    public String CourseTitle;     //Eg. CSCI3130
    public String CourseType;      //Eg. lecture, lab or tutorial
    public String CourseWeekday;   //Eg. Monday, Tuesday
    public String CourseTime;      //Eg. 13:20
    public String CourseInfo;      //course information Eg. Software Engineering
    public String Location;
    public int SpotCurrent;        //number of current enrolled in the course
    public int SpotMax;            //maximum number of students enrolled

    public  Courses (){

    }

    //constructor for registration
    public Courses (String courseTitle, String courseType, String courseWeekday, String courseTime, String courseInfo, String location) {
        this.CourseTitle = courseTitle;
        this.CourseType = courseType;
        this.CourseWeekday = courseWeekday;
        this.CourseTime = courseTime;
        this.CourseInfo = courseInfo;
        this.Location = location;
    }

    //constructor for registration
    public Courses (Long CourseID, String courseTitle, String courseType, String courseWeekday, String courseTime, String courseInfo, String location, int spotCurrent, int spotMax) {
        this.CourseTitle = courseTitle;
        this.CourseType = courseType;
        this.CourseWeekday = courseWeekday;
        this.CourseTime = courseTime;
        this.CourseInfo = courseInfo;
        this.Location = location;
        this.SpotCurrent = spotCurrent;
        this.SpotMax = spotMax;
    }


    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("CourseTitle", CourseTitle);
        result.put("CourseType", CourseType);
        result.put("CourseWeekday", CourseWeekday);
        result.put("CourseTime", CourseTime);
        result.put("CourseInfo", CourseInfo);
        result.put("SpotCurrent", SpotCurrent);
        result.put("Location", Location);
        result.put("SpotMax", SpotMax);
        return result;
    }
}