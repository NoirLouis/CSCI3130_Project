package com.toyide.csci3130_project;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public  void check_profile_map() throws Exception {
        Profile profile = new Profile("B00123456", "names","123456789", "Computer Science", "Undergraduate");
        Map<String, Object>  check2 =profile.toMap();
        assertEquals("B00123456", check2.get("UserID") );
        assertEquals("names", check2.get("UserName"));
        assertEquals("123456789",check2.get("Password"));
        assertEquals("Computer Science", check2.get("Department"));
        assertEquals("Undergraduate", check2.get("UserDegree"));

    }
    @Test
    public void check_course() throws Exception{
        Course course = new Course("CSCI 1100","Lec","MTF","10:00-12:00","Java 2", "");
        assertEquals("CSCI 1100", course.CourseTitle);
        assertEquals("Lec",course.CourseType);
        assertEquals("MTF",course.CourseWeekday);
        assertEquals("10:00-12:00",course.CourseTime);
        assertEquals("Java 2", course.CourseInfo);
    }
    @Test
    public void check_registration() throws Exception{
        Registration registration = new Registration("B00123456", "12345,23456,");
        Map<String,Object> checks = registration.toMap();
        assertEquals("B00123456",checks.get("UserID"));
        assertEquals("12345,23456,",checks.get("CourseID"));
    }

}