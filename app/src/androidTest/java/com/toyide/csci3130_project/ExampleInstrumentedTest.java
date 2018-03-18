package com.toyide.csci3130_project;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static org.hamcrest.Matchers.anything;
import static org.junit.Assert.*;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    public ActivityTestRule<MainActivity> myActivity = new ActivityTestRule<>(MainActivity.class);
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.toyide.csci3130_project", appContext.getPackageName());
    }
    @Test
    //login
    public void check1() throws InterruptedException{

        onView(withId(R.id.input_username)).perform(typeText("B00123456"));
        closeSoftKeyboard();
        onView(withId(R.id.input_password)).perform(typeText("123456789"));
        closeSoftKeyboard();
        onView(withId(R.id.btn_login)).perform(click());
    }
    @Test
    //profile_page
    public void check2() throws InterruptedException{

        onView(withId(R.id.input_username)).perform(typeText("B00123456"));
        closeSoftKeyboard();
        onView(withId(R.id.input_password)).perform(typeText("123456789"));
        closeSoftKeyboard();
        onView(withId(R.id.btn_login)).perform(click());
        onView(withId(R.id.navigation_profile));
        onView(withId(R.id.info));
        onView(withId(R.id.viewAntoNieva)).check(matches(withText("wulimaqi")));
        onView(withId(R.id.Bnumber)).check(matches(withText("B00123456")));
        onView(withId(R.id.state));
        onView(withId(R.id.department)).check(matches(withText("wulimaqi")));
        onView(withId(R.id.level)).check(matches(withText("undergraduate")));
        onView(withId(R.id.university)).check(matches(withText("Dalhousie")));
        onView(withId(R.id.pass));
    }
    @Test
    //schedule
    public void check3() throws InterruptedException{

        onView(withId(R.id.input_username)).perform(typeText("B00123456"));
        closeSoftKeyboard();
        onView(withId(R.id.input_password)).perform(typeText("123456789"));
        closeSoftKeyboard();
        onView(withId(R.id.btn_login)).perform(click());
        onView(withId(R.id.navigation_schedule));
    }
    @Test
    //registration
    public void check4() throws InterruptedException{

        onView(withId(R.id.input_username)).perform(typeText("B00123456"));
        closeSoftKeyboard();
        onView(withId(R.id.input_password)).perform(typeText("123456789"));
        closeSoftKeyboard();
        onView(withId(R.id.btn_login)).perform(click());
        onView(withId(R.id.navigation_register));
    }

}
