package com.dicoding.katonmoviecatalogue.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.katonmoviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.katonmoviecatalogue.data.repository.MovieRepository
import com.dicoding.katonmoviecatalogue.vo.Resource

class MoviesViewModel (private val movieRepository: MovieRepository) : ViewModel() {
    fun getMovies(): LiveData<Resource<List<MovieEntity>>> = movieRepository.getAllMovies()
}