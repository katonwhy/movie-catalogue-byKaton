package com.dicoding.katonmoviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.katonmoviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.katonmoviecatalogue.data.source.remote.repository.MovieRepository

class DetailMovieViewModel (private val movieRepository: MovieRepository): ViewModel() {

    fun getMovie(id : Int) : LiveData<MovieEntity> = movieRepository.getDetailMovies(id)
}