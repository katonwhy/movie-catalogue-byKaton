package com.dicoding.katonmoviecatalogue.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.katonmoviecatalogue.R

class DetailMovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
    }

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }
}