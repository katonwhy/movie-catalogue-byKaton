package com.dicoding.katonmoviecatalogue.ui.detail

import androidx.lifecycle.ViewModel
import com.dicoding.katonmoviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.katonmoviecatalogue.utils.DataDummy

class DetailMovieViewModel: ViewModel() {

    private lateinit var movieId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun getMovie(): MovieEntity {
        lateinit var movie: MovieEntity
        val movies = DataDummy.generateDummyMovies()
        for (movieEntity in movies) {
            if (movieEntity.movieId == movieId) {
                movie = movieEntity
            }
        }
        return movie
    }
}