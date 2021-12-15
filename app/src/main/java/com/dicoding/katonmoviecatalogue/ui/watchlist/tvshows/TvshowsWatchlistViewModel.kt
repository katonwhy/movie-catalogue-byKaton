package com.dicoding.katonmoviecatalogue.ui.watchlist.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.katonmoviecatalogue.data.repository.MovieRepository
import com.dicoding.katonmoviecatalogue.data.source.local.entity.TvshowEntity

class TvshowsWatchlistViewModel (private val movieRepository: MovieRepository) : ViewModel() {
    fun getFavTvshows(): LiveData<PagedList<TvshowEntity>> = movieRepository.getFavoriteTvShows()

    fun setFavTvshows(tvshowEntity: TvshowEntity) {
        val newState = !tvshowEntity.watchlist
        movieRepository.setFavoriteTvShow(tvshowEntity, newState)
    }
}