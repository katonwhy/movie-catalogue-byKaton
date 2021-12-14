package com.dicoding.katonmoviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.katonmoviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.katonmoviecatalogue.data.repository.MovieRepository
import com.dicoding.katonmoviecatalogue.vo.Resource

class DetailMovieViewModel (private val movieRepository: MovieRepository): ViewModel() {
    private lateinit var detailMovie: LiveData<Resource<MovieEntity>>

    fun setFilm(id: Int) {
        detailMovie = movieRepository.getDetailMovies(id)
    }

    fun setFavoriteMovie() {
        val resource = detailMovie.value
        if (resource?.data != null) {
            val newState = !resource.data.watchlist
            movieRepository.setFavoriteMovie(resource.data, newState)
        }
    }

    fun getMovie() = detailMovie
}