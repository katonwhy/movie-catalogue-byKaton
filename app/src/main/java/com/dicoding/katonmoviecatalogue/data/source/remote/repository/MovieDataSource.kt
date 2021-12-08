package com.dicoding.katonmoviecatalogue.data.source.remote.repository

import androidx.lifecycle.LiveData
import com.dicoding.katonmoviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.katonmoviecatalogue.data.source.local.entity.TvshowEntity

interface MovieDataSource {
    fun getAllMovies() : LiveData<List<MovieEntity>>

    fun getDetailMovies(id : Int) : LiveData<MovieEntity>

    fun getAllTvShow() : LiveData<List<TvshowEntity>>

    fun getDetailTvShow(id : Int) : LiveData<TvshowEntity>
}