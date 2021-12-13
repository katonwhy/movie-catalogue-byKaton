package com.dicoding.katonmoviecatalogue.data.repository

import androidx.lifecycle.LiveData
import com.dicoding.katonmoviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.katonmoviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.katonmoviecatalogue.vo.Resource

interface MovieDataSource {
    fun getAllMovies() : LiveData<Resource<List<MovieEntity>>>

    fun getDetailMovies(id : Int) : LiveData<Resource<MovieEntity>>

    fun getFavoriteMovies(): LiveData<List<MovieEntity>>

    fun setFavoriteMovie(movie: MovieEntity, state: Boolean)

    fun getAllTvShow() : LiveData<Resource<List<TvshowEntity>>>

    fun getDetailTvShow(id : Int) : LiveData<Resource<TvshowEntity>>

    fun getFavoriteTvShows(): LiveData<List<TvshowEntity>>

    fun setFavoriteTvShow(tvShow: TvshowEntity, state: Boolean)
}