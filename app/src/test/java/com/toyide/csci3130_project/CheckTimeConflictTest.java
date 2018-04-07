package com.toyide.csci3130_project;

import com.toyide.csci3130_project.CheckTimeConflict;

import org.junit.BeforeClass;
import org.junit.Test;

import java.text.ParseException;

import static junit.framework.Assert.assertEquals;

public class CheckTimeConflictTest {
    private static String time1 = "11:30-13:00";;
    private static String time2 = "11:30-15:00";
    private static String time3 = "12:30-13:00";
    private static String time4 = "09:00-11:00";

    private static String day1 = "TR";
    private static String day2 = "MR";
    private static String day3 = "TF";
    private static String day4 = "MF";

    CheckTimeConflict checkTimeConflict = new CheckTimeConflict();

    @BeforeClass
    public static void init()
    {
        assertEquals(time1.length(),11);
        assertEquals(time2.length(),11);
        assertEquals(time3.length(),11);
        assertEquals(time4.length(),11);
        assertEquals(time1.charAt(5),'-');
        assertEquals(time2.charAt(5),'-');
        assertEquals(time3.charAt(5),'-');
        assertEquals(time4.charAt(5),'-');


    }
    //FIXME： fix JUnit test under exception

    @Test
    public void check1()
    {
        assertEquals(checkTimeConflict.confliCtcheck(time1,time2),true);
    }

    @Test
    public void check2()
    {
        assertEquals(checkTimeConflict.confliCtcheck(time2,time1),true);
    }

    @Test
    public void check3()
    {
        assertEquals(checkTimeConflict.confliCtcheck(time2,time4),false);
    }
    @Test
    public void check4()
    {
        assertEquals(checkTimeConflict.confliCtcheck(time3,time1),true);
    }
    @Test
    public void check5()
    {
        assertEquals(checkTimeConflict.confliCtcheck(time3,time4),false);
    }
    @Test
    public void check6()
    {
        assertEquals(checkTimeConflict.sameChars(day1,day2),true);//is intersaction
    }
    @Test
    public void check7()
    {
        assertEquals(checkTimeConflict.sameChars(day3,day2),false);//no intersections
    }
    @Test
    public void check8()
    {
        assertEquals(checkTimeConflict.sameChars(day3,day4),true);
    }
    @Test
    public void check9()
    {
        assertEquals(checkTimeConflict.sameChars(day4,day2),true);
    }
    @Test
    public void check10()
    {
        assertEquals(checkTimeConflict.sameChars(day1,day4),false);
    }


}
