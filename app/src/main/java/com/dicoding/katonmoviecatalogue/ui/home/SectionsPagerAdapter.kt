package com.dicoding.katonmoviecatalogue.ui.home

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dicoding.katonmoviecatalogue.R
import com.dicoding.katonmoviecatalogue.ui.movies.MoviesFragment
import com.dicoding.katonmoviecatalogue.ui.tvshows.TvshowsFragment

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> MoviesFragment()
            1 -> TvshowsFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence = context.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int = 2

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movies, R.string.tvshows)
    }
}