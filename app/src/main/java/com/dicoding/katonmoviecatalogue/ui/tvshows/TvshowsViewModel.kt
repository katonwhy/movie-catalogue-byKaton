package com.dicoding.katonmoviecatalogue.ui.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.katonmoviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.katonmoviecatalogue.data.source.remote.repository.MovieRepository
import com.dicoding.katonmoviecatalogue.utils.DataDummy

class TvshowsViewModel (private val movieRepository: MovieRepository) : ViewModel() {
    fun getTvshows(): LiveData<List<TvshowEntity>> = movieRepository.getAllTvShow()
}