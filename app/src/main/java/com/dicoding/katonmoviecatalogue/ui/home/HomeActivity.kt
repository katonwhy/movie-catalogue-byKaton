package com.dicoding.katonmoviecatalogue.ui.home

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.katonmoviecatalogue.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var activityHomeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = activityHomeBinding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = activityHomeBinding.tabs
        tabs.setupWithViewPager(viewPager)

        supportActionBar?.elevation = 0f

    }
}