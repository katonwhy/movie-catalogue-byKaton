package com.dicoding.katonmoviecatalogue.ui.movies

import androidx.lifecycle.ViewModel
import com.dicoding.katonmoviecatalogue.data.MovieEntity
import com.dicoding.katonmoviecatalogue.utils.DataDummy

class MoviesViewModel: ViewModel() {
    fun getMovies(): List<MovieEntity> = DataDummy.generateDummyMovies()
}