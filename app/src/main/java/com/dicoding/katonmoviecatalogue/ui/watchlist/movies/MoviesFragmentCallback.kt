package com.dicoding.katonmoviecatalogue.ui.watchlist.movies

import com.dicoding.katonmoviecatalogue.data.source.local.entity.MovieEntity

interface MoviesFragmentCallback {
    fun onShareClick(movie: MovieEntity)
}
