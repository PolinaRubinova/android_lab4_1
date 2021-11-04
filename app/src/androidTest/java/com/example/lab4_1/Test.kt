package com.example.lab4_1

import android.content.pm.ActivityInfo
import android.os.SystemClock.sleep
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class Test {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun buttonTest1() {
        onView(withId(R.id.button))
            .check(matches(withText(R.string.button))).perform(click())
            .check(matches(withText(R.string.cl_button))).perform(click())
            .check(matches(withText(R.string.cl_button)))

        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        sleep(5000)

        onView(withId(R.id.button))
            .check(matches(withText(R.string.button))).perform(click())
            .check(matches(withText(R.string.cl_button))).perform(click())
            .check(matches(withText(R.string.cl_button)))
    }

    @Test
    fun buttonTest2() {
        onView(withId(R.id.button))
            .check(matches(withText(R.string.button))).perform(click())
            .check(matches(withText(R.string.cl_button))).perform(click())
            .check(matches(withText(R.string.cl_button)))

        activityRule.scenario.recreate()

        onView(withId(R.id.button))
            .check(matches(withText(R.string.button))).perform(click())
            .check(matches(withText(R.string.cl_button))).perform(click())
            .check(matches(withText(R.string.cl_button)))
    }

    @Test
    fun editTextTest() {
        onView(withId(R.id.text))
            .check(matches(withText("")))
            .perform(typeText("tralala"))

        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        sleep(1000)
        onView(withId(R.id.text)).check(matches(withText("tralala")))
        activityRule.scenario.recreate()
        onView(withId(R.id.text)).check(matches(withText("tralala")))
    }
}