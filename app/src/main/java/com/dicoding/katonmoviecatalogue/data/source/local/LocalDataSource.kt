package com.dicoding.katonmoviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import com.dicoding.katonmoviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.katonmoviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.katonmoviecatalogue.data.source.local.room.FilmDao

class LocalDataSource(private val mFilmDao: FilmDao) {
    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(filmDao: FilmDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(filmDao)
    }

    fun getAllMovies(): LiveData<List<MovieEntity>> = mFilmDao.getMovies()

    fun getMovieById(id: Int): LiveData<MovieEntity> = mFilmDao.getMovieById(id)

    fun getFavMovies(): LiveData<List<MovieEntity>> = mFilmDao.getFavMovies()

    fun getAllTvShows(): LiveData<List<TvshowEntity>> = mFilmDao.getTvShows()

    fun getTvShowById(id: Int): LiveData<TvshowEntity> = mFilmDao.getTvShowById(id)

    fun getFavTvShows(): LiveData<List<TvshowEntity>> = mFilmDao.getFavTvShows()

    fun insertMovies(movies: List<MovieEntity>) = mFilmDao.insertMovies(movies)

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
        movie.watchlist = newState
        mFilmDao.updateMovie(movie)
    }

    fun updateMovie(movie: MovieEntity, newState: Boolean) {
        movie.watchlist = newState
        mFilmDao.updateMovie(movie)
    }

    fun insertTvShows(tvShows: List<TvshowEntity>) = mFilmDao.insertTvShows(tvShows)

    fun setFavoriteTvShow(tvShow: TvshowEntity, newState: Boolean) {
        tvShow.watchlist = newState
        mFilmDao.updateTvShow(tvShow)
    }

    fun updateTvShow(tvShow: TvshowEntity, newState: Boolean) {
        tvShow.watchlist = newState
        mFilmDao.updateTvShow(tvShow)
    }
}