package com.toyide.csci3130_project;

/**
 * Created by SHAN on 18/2/21.
 */

public class Course {
    private String courseTitle;     //Eg. CSCI3130
    private String courseType;      //Eg. lecture, lab or tutorial
    private String courseWeekday;   //Eg. Monday, Tuesday
    private String courseTime;      //Eg. 13:20
    private String courseInfo;      //course information Eg. Software Engineering

    //constructor
    public Course(String courseTitle, String courseType, String courseWeekday, String courseTime, String courseInfo) {
        this.courseTitle = courseTitle;
        this.courseType = courseType;
        this.courseWeekday = courseWeekday;
        this.courseTime = courseTime;
        this.courseInfo = courseInfo;
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
}

