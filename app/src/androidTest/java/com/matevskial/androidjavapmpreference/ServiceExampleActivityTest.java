package com.matevskial.androidjavapmpreference;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;


@RunWith(AndroidJUnit4.class)
public class ServiceExampleActivityTest {

    @Rule
    public ActivityTestRule<ServiceExampleActivity> activityRule
            = new ActivityTestRule<>(ServiceExampleActivity.class);

    @Test
    public void textViewShouldContainAfterButtonClick() {
        Espresso.onView(withId(R.id.startBigNumberServiceButton)).perform(click());

        Espresso.onView(withId(R.id.bigNumberTextView))
                .check(matches(not(withText(""))));
    }
}