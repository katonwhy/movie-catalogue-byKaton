package com.dicoding.katonmoviecatalogue.ui.movies

import com.dicoding.katonmoviecatalogue.data.source.local.entity.MovieEntity

interface MoviesFragmentCallback {
    fun onShareClick(movie: MovieEntity)
}
