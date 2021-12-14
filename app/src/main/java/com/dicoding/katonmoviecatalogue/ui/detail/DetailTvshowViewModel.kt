package com.dicoding.katonmoviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.katonmoviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.katonmoviecatalogue.data.repository.MovieRepository
import com.dicoding.katonmoviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.katonmoviecatalogue.vo.Resource

class DetailTvshowViewModel (private val movieRepository: MovieRepository): ViewModel() {
    private lateinit var detailTvShow: LiveData<Resource<TvshowEntity>>

    fun setFilm(id: Int) {
        detailTvShow = movieRepository.getDetailTvShow(id)
    }

    fun setFavoriteTvShow() {
        val resource = detailTvShow.value
        if (resource?.data != null) {
            val newState = !resource.data.watchlist
            movieRepository.setFavoriteTvShow(resource.data, newState)
        }
    }

    fun getTvshow() = detailTvShow
}