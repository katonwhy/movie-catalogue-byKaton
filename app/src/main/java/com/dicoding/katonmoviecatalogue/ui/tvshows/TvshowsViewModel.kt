package com.dicoding.katonmoviecatalogue.ui.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.katonmoviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.katonmoviecatalogue.data.repository.MovieRepository
import com.dicoding.katonmoviecatalogue.vo.Resource

class TvshowsViewModel (private val movieRepository: MovieRepository) : ViewModel() {
    fun getTvshows(): LiveData<Resource<List<TvshowEntity>>> = movieRepository.getAllTvShow()
}