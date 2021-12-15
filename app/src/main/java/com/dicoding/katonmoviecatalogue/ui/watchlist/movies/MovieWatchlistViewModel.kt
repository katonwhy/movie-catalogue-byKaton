package com.dicoding.katonmoviecatalogue.ui.watchlist.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.katonmoviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.katonmoviecatalogue.data.repository.MovieRepository
import com.dicoding.katonmoviecatalogue.vo.Resource

class MovieWatchlistViewModel (private val movieRepository: MovieRepository) : ViewModel() {
    fun getFavMovies(): LiveData<List<MovieEntity>> = movieRepository.getFavoriteMovies()

    fun setFavMovie(movieEntity: MovieEntity) {
        val newState = !movieEntity.watchlist
        movieRepository.setFavoriteMovie(movieEntity, newState)
    }
}