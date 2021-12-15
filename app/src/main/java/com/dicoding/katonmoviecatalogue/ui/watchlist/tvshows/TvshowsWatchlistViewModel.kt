package com.dicoding.katonmoviecatalogue.ui.watchlist.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.katonmoviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.katonmoviecatalogue.data.repository.MovieRepository
import com.dicoding.katonmoviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.katonmoviecatalogue.vo.Resource

class TvshowsWatchlistViewModel (private val movieRepository: MovieRepository) : ViewModel() {
    fun getFavTvshows(): LiveData<List<TvshowEntity>> = movieRepository.getFavoriteTvShows()

    fun setFavTvshows(tvshowEntity: TvshowEntity) {
        val newState = !tvshowEntity.watchlist
        movieRepository.setFavoriteTvShow(tvshowEntity, newState)
    }
}