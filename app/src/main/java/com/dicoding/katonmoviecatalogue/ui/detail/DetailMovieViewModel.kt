package com.dicoding.katonmoviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.katonmoviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.katonmoviecatalogue.data.repository.MovieRepository
import com.dicoding.katonmoviecatalogue.vo.Resource

class DetailMovieViewModel (private val movieRepository: MovieRepository): ViewModel() {

    fun getMovie(id : Int) : LiveData<Resource<MovieEntity>> = movieRepository.getDetailMovies(id)
}