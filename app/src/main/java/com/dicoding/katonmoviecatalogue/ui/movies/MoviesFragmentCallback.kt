package com.dicoding.katonmoviecatalogue.ui.movies

import com.dicoding.katonmoviecatalogue.data.MovieEntity

interface MoviesFragmentCallback {
    fun onShareClick(movie: MovieEntity)
}
