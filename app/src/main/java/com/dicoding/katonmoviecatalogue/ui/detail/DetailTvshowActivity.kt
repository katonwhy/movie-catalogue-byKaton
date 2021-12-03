package com.dicoding.katonmoviecatalogue.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.katonmoviecatalogue.R

class DetailTvshowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tvshow)
    }

    companion object {
        const val EXTRA_TVSHOW = "extra_tvshow"
    }
}