package com.dicoding.katonmoviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.sqlite.db.SimpleSQLiteQuery
import com.dicoding.katonmoviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.katonmoviecatalogue.data.source.local.entity.TvshowEntity

@Dao
interface FilmDao {
    @Query("SELECT * FROM movie_entities")
    fun getMovies(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM movie_entities WHERE id = :id")
    fun getMovieById(id: Int): LiveData<MovieEntity>

    @Query("SELECT * FROM movie_entities WHERE watchlist = 1")
    fun getFavMovies(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM tv_show_entities")
    fun getTvShows(): LiveData<List<TvshowEntity>>

    @Query("SELECT * FROM tv_show_entities WHERE id = :id")
    fun getTvShowById(id: Int): LiveData<TvshowEntity>

    @Query("SELECT * FROM tv_show_entities WHERE watchlist = 1")
    fun getFavTvShows(): LiveData<List<TvshowEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShows(tvShows: List<TvshowEntity>)

    @Update
    fun updateTvShow(tvShow: TvshowEntity)
}