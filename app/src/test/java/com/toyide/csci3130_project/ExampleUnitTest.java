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
        Profile profile = new Profile("B00123456", "name","12345678", "Computer Science", "undergraduate");
        Map<String, Object>  check2 =profile.toMap();
        assertEquals("B00123456", check2.get("UserID") );
        assertEquals("name", check2.get("UserName"));
        assertEquals("12345678",check2.get("Password"));
        assertEquals("Computer Science", check2.get("Department"));
        assertEquals("undergraduate", check2.get("UserDegree"));

    }
    @Test
    public  void check_course() throws  Exception{
        Course course = new Course("CSCI 1100","Lec","MTF","10:00-12:00","Java 2");
        Course course2 = new Course("CSCI 1100","Lec","MTF","10:00-12:00","Java 2", 20,50);
        assertEquals("CSCI 1100", course.getCourseTitle());
        assertEquals("Lec",course.getCourseType());
        assertEquals("MTF",course.getCourseWeekday());
        assertEquals("10:00-12:00",course.getCourseTime());
        assertEquals("Java 2", course.getCourseInfo());
        assertEquals(50,course2.getSpotMax());
        assertEquals(20,course2.getSpotCurrent());
    }
    @Test
    public  void  check_registraion() throws  Exception{
        Registration registration = new Registration("wqeiqweuiqwe","B00123456");
        registration.add_withFirst("12345");
        registration.add_withFirst("23456");
        Map<String,Object> checks = registration.toMap();
        assertEquals("wqeiqweuiqwe",checks.get("rid"));
        assertEquals("B00123456",checks.get("uid"));
        assertEquals("12345,23456,",checks.get("cid"));
    }

}