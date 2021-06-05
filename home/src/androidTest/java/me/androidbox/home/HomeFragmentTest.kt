package me.androidbox.home

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import me.androidbox.home.screens.HomeFragment
import me.androidbox.testing.app.component.TestApplication
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {

    @Before
    fun setup() {
        val footballServices = TestApplication.testApplicationComponent.getFakeFootballService()
    }

    @Test
    fun shouldLaunchFootballApplication() {
         launchFragmentInContainer<HomeFragment>()


        onView(withId(R.id.fragment_home)).check(matches(isDisplayed()))
    }
}