package com.dicoding.katonmoviecatalogue.data.source.remote.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.katonmoviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.katonmoviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.katonmoviecatalogue.data.source.remote.RemoteDataSource
import com.dicoding.katonmoviecatalogue.data.source.remote.response.DetailMovies
import com.dicoding.katonmoviecatalogue.data.source.remote.response.DetailTvShow
import com.dicoding.katonmoviecatalogue.data.source.remote.response.Movies
import com.dicoding.katonmoviecatalogue.data.source.remote.response.TvShow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.lang.StringBuilder

class MovieRepository private constructor(private val remoteDataSource: RemoteDataSource)
    : MovieDataSource {

    companion object {
        private var instance : MovieRepository? = null

        fun getInstace(remoteDataSource: RemoteDataSource) : MovieRepository =
            instance ?: synchronized(this){
                instance ?: MovieRepository(remoteDataSource).apply { instance = this }
            }

    }

    override fun getAllMovies(): LiveData<List<MovieEntity>> {
        val movieResult = MutableLiveData<List<MovieEntity>>()
        CoroutineScope(IO).launch {
            remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMovies {
                override fun onAllMoviesReceived(responseMovies: List<Movies>) {
                    val moviesData = ArrayList<MovieEntity>()
                    for (i in responseMovies) {
                        val movie = MovieEntity(
                            movieId = i.id,
                            title = i.title,
                            description = i.overview,
                            release = i.date,
                            image = i.poster,
                            rating = i.rating,
                            genre = "",
                            duration = i.runtime
                        )
                        moviesData.add(movie)
                    }
                    movieResult.postValue(moviesData)
                }
            })
        }
        return movieResult
    }

    override fun getDetailMovies(id : Int): LiveData<MovieEntity> {
        val dataMovie = MutableLiveData<MovieEntity>()
        CoroutineScope(IO).launch {
            remoteDataSource.getDetailMovies(id, object : RemoteDataSource.LoadDetailMovies {
                override fun onDetailMoviesReceived(responseMovie: DetailMovies) {
                    val genres = StringBuilder().append("")

                    for (i in responseMovie.genres!!.indices) {
                        if (i < responseMovie.genres.size - 1) {
                            genres.append("${responseMovie.genres[i].name}, ")
                        } else{
                            genres.append(responseMovie.genres[i].name)
                        }
                    }

                    val movie = MovieEntity(
                        movieId = responseMovie.id,
                        title = responseMovie.title,
                        description = responseMovie.overview,
                        release = responseMovie.date,
                        image = responseMovie.poster,
                        rating = responseMovie.rating,
                        duration = responseMovie.runtime,
                        genre = genres.toString()
                    )

                    dataMovie.postValue(movie)
                }
            })
        }
        return dataMovie
    }

    override fun getAllTvShow(): LiveData<List<TvshowEntity>> {
        val tvlist = MutableLiveData<List<TvshowEntity>>()
        CoroutineScope(IO).launch {
            remoteDataSource.getTvShows(object : RemoteDataSource.LoadTvShows{
                override fun onAllTvReceived(responseTv: List<TvShow>) {
                    val tvshows = ArrayList<TvshowEntity>()
                    for (i in responseTv){
                        val tv = TvshowEntity(
                            tvshowId = i.id,
                            title = i.original_name,
                            description = i.overview,
                            release = i.date,
                            image = i.poster,
                            rating = i.rating,
                            genre = "",
                            seasons = 0,
                        )
                        tvshows.add(tv)
                    }
                    tvlist.postValue(tvshows)
                }
            })
        }

        return tvlist
    }

    override fun getDetailTvShow(id: Int): LiveData<TvshowEntity> {
        val dataTv = MutableLiveData<TvshowEntity>()
        CoroutineScope(IO).launch {
            remoteDataSource.getTvShowDetail(id, object : RemoteDataSource.LoadTvShowsDetail{
                override fun onTvShowsDetail(responseTv: DetailTvShow) {
                    val genre = StringBuilder().append("")

                    for (i in responseTv.genres.indices){
                        if (i < responseTv.genres.size - 1){
                            genre.append("${responseTv.genres[i].name}, ")
                        } else {
                            genre.append(responseTv.genres[i].name)
                        }
                    }

                    val tv = TvshowEntity(
                        tvshowId = responseTv.id,
                        title = responseTv.original_name,
                        description = responseTv.overview,
                        release = responseTv.date,
                        image = responseTv.poster,
                        rating = responseTv.rating,
                        seasons = responseTv.seasons,
                        genre = genre.toString()
                    )
                    dataTv.postValue(tv)
                }
            })
        }
        return dataTv
    }
}