package com.toyide.csci3130_project;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    checkPassword check = new checkPassword();
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    public  void checkLoginfalse() throws Exception {

        assertEquals(false,check.check("zh370900","1234qwer"));

    }
    public void checkLogintrue() throws  Exception {
        assertEquals(true, check.check("times", "123456"));
    }
}