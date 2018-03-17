package com.toyide.csci3130_project;

/**
 * Created by JingyunYang, YideGe on 18/3/17.
 */

public class Course {
    private String courseTitle;     //Eg. CSCI3130
    private String courseType;      //Eg. lecture, lab or tutorial
    private String courseWeekday;   //Eg. Monday, Tuesday
    private String courseTime;      //Eg. 13:20
    private String courseInfo;      //course information Eg. Software Engineering

    private int spotCurrent;        //number of current enrolled in the course
    private int spotMax;            //maximum number of students enrolled

    //constructor
    public Course(String courseTitle, String courseType, String courseWeekday, String courseTime, String courseInfo) {
        this.courseTitle = courseTitle;
        this.courseType = courseType;
        this.courseWeekday = courseWeekday;
        this.courseTime = courseTime;
        this.courseInfo = courseInfo;
    }

    //constructor for registration
    public Course(String courseTitle, String courseType, String courseWeekday, String courseTime, String courseInfo, int spotCurrent, int spotMax ) {
        this.courseTitle = courseTitle;
        this.courseType = courseType;
        this.courseWeekday = courseWeekday;
        this.courseTime = courseTime;
        this.courseInfo = courseInfo;

        this.spotCurrent = spotCurrent;
        this.spotMax = spotMax;

    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getCourseType() {
        return courseType;
    }

    public String getCourseWeekday() {
        return courseWeekday;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public String getCourseInfo() {
        return courseInfo;
    }

    public int getSpotCurrent() {return spotCurrent;}

    public int getSpotMax() {return  spotMax;}

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public void setCourseWeekday(String courseWeekday) {
        this.courseWeekday = courseWeekday;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public void setCourseInfo(String courseInfo) {
        this.courseInfo = courseInfo;
    }

    public void setSpotCurrent(int spotCurrent) {this.spotCurrent = spotCurrent;}

    public void setSpotMax(int spotMax) {this.spotMax = spotMax;}
}

