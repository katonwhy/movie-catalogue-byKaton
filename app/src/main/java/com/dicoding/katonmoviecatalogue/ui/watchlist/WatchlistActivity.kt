package com.dicoding.katonmoviecatalogue.ui.watchlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.katonmoviecatalogue.R
import com.dicoding.katonmoviecatalogue.databinding.ActivityHomeBinding
import com.dicoding.katonmoviecatalogue.databinding.ActivityWatchlistBinding
import com.dicoding.katonmoviecatalogue.ui.home.SectionsPagerAdapter

class WatchlistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityWatchlistBinding = ActivityWatchlistBinding.inflate(layoutInflater)
        setContentView(activityWatchlistBinding.root)

        val watchlistPagerAdapter = WatchlistPagerAdapter(this, supportFragmentManager)

        activityWatchlistBinding.viewPager.adapter = watchlistPagerAdapter
        activityWatchlistBinding.tabs.setupWithViewPager(activityWatchlistBinding.viewPager)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportActionBar?.elevation = 0f
    }
}