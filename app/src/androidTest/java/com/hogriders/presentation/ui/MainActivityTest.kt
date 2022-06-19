package com.hogriders.presentation.ui


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.hogriders.daggerexample.R
import org.hamcrest.CoreMatchers.not


@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {
    @get:Rule
    val mainActivityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun shouldTextViewBeVisible(){
        onView(withId(R.id.text_view)).check(matches(isDisplayed()))
    }

    @Test
    fun shouldTextNotBeHelloWorld(){
        onView(withId(R.id.text_view)).check(
            matches(
                not(
                    withText(R.string.preview_text)
                )
            )
        )
    }
}