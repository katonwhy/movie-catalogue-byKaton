package com.dicoding.katonmoviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.katonmoviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.katonmoviecatalogue.data.repository.MovieRepository

class DetailTvshowViewModel (private val movieRepository: MovieRepository): ViewModel() {

    fun getTvshow(id : Int) : LiveData<TvshowEntity> = movieRepository.getDetailTvShow(id)
}