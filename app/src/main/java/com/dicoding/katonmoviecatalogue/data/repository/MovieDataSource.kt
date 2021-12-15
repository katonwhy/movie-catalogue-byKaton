package com.dicoding.katonmoviecatalogue.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dicoding.katonmoviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.katonmoviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.katonmoviecatalogue.vo.Resource

interface MovieDataSource {
    fun getAllMovies() : LiveData<Resource<PagedList<MovieEntity>>>

    fun getDetailMovies(id : Int) : LiveData<Resource<MovieEntity>>

    fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>>

    fun setFavoriteMovie(movie: MovieEntity, state: Boolean)

    fun getAllTvShow() : LiveData<Resource<PagedList<TvshowEntity>>>

    fun getDetailTvShow(id : Int) : LiveData<Resource<TvshowEntity>>

    fun getFavoriteTvShows(): LiveData<PagedList<TvshowEntity>>

    fun setFavoriteTvShow(tvShow: TvshowEntity, state: Boolean)
}