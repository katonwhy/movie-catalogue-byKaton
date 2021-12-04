package com.dicoding.katonmoviecatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.dicoding.katonmoviecatalogue.R
import com.dicoding.katonmoviecatalogue.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTvshow = DataDummy.generateDummyTvshows()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(withText(dummyMovie[0].genre)))
    }

    @Test
    fun loadTvshows() {
        onView(withText("SERIES")).perform(click())
        onView(withId(R.id.rv_tvshows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvshow.size))
    }

    @Test
    fun loadDetailTvshow() {
        onView(withText("SERIES")).perform(click())
        onView(withId(R.id.rv_tvshows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyTvshow[0].title)))
        onView(withId(R.id.tv_seasons)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_seasons)).check(matches(withText(dummyTvshow[0].seasons)))
    }

}